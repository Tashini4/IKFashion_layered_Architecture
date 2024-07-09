package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDAO {
    public List<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException;


    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public boolean save(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;

    public boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException ;

    public EmployeeDTO searchById(String id) throws SQLException, ClassNotFoundException ;
    public  List<String> getIds() throws SQLException, ClassNotFoundException ;

}


