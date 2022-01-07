package com.chebyshev.generation.generator;

/**
 * @author zwk
 * @date 2022/1/6
 * @description TODO
 **/
public class SqlVariablesOfColumn {

    private final String columnName;
    private final String columnNote;
    private final String columnType;
    private final String columnLength;
    private final boolean notNull;
    private final boolean unique;

    public SqlVariablesOfColumn(String columnName,
                                String columnNote,
                                String columnType,
                                String columnLength,
                                boolean notNull,
                                boolean unique) {
        this.columnName = columnName;
        this.columnNote = columnNote;
        this.columnType = columnType;
        this.columnLength = columnLength;
        this.notNull = notNull;
        this.unique = unique;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnNote() {
        return columnNote;
    }

    public String getColumnType() {
        return columnType;
    }

    public String getColumnLength() {
        return columnLength;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public boolean isUnique() {
        return unique;
    }
}
