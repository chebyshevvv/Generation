package com.chebyshev.generation.builder;

import com.chebyshev.generation.generator.SqlVariablesOfColumn;

/**
 * @author zwk
 * @date 2022/1/6
 * @description TODO
 **/
public class ColumnVariablesBuilder {

    private String columnName;
    private String columnNote;
    private String columnType;
    private String columnLength;
    private boolean notNull;
    private boolean unique;

    public ColumnVariablesBuilder setColumnLength(String columnLength) {
        this.columnLength = columnLength;
        return this;
    }

    public ColumnVariablesBuilder setColumnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    public ColumnVariablesBuilder setColumnNote(String columnNote) {
        this.columnNote = columnNote;
        return this;
    }

    public ColumnVariablesBuilder setColumnType(String columnType) {
        this.columnType = columnType;
        return this;
    }

    public ColumnVariablesBuilder setNotNull(boolean notNull) {
        this.notNull = notNull;
        return this;
    }

    public ColumnVariablesBuilder setUnique(boolean unique) {
        this.unique = unique;
        return this;
    }

    public SqlVariablesOfColumn build(){
        return new SqlVariablesOfColumn(this.columnName,this.columnNote,this.columnType,this.columnLength,this.notNull,this.unique);
    }
}
