package lk.Ijse.FinalProject.BO.custom.impl;

import lk.Ijse.FinalProject.dao.Custom.OrderDAO;
import lk.Ijse.FinalProject.dao.Custom.impl.OrderDAOImpl;
import lk.Ijse.FinalProject.dao.DAOFactory;
import lk.Ijse.FinalProject.entity.Order;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

public class OrderBOImpl implements OrderDAO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

@Override
    public Map<String, Integer> GetDailyOrderCounts() throws SQLException, ClassNotFoundException {
        return orderDAO.GetDailyOrderCounts();
    }

@Override
    public Map<String, Integer> GetDailyIncome() throws SQLException, ClassNotFoundException {
        return orderDAO.GetDailyIncome();
    }

@Override
    public String getCurrentId() throws SQLException, ClassNotFoundException {
        return orderDAO.getCurrentId();
    }

@Override
    public String getPayCurrentId() throws SQLException, ClassNotFoundException {
        return orderDAO.getPayCurrentId();

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
