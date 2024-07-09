package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO {

    public List<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;


    public CustomerDTO searchByCustomerId(String id) throws SQLException, ClassNotFoundException;
    public List<String> getIds() throws SQLException, ClassNotFoundException;

    public int getCustomer() throws SQLException, ClassNotFoundException ;
    }


