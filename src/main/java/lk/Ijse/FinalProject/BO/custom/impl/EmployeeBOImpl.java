package lk.Ijse.FinalProject.BO.custom.impl;

import lk.Ijse.FinalProject.BO.Custom.EmployeeBO;
import lk.Ijse.FinalProject.dao.Custom.EmployeeDAO;

import lk.Ijse.FinalProject.dao.Custom.impl.EmployeeDAOImpl;
import lk.Ijse.FinalProject.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    @Override

    public List<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException {
       return employeeDAO.getAll();
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
       return employeeDAO.delete(id);
    }
    @Override
    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(employeeDTO);
    }
    @Override
    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(employeeDTO);
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.searchById(id);
    }
    @Override
    public  List<String> getEmployeeIds() throws SQLException, ClassNotFoundException {
       return employeeDAO.getIds();
    }
}
