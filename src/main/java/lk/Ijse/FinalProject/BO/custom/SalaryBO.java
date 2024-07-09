package lk.Ijse.FinalProject.BO.Custom;

import lk.Ijse.FinalProject.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.List;

public interface SalaryBO {
    public boolean updateSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException ;

    public boolean saveSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;

    public List<SalaryDTO> getAllSalary() throws SQLException, ClassNotFoundException ;


    public SalaryDTO searchBySalaryId(String id) throws SQLException, ClassNotFoundException ;
}
