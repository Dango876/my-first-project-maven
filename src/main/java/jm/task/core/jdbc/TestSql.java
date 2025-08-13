package jm.task.core.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TestSql {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("scr/main/resources/sql.properties")) {
            properties.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root",
                "root");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT ID, Name, District FROM world.city");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + " " + resultSet.getString("Name") + " " +
                    resultSet.getString("District"));
        }

        connection.close();
    }
}
