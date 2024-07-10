package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.CrudDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dao.SuperDAO;
import lk.Ijse.FinalProject.dto.PaymentDTO;
import lk.Ijse.FinalProject.entity.Payment;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface PaymentDAO extends CrudDAO<Payment> {
    public  boolean save(Payment payment) throws SQLException, ClassNotFoundException ;
    public  Payment searchById(String id) throws SQLException, ClassNotFoundException;
    public List<Payment> getAll() throws SQLException, ClassNotFoundException ;
    public  List<String> getIds() throws SQLException, ClassNotFoundException ;

}
