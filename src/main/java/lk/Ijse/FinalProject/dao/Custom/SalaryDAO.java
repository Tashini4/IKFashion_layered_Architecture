package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.SalaryDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SalaryDAO {
    public boolean update(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException ;

    public boolean save(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;

    public List<SalaryDTO> getAll() throws SQLException, ClassNotFoundException;


    public SalaryDTO searchById(String id) throws SQLException, ClassNotFoundException ;
}
