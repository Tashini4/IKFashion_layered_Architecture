package lk.Ijse.FinalProject.dao;

import lk.ijse.entity.Order;

import java.sql.SQLException;
import java.util.Map;

public interface OrderDAO extends CrudDAO<Order> {
    public String getCurrentId() throws SQLException, ClassNotFoundException;

    public String getPayCurrentId() throws SQLException, ClassNotFoundException;

    public boolean save(Order order) throws SQLException, ClassNotFoundException;

    public Map<String, Integer> GetDailyOrderCounts() throws SQLException, ClassNotFoundException;


    public  Map<String, Integer> GetDailyIncome() throws SQLException, ClassNotFoundException;
}
