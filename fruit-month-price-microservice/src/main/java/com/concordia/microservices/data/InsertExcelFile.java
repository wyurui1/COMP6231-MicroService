package com.concordia.microservices.data;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.poi.ss.usermodel.*;

public class InsertExcelFile {
	public InsertExcelFile(String fileName) {
        String jdbcUrl = "jdbc:h2:mem:testdb";
        String username = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            FileInputStream file = new FileInputStream(fileName);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();

            Row headerRow = sheet.getRow(0);
            int numColumns = headerRow.getLastCellNum();

            StringBuilder insertSQLBuilder = new StringBuilder("INSERT INTO \"fruit_month_price\" (\"fruit\", \"month\", \"fmp\")");
            insertSQLBuilder.append(" VALUES (?,?,?)");

            String insertSQL = insertSQLBuilder.toString();
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                String fruitName = dataFormatter.formatCellValue(row.getCell(0));
                for (int colIndex = 1; colIndex < numColumns; colIndex++) {
                    double fruitPrice = row.getCell(colIndex).getNumericCellValue();
                    String formattedPrice = String.format("%.2f", fruitPrice);
                    double roundedPrice = Double.parseDouble(formattedPrice);
                 
                    String month = dataFormatter.formatCellValue(headerRow.getCell(colIndex));
                    preparedStatement.setString(1, fruitName);
                    preparedStatement.setString(2, month);
                    preparedStatement.setDouble(3, roundedPrice);
                    preparedStatement.executeUpdate();
                }
            }

            preparedStatement.close();
            workbook.close();
            file.close();

            System.out.println("Data inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
