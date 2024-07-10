package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.dto.CustomerDTO;
import lk.Ijse.FinalProject.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SalaryBO{

    public List<Customer> getAllCustomer() throws SQLException, ClassNotFoundException;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;

    public boolean saveCustomer(Customer customerDTO) throws SQLException, ClassNotFoundException ;

    public boolean updateCustomer(Customer customerDTO) throws SQLException, ClassNotFoundException ;


    public Customer searchByCustomerId(String id) throws SQLException, ClassNotFoundException;
    public List<String> getIds() throws SQLException, ClassNotFoundException;

    public int getCustomer() throws SQLException, ClassNotFoundException ;

    Customer searchById1(String id) throws SQLException, ClassNotFoundException;

    String getCurrentId() throws SQLException, ClassNotFoundException;
}


