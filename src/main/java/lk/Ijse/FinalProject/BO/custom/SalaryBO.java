package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.BO.SuperBO;
import lk.Ijse.FinalProject.dto.SalaryDTO;
import lk.Ijse.FinalProject.entity.Salary;

import java.sql.SQLException;
import java.util.List;

public interface SalaryBO  extends SuperBO {
    public boolean updateSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException ;

    public boolean saveSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;

    public List<Salary> getAllSalary() throws SQLException, ClassNotFoundException ;


    public Salary searchBySalaryId(String id) throws SQLException, ClassNotFoundException ;
}
