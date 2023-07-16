package com.example.dataDictionary;

public class ColumnData {
    private String tableName;
    private String columnName;
    private String dataType;
    private String columnType;
    private String columnKey;
    private String isNullable;
    private String columnDefault;

    public ColumnData(String tableName, String columnName, String dataType, String columnType,
                      String columnKey, String isNullable, String columnDefault) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.dataType = dataType;
        this.columnType = columnType;
        this.columnKey = columnKey;
        this.isNullable = isNullable;
        this.columnDefault = columnDefault;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }
}

