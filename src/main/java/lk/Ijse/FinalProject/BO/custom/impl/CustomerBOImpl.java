package lk.Ijse.FinalProject.BO.custom.impl;

import lk.Ijse.FinalProject.BO.BOFactory;
import lk.Ijse.FinalProject.BO.custom.CustomerBO;
import lk.Ijse.FinalProject.dao.Custom.CustomerDAO;
import lk.Ijse.FinalProject.dao.Custom.impl.CustomerDAOImpl;
import lk.Ijse.FinalProject.dao.DAOFactory;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.CustomerDTO;
import lk.Ijse.FinalProject.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public List<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    @Override
    public boolean saveCustomer(Customer customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.save(customerDTO);
    }
    @Override
    public boolean updateCustomer(Customer customerDTO) throws SQLException, ClassNotFoundException {

        return customerDAO.update(customerDTO);
    }

    @Override
    public Customer searchByCustomerId(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.searchById(id);
    }
    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {

        return customerDAO.getIds();
    }
    @Override
    public int getCustomer() throws SQLException, ClassNotFoundException {
       return customerDAO.getCustomer();

    }
    @Override
   public Customer searchById1(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.searchById1(id);
    }
    @Override
   public String getCurrentId() throws SQLException, ClassNotFoundException {
        return customerDAO.getCurruntId();
   }

}


