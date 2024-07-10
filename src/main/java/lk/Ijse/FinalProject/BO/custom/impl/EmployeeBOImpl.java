package lk.Ijse.FinalProject.BO.custom.impl;


import lk.Ijse.FinalProject.BO.BOFactory;
import lk.Ijse.FinalProject.BO.custom.EmployeeBO;
import lk.Ijse.FinalProject.dao.Custom.EmployeeDAO;

import lk.Ijse.FinalProject.dao.DAOFactory;
import lk.Ijse.FinalProject.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override

    public List<Employee> getAllEmployee() throws SQLException, ClassNotFoundException {
       return employeeDAO.getAll();
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
       return employeeDAO.delete(id);
    }
    @Override
    public boolean saveEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(employee);
    }
    @Override
    public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(employee);
    }

    @Override
    public Employee searchByEmployeeId(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.searchById(id);
    }
    @Override
    public  List<String> getEmployeeIds() throws SQLException, ClassNotFoundException {
       return employeeDAO.getIds();
    }
}
