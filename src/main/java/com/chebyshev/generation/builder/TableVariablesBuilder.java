package com.chebyshev.generation.builder;

import com.chebyshev.generation.generator.SqlVariablesOfColumn;
import com.chebyshev.generation.generator.SqlVariablesOfTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwk
 * @date 2022/1/6
 * @description TODO
 **/
public class TableVariablesBuilder {
    private String tableName;
    private String tableNote;
    private String tableKey;
    private String index;
    private List<SqlVariablesOfColumn> columns = new ArrayList<>();

    public TableVariablesBuilder setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public TableVariablesBuilder setTableNote(String tableNote) {
        this.tableNote = tableNote;
        return this;
    }

    public TableVariablesBuilder setTableKey(String tableKey) {
        this.tableKey = tableKey;
        return this;
    }

    public TableVariablesBuilder setIndex(String index) {
        this.index = index;
        return this;
    }

    public TableVariablesBuilder setColumns(List<SqlVariablesOfColumn> columns) {
        this.columns = columns;
        return this;
    }

    public SqlVariablesOfTable build(){
        return new SqlVariablesOfTable(this.tableName, this.tableNote,this.tableKey,this.index,this.columns);
    }
}
