package lk.Ijse.FinalProject.bo;


import lk.Ijse.FinalProject.dto.EmployeeDTO;
import lk.Ijse.FinalProject.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO{

    public List<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException;


    public  boolean delete(String id) throws SQLException, ClassNotFoundException;

    public  boolean save(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException ;


    public  boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;

    public  List<String> getIds() throws SQLException, ClassNotFoundException ;

    public Employee searchById(String id) throws SQLException, ClassNotFoundException ;
}
