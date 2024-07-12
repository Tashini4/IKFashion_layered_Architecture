package lk.Ijse.dao;

import lk.ijse.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee> {
    public List<Employee> getAll() throws SQLException, ClassNotFoundException ;

    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;
    public  boolean save(Employee employee) throws SQLException, ClassNotFoundException;

    public  boolean update(Employee employee) throws SQLException, ClassNotFoundException ;
    public  List<String> getIds() throws SQLException, ClassNotFoundException ;
    public Employee searchById(String id) throws SQLException, ClassNotFoundException ;
}
