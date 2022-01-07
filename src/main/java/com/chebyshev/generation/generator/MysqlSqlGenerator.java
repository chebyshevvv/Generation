package com.chebyshev.generation.generator;

import com.chebyshev.generation.factory.ColumnResolverFactory;
import com.chebyshev.generation.factory.ColumnScannerFactory;
import com.chebyshev.generation.factory.TableResolverFactory;
import com.chebyshev.generation.factory.TableScannerFactory;
import java.util.List;

/**
 * @author zwk
 * @date 2022/1/6
 * @description TODO
 **/
public class MysqlSqlGenerator extends AbstractSqlGenerator{

    protected MysqlSqlGenerator(ColumnResolverFactory columnResolverFactory,
                                TableResolverFactory tableResolverFactory,
                                ColumnScannerFactory columnScannerFactory,
                                TableScannerFactory tableScannerFactory) {
        super(columnResolverFactory, tableResolverFactory, columnScannerFactory, tableScannerFactory);
    }

    @Override
    protected String generateSql(List<SqlVariablesOfTable> tables) {
        StringBuilder sql = new StringBuilder();
        for (SqlVariablesOfTable  table: tables) {
            StringBuilder sb = new StringBuilder()
                    .append("CREATE TABLE ")
                    .append(table.getTableName())
                    .append("(");
            for (SqlVariablesOfColumn column : table.getColumns()) {
                sb.append(column.getColumnName())
                        .append(" ")
                        .append(column.getColumnType())
                        .append("(").append(column.getColumnLength()).append(")");
                if (column.isNotNull()) sb.append(" NOT NULL");
                if (column.isUnique()) sb.append(" UNIQUE");
                sb.append(",");
            }
            sb.append("PRIMARY KEY (")
                    .append(table.getTableKey())
                    .append(")")
                    .append(");");
            sql.append(sb);
        }
        return sql.toString();
    }
}
