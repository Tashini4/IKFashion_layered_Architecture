package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.BO.SuperBO;
import lk.Ijse.FinalProject.dto.PaymentDTO;
import lk.Ijse.FinalProject.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface PaymentBO extends SuperBO {

    public boolean save(Payment payment) throws SQLException, ClassNotFoundException ;


    public Payment searchById(String id) throws SQLException, ClassNotFoundException ;




    public List<Payment> getAll() throws SQLException, ClassNotFoundException ;


    public List<String> getIds() throws SQLException, ClassNotFoundException ;
}
