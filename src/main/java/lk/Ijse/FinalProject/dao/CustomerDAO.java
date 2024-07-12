package lk.Ijse.FinalProject.dao;



import lk.Ijse.FinalProject.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer> {
    public List<Customer> getAll() throws SQLException, ClassNotFoundException ;

    public  boolean update(Customer customer) throws SQLException, ClassNotFoundException ;

    public Customer searchById(String id) throws SQLException, ClassNotFoundException ;

    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public  boolean save(Customer customer) throws SQLException, ClassNotFoundException ;
    public  List<String> getIds() throws SQLException, ClassNotFoundException ;

}
