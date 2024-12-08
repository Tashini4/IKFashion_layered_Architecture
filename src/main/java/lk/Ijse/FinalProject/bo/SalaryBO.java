package lk.Ijse.FinalProject.bo;

import lk.ijse.dto.SalaryDTO;
import lk.ijse.entity.Salary;

import java.sql.SQLException;
import java.util.List;

public interface SalaryBO extends SuperBO{
    public List<SalaryDTO> getAll() throws SQLException, ClassNotFoundException;

    public boolean update(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;

    public boolean save(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;

    public Salary searchById(String id) throws SQLException, ClassNotFoundException;
}
