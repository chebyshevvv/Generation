package com.chebyshev.generation.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwk
 * @date 2022/1/5
 * @description TODO
 **/
public class SqlVariablesOfTable {

    private final String tableName;
    private final String tableNote;
    private final String tableKey;
    private final String index;
    private final List<SqlVariablesOfColumn> columns = new ArrayList<>();

    public SqlVariablesOfTable(String tableName,
                               String tableNote,
                               String tableKey,
                               String index,
                               List<SqlVariablesOfColumn> columns) {
        this.tableName = tableName;
        this.tableNote = tableNote;
        this.tableKey = tableKey;
        this.index = index;
        this.columns.addAll(columns);
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableNote() {
        return tableNote;
    }

    public String getTableKey() {
        return tableKey;
    }

    public String getIndex() {
        return index;
    }

    public List<SqlVariablesOfColumn> getColumns() {
        return columns;
    }

}
