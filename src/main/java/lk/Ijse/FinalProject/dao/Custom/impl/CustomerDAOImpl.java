package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.CustomerDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.CustomerDTO;
import lk.Ijse.FinalProject.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customers");

        List<Customer> customerlist = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String contact = resultSet.getString(4);
            String address = resultSet.getString(5);

            Customer customer = new Customer(id, name, email, contact, address);
            customerlist.add(customer);
        }
        return customerlist;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM customers WHERE customerId = ?", id);
    }

    @Override
    public boolean save(Customer customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO customers VALUES(?, ?, ?, ? , ?)", customerDTO.getCustomerId(), customerDTO.getCustomerName(),
                customerDTO.getCustomerEmail(), customerDTO.getCustomerContact(), customerDTO.getCustomerAddress());
    }

    @Override
    public boolean update(Customer customerDTO) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE customers SET customerName = ?, customerEmail = ?, customerContact = ? , customerAddress = ? WHERE customerId = ?",
                customerDTO.getCustomerName(), customerDTO.getCustomerEmail(), customerDTO.getCustomerContact(), customerDTO.getCustomerAddress(), customerDTO.getCustomerId());
    }

    @Override
    public Customer searchById(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customers WHERE customerId = ?");
        rst.next();
        return new Customer(id + "", rst.getString("Name"), rst.getString("Email"), rst.getString("Contact"),
                rst.getString("Address"));
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = SQLUtil.execute("SELECT customerId FROM customers");
        while (resultSet.next()) {
            String id = resultSet.getString("itemId");
            idList.add(id);
        }
        return idList;
    }

    @Override
    public int getCustomer() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) AS customer_count FROM customers");

        if (resultSet.next()) {
            return resultSet.getInt("customer_count");
        }
        return 0;

    }

}




