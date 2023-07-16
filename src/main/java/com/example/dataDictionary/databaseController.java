package com.example.dataDictionary;
import io.r2dbc.spi.ColumnMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// AAAAA
@Controller
public class databaseController {

    @PostMapping("/upload")
    public String handleFormSubmission(@RequestParam("username") String username,
                                       @RequestParam("password") String password,
                                       @RequestParam("server") String server,
                                       @RequestParam("port") String port,
                                       @RequestParam("database") String database,
                                       Model model) {

        String dbUrl = "jdbc:mysql://" + server + ":" + port + "/" + database;
        List<ColumnData> columnDataList = new ArrayList<>(); // Create a list to store the column data

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password)) {

            String selectQuery = "SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, COLUMN_TYPE, COLUMN_KEY, IS_NULLABLE, COLUMN_DEFAULT " +
                    "FROM information_schema.columns WHERE TABLE_SCHEMA = 'outbox'";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                    String tableName = resultSet.getString("TABLE_NAME");
                    String columnName = resultSet.getString("COLUMN_NAME");
                    String dataType = resultSet.getString("DATA_TYPE");
                    String columnType = resultSet.getString("COLUMN_TYPE");
                    String columnKey = resultSet.getString("COLUMN_KEY");
                    String isNullable = resultSet.getString("IS_NULLABLE");
                    String columnDefault = resultSet.getString("COLUMN_DEFAULT");

                    ColumnData columnData = new ColumnData(tableName, columnName, dataType, columnType, columnKey, isNullable, columnDefault);

                    columnDataList.add(columnData);
                }

                createDocx.createDocument();
                return "success";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "error";
    }
}
