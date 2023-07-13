package com.example.dataDictionary;
import io.r2dbc.spi.ColumnMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password)) {
            // Connection successful, perform database operations here

            String selectQuery = "SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, COLUMN_TYPE, COLUMN_KEY, IS_NULLABLE, COLUMN_DEFAULT " +
                    "FROM information_schema.columns WHERE TABLE_SCHEMA = 'outbox'";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {

                List<ColumnMetadata> columnMetadataList = new ArrayList<>();

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }

//                while (resultSet.next()) {
//                    ColumnMetadata columnMetadata = new ColumnMetadata();
//                    columnMetadata.setTableName(resultSet.getString("TABLE_NAME"));
//                    columnMetadata.setColumnName(resultSet.getString("COLUMN_NAME"));
//                    columnMetadata.setDataType(resultSet.getString("DATA_TYPE"));
//                    columnMetadata.setColumnKey(resultSet.getString("COLUMN_KEY"));
//                    columnMetadata.setNullable(resultSet.getString("IS_NULLABLE"));
//                    columnMetadata.setColumnDefault(resultSet.getString("COLUMN_DEFAULT"));
//
//                    columnMetadataList.add(columnMetadata);
//                }

                model.addAttribute("columnMetadataList", columnMetadataList);
                return "success";
            }

        } catch (SQLException e) {
            // Connection or database operation failed
            e.printStackTrace();
        }

        // Database operation failed
        return "error";
    }
}