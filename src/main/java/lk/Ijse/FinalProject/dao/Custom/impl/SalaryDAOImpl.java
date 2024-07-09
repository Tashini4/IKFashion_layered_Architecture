package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.SalaryDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.SalaryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public boolean update(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
       /* String sql = "UPDATE salary SET salaryDate = ?, salaryAmount = ? ,employeeId = ? WHERE salaryId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(2, salary.getSalaryDate());
        pvsm.setObject(3, salary.getSalaryAmount());
        pvsm.setObject(4, salary.getEmployeeId());
        pvsm.setObject(1, salary.getSalaryId());

        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("UPDATE salary SET salaryDate = ?, salaryAmount = ? ,employeeId = ? WHERE salaryId = ?", salaryDTO.getSalaryDate(), salaryDTO.getSalaryAmount(),
                salaryDTO.getEmployeeId(), salaryDTO.getSalaryId());

    }
    @Override
    public boolean save(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
        /*String sql = "INSERT INTO salary VALUES (?,?,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(2, salary.getSalaryDate());
        pvsm.setObject(3, salary.getSalaryAmount());
        pvsm.setObject(4, salary.getEmployeeId());
        pvsm.setObject(1, salary.getSalaryId());


        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("INSERT INTO salary VALUES (?,?,?,?)", salaryDTO.getSalaryDate(), salaryDTO.getSalaryAmount(),
                salaryDTO.getEmployeeId());
    }
    @Override
    public List<SalaryDTO> getAll() throws SQLException, ClassNotFoundException {
        /*String sql = "SELECT * FROM salary";

        PreparedStatement pvsm = DbConnection.getInstance().getConnection().prepareStatement(sql);*/
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM salary");

        List<SalaryDTO> salaryList = new ArrayList<>();

        while (resultSet.next()) {
            String salaryId = resultSet.getString(1);
            String date = resultSet.getString(2);
            String amount = resultSet.getString(3);
            String employeeId = resultSet.getString(4);


            SalaryDTO salary = new SalaryDTO(salaryId, date, amount, employeeId);
            salaryList.add(salary);
        }
        return salaryList;
    }

    @Override
    public SalaryDTO searchById(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM salary WHERE salaryId = ?", id);
        rst.next();
        return new SalaryDTO(id + "", rst.getString("Date"), rst.getString("Amount"), rst.getString("EmployeeId"));
    }
}
