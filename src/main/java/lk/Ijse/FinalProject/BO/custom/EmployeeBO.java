package lk.Ijse.FinalProject.BO.Custom;

import lk.Ijse.FinalProject.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO {
    public List<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException;


    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException ;

    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException ;

    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException ;


    public EmployeeDTO searchByEmployeeId(String id) throws SQLException, ClassNotFoundException ;

    public  List<String> getEmployeeIds() throws SQLException, ClassNotFoundException ;
}


