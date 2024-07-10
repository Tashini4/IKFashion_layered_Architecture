package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.OrderDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.entity.Order;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public  Map<String, Integer> GetDailyOrderCounts() throws SQLException, ClassNotFoundException {

        Map<String, Integer> orderDetails = new HashMap<>();

        ResultSet resultSet = SQLUtil.execute("SELECT orderDate, COUNT(OrderId) AS orderCount FROM orders GROUP BY orderDate ");

        while (resultSet.next()) {

            orderDetails.put(
                    resultSet.getString("OrderDate"),
                    resultSet.getInt("OrderCount")
            );
        }

        return orderDetails;
    }
@Override
    public  Map<String, Integer> GetDailyIncome() throws SQLException, ClassNotFoundException {

        Map<String, Integer> orderDetails = new HashMap<>();

        ResultSet resultSet = SQLUtil.execute("SELECT orderDate, SUM(orderId) AS totalIncome FROM orders GROUP BY orderDate");

        while (resultSet.next()) {
            orderDetails.put(
                    resultSet.getString("orderDate"),
                    resultSet.getInt("totalIncome")
            );
        }

        return orderDetails;
    }
@Override
    public String getCurrentId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT MAX(CAST(SUBSTRING(orderId, 2) AS UNSIGNED)) AS HighestOrderId FROM orders");
        if (resultSet.next()) {
            String orderId = resultSet.getString(1);
            return orderId;
        }
        return null;
    }
@Override
    public String getPayCurrentId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute( "SELECT paymentId FROM payments ORDER BY paymentId LIMIT 1");
        if (resultSet.next()) {
            String paymentId = resultSet.getString(1);
            return paymentId;
        }
        return null;
    }

    @Override
    public List<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order order) throws SQLException, ClassNotFoundException {
        return false;
    }
}



