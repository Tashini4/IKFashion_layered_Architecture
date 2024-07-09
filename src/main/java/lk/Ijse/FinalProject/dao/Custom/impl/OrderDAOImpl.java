package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OrderDAOImpl {
    public static Map<String, Integer> GetDailyOrderCounts() throws SQLException {
        String sql = "SELECT orderDate, COUNT(OrderId) AS orderCount FROM orders GROUP BY orderDate ";
        Map<String, Integer> orderDetails = new HashMap<>();

        PreparedStatement pvsm = DbConnection.getConnection().prepareStatement(sql);

        ResultSet resultSet = pvsm.executeQuery();

        while (resultSet.next()) {

            orderDetails.put(
                    resultSet.getString("OrderDate"),
                    resultSet.getInt("OrderCount")
            );
        }

        return orderDetails;
    }

    public static Map<String, Integer> GetDailyIncome() throws SQLException {
        String sql = "SELECT orderDate, SUM(orderId) AS totalIncome FROM orders GROUP BY orderDate";
        Map<String, Integer> orderDetails = new HashMap<>();

        PreparedStatement pvsm = DbConnection.getConnection().prepareStatement(sql);
        ResultSet resultSet = pvsm.executeQuery();

        while (resultSet.next()) {
            orderDetails.put(
                    resultSet.getString("orderDate"),
                    resultSet.getInt("totalIncome")
            );
        }

        return orderDetails;
    }

    public String getCurrentId() {
    }

    public String getPayCurrentId() {
    }
}


