package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.CrudDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.EmployeeDTO;
import lk.Ijse.FinalProject.entity.Employee;
import org.apache.commons.digester.annotations.CreationRule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee> {
    public List<Employee> getAll() throws SQLException, ClassNotFoundException;


    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public boolean save(Employee employee) throws SQLException, ClassNotFoundException;

    public boolean update(Employee employee) throws SQLException, ClassNotFoundException ;

    public Employee searchById(String id) throws SQLException, ClassNotFoundException ;
    public  List<String> getIds() throws SQLException, ClassNotFoundException ;

}


