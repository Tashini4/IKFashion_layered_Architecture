package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.CrudDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.CustomerDTO;
import lk.Ijse.FinalProject.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {
    public List<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;

    boolean save(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    boolean update(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    CustomerDTO searchById(String id) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;
    public List<String> getIds() throws SQLException, ClassNotFoundException;

    public int getCustomer() throws SQLException, ClassNotFoundException;
    public Customer searchById1(String id) throws SQLException, ClassNotFoundException;

   public String getCurruntId() throws SQLException,ClassNotFoundException;

    public String getCurrentId() throws SQLException, ClassNotFoundException;
}




