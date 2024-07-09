package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.CrudDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.SalaryDTO;
import lk.Ijse.FinalProject.entity.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SalaryDAO extends CrudDAO<Salary> {

    boolean update(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;

    boolean save(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;
}
