package lk.Ijse.FinalProject.BO.Custom.impl;

import lk.Ijse.FinalProject.BO.Custom.SalaryBO;
import lk.Ijse.FinalProject.dao.Custom.SalaryDAO;
import lk.Ijse.FinalProject.dao.impl.SalaryDAOImpl;
import lk.Ijse.FinalProject.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.List;

public class SalaryBOImpl implements SalaryBO {
    SalaryDAO salaryDAO = new SalaryDAOImpl();

    public boolean updateSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
     return salaryDAO.update(salaryDTO);

    }
    public boolean saveSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
        return salaryDAO.save(salaryDTO);
    }

    public List<SalaryDTO> getAllSalary() throws SQLException, ClassNotFoundException {
        return salaryDAO.getAll();
    }


    public SalaryDTO searchBySalaryId(String id) throws SQLException, ClassNotFoundException {
       return salaryDAO.searchById(id);
}


    public boolean update(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
        return false;
    }


    public boolean save(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
        return false;
    }


    public List<SalaryDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }


    public SalaryDTO searchById(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
