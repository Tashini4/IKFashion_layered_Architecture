package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.PaymentDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.PaymentDTO;
import lk.Ijse.FinalProject.entity.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment payment) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public  boolean save(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO payments VALUES(?,?,?)",paymentDTO.getPaymentId(),paymentDTO.getPaymentAmount(),paymentDTO.getPaymentDate());
    }
    @Override
    public Payment searchById(String id) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM payments WHERE paymentId = ?",id);
        if (resultSet.next()){
            String paymentId = resultSet.getString(1);
            double amount = Double.parseDouble((resultSet.getString(2)));
            Date date = Date.valueOf(resultSet.getString(3));


            Payment payment = new Payment(paymentId,amount,date);
            return payment;

        }
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public  List<Payment> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute( "SELECT * FROM payments");

        List<Payment> paymentList = new ArrayList<>();

        while (resultSet.next()) {
            String paymentId = resultSet.getString(1);
            double amount = Integer.parseInt(resultSet.getString(2));
            Date date = Date.valueOf(resultSet.getString(3));

            Payment payment = new Payment(paymentId,amount,date);
            paymentList.add(payment);
        }
        return paymentList;
    }

    @Override
    public boolean update(Payment customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public  List<String> getIds() throws SQLException, ClassNotFoundException {

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = SQLUtil.execute("SELECT paymentId FROM payments");
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            idList.add(id);
        }
        return idList;
    }

}
