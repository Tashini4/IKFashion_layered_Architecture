package lk.Ijse.FinalProject.BO.custom.impl;


import lk.Ijse.FinalProject.BO.custom.SalaryBO;
import lk.Ijse.FinalProject.dao.Custom.SalaryDAO;

import lk.Ijse.FinalProject.dao.DAOFactory;
import lk.Ijse.FinalProject.dto.SalaryDTO;
import lk.Ijse.FinalProject.entity.Salary;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryBOImpl implements SalaryBO {
    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SALARY);

    public boolean updateSalary(Salary salaryDTO) throws SQLException, ClassNotFoundException {
        return salaryDAO.update(salaryDTO);

    }

    public boolean saveSalary(Salary salaryDTO) throws SQLException, ClassNotFoundException {
        return salaryDAO.save(salaryDTO);
    }

    public List<Salary> getAllSalary() throws SQLException, ClassNotFoundException {
        List<Salary> allSalaryEntityData = salaryDAO.getAll();
        List<SalaryDTO> allDTOData = new ArrayList<>();
        for (Salary m : allSalaryEntityData) {
            allDTOData.add(new SalaryDTO(m.getSalaryId(), m.getSalaryDate(), m.getSalaryAmount(), m.getEmployeeId()));
        }

        return allSalaryEntityData;
    }


    public Salary searchBySalaryId(String id) throws SQLException, ClassNotFoundException {
        return salaryDAO.searchById(id);
    }
}