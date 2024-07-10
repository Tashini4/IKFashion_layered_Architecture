package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.dto.EmployeeDTO;
import lk.Ijse.FinalProject.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SalaryBO {
    public List<Employee> getAllEmployee() throws SQLException, ClassNotFoundException;


    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException ;

    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException ;

    boolean saveEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException ;


    boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    public Employee searchByEmployeeId(String id) throws SQLException, ClassNotFoundException ;

    public  List<String> getEmployeeIds() throws SQLException, ClassNotFoundException ;
}


