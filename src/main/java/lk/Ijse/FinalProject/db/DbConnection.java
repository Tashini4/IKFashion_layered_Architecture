package lk.Ijse.FinalProject.db;

import net.sf.jasperreports.engine.JRDataSource;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private static Connection connection;


    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/IkFashion",
                "root",
                "Ijse@123"
        );
    }

    public static DbConnection getDbConnection() throws SQLException {
        return dbConnection == null ? dbConnection= new DbConnection() : dbConnection;
    }

    public static Connection getConnection() {
        return connection;
    }
}






