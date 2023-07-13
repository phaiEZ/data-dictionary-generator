package com.example.dataDictionary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class columnMetaData {
    private String tableName;
    private String columnName;
    private String dataType;
    private String columnKey;
    private String nullable;
    private String columnDefault;
}

