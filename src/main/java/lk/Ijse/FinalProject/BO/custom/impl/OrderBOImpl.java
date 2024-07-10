package lk.Ijse.FinalProject.BO.custom.impl;

import lk.Ijse.FinalProject.dao.Custom.OrderDAO;
import lk.Ijse.FinalProject.dao.Custom.impl.OrderDAOImpl;
import lk.Ijse.FinalProject.dao.DAOFactory;

import java.sql.SQLException;

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
}
