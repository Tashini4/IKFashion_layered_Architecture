package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.SalaryDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.SalaryDTO;
import lk.Ijse.FinalProject.entity.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public boolean update(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE salary SET salaryDate = ?, salaryAmount = ? ,employeeId = ? WHERE salaryId = ?", salaryDTO.getSalaryDate(), salaryDTO.getSalaryAmount(),
                salaryDTO.getEmployeeId(), salaryDTO.getSalaryId());

    }
    @Override
    public boolean save(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO salary VALUES (?,?,?,?)", salaryDTO.getSalaryDate(), salaryDTO.getSalaryAmount(),
                salaryDTO.getEmployeeId());
    }
    @Override
    public List<Salary> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM salary");

        List<Salary> salaryList = new ArrayList<>();

        while (resultSet.next()) {
            String salaryId = resultSet.getString(1);
            String date = resultSet.getString(2);
            String amount = resultSet.getString(3);
            String employeeId = resultSet.getString(4);


            Salary salary = new Salary(salaryId, date, amount, employeeId);
            salaryList.add(salary);
        }
        return salaryList;
    }

    @Override
    public boolean save(Salary customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Salary customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Salary searchById(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM salary WHERE salaryId = ?", id);
        rst.next();
        return new Salary(id + "", rst.getString("Date"), rst.getString("Amount"), rst.getString("EmployeeId"));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
