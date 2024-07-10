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


    public Map<String, Integer> GetDailyOrderCounts() throws SQLException, ClassNotFoundException {
        return orderDAO.GetDailyOrderCounts();
    }


    public Map<String, Integer> GetDailyIncome() throws SQLException, ClassNotFoundException {
        return orderDAO.GetDailyIncome();
    }


    public String getCurrentId() throws SQLException, ClassNotFoundException {
        return orderDAO.getCurrentId();
    }


    public String getPayCurrentId() throws SQLException, ClassNotFoundException {
        return orderDAO.getPayCurrentId();

    }

    @Override
    public List<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Order customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Order searchById(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
