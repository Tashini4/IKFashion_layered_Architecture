package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.EmployeeDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override

    public List<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
       /* String sql = "SELECT * FROM employees";

        PreparedStatement pvsm = DbConnection.getInstance().getConnection().prepareStatement(sql);*/
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employees");

        List<EmployeeDTO> employeeList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String contact = resultSet.getString(4);
            String address = resultSet.getString(5);
            String gender = resultSet.getNString(6);

            EmployeeDTO employee = new EmployeeDTO(id, name, email, contact, address, gender);
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*String sql = "DELETE FROM employees WHERE employeeId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(1, id);

        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("DELETE FROM employees WHERE employeeId = ?", id);
    }
    @Override
    public boolean save(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
       /* String sql = "INSERT INTO employees VALUES(?, ?, ?, ? ,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(1, employee.getEmployeeId());
        pvsm.setObject(2, employee.getEmployeeName());
        pvsm.setObject(3, employee.getEmployeeEmail());
        pvsm.setObject(4, employee.getEmployeeContact());
        pvsm.setObject(5, employee.getEmployeeAddress());
        pvsm.setObject(6, employee.getEmployeeGender());


        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("INSERT INTO employees VALUES(?, ?, ?, ? ,?,?)", employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(), employeeDTO.getEmployeeEmail(), employeeDTO.getEmployeeContact(), employeeDTO.getEmployeeAddress(), employeeDTO.getEmployeeGender());
    }
    @Override
    public boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
       /* String sql = "UPDATE employees SET employeeName = ?, employeeAddress = ?, employeeContact = ? , employeeEmail = ? , employeeGender = ? WHERE employeeId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(1, employee.getEmployeeName());
        pvsm.setObject(2, employee.getEmployeeAddress());
        pvsm.setObject(3, employee.getEmployeeContact());
        pvsm.setObject(4, employee.getEmployeeEmail());
        pvsm.setObject(5, employee.getEmployeeGender());
        pvsm.setObject(6, employee.getEmployeeId());


        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("UPDATE employees SET employeeName = ?, employeeAddress = ?, employeeContact = ? , employeeEmail = ? , employeeGender = ? WHERE employeeId = ?", employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(), employeeDTO.getEmployeeEmail(), employeeDTO.getEmployeeContact(), employeeDTO.getEmployeeAddress(), employeeDTO.getEmployeeGender());
    }

    @Override
    public EmployeeDTO searchById(String id) throws SQLException, ClassNotFoundException {
        /*String sql = "SELECT * FROM employees WHERE employeeId = ?";
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(1, id);
        ResultSet resultSet = pvsm.executeQuery();
        if (resultSet.next()) {
            String employeeId = resultSet.getString(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String contact = resultSet.getString(4);
            String address = resultSet.getString(5);
            String gender = resultSet.getString(6);



            return new Employee(employeeId,name,email,contact,address,gender);
        }
        return null;*/
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employees WHERE employeeId = ?", id);
        resultSet.next();
        return new EmployeeDTO(id + "", resultSet.getString("Name"), resultSet.getString("Email"),
                resultSet.getString("Contact"), resultSet.getString("Address"), resultSet.getString("Gender"));
    }
    @Override
    public  List<String> getIds() throws SQLException, ClassNotFoundException {
        /*String sql = "SELECT employeeId FROM employees";
        PreparedStatement pvsm = DbConnection.getInstance().getConnection().prepareStatement(sql);*/
        List<String> idList = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT employeeId FROM employees");
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            idList.add(id);
        }
        return idList;
    }
}
