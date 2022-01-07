package com.chebyshev.generation.generator;


import com.chebyshev.generation.builder.ColumnVariablesBuilder;
import com.chebyshev.generation.builder.TableVariablesBuilder;
import com.chebyshev.generation.factory.ColumnResolverFactory;
import com.chebyshev.generation.factory.ColumnScannerFactory;
import com.chebyshev.generation.factory.TableResolverFactory;
import com.chebyshev.generation.factory.TableScannerFactory;
import com.chebyshev.generation.resolver.ColumnResolver;
import com.chebyshev.generation.resolver.TableResolver;
import com.chebyshev.generation.scanner.ColumnScanner;
import com.chebyshev.generation.scanner.TableScanner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zwk
 * @date 2022/1/5
 * @description TODO
 **/
public abstract class AbstractSqlGenerator implements SqlGenerator{

    private final ColumnResolverFactory columnResolverFactory;
    private final TableResolverFactory tableResolverFactory;
    private final ColumnScanner columnScanner;
    private final TableScanner tableScanner;

    protected AbstractSqlGenerator(ColumnResolverFactory columnResolverFactory,
                                   TableResolverFactory tableResolverFactory,
                                   ColumnScannerFactory columnScannerFactory,
                                   TableScannerFactory tableScannerFactory) {
        this.columnResolverFactory = columnResolverFactory;
        this.tableResolverFactory = tableResolverFactory;
        this.columnScanner = columnScannerFactory.createScanner();
        this.tableScanner = tableScannerFactory.createScanner();
    }

    @Override
    public String generateSql() {
        List<SqlVariablesOfTable> variables = this.variables();
        if (variables.size() <= 0){
            return "";
        }
        return this.generateSql(variables);
    }

    private List<SqlVariablesOfTable> variables(){

        Class[] classes = this.tableScanner.scanClassInPackage();
        List<SqlVariablesOfTable> list = new ArrayList<>(0);

        if (null != classes && classes.length > 0){

            for (Class aClass : classes) {

                Field[] fields = this.columnScanner.scannFieldInClass(aClass);
                List<ColumnResolver> columnResolvers = this.columnResolverFactory.createResolver(fields);
                List<SqlVariablesOfColumn> sqlVariablesOfColumnList = new ArrayList<>();
                for (ColumnResolver columnResolver : columnResolvers) {
                    ColumnVariablesBuilder columnVariablesBuilder = new ColumnVariablesBuilder();
                    SqlVariablesOfColumn variablesOfColumn = columnVariablesBuilder
                            .setColumnName(columnResolver.column())
                            .setColumnType(columnResolver.type())
                            .setColumnNote(columnResolver.note())
                            .build();
                    sqlVariablesOfColumnList.add(variablesOfColumn);
                }

                TableVariablesBuilder tableVariablesBuilder = new TableVariablesBuilder();
                TableResolver tableResolver = this.tableResolverFactory.createResolver(aClass);
                SqlVariablesOfTable variablesOfTable = tableVariablesBuilder
                        .setTableName(tableResolver.tableName())
                        .setTableNote(tableResolver.note())
                        .setTableKey(tableResolver.key())
                        .setIndex(tableResolver.index())
                        .setColumns(sqlVariablesOfColumnList)
                        .build();
                list.add(variablesOfTable);
            }
        }
        return list;
    }

    protected abstract String generateSql(List<SqlVariablesOfTable> table);
}
