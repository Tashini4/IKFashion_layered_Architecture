package lk.Ijse.FinalProject.dao;

import lk.ijse.entity.Salary;

import java.sql.SQLException;
import java.util.List;

public interface SalaryDAO extends CrudDAO<Salary> {
    public List<Salary> getAll() throws SQLException, ClassNotFoundException ;

    public  boolean update(Salary salary) throws SQLException, ClassNotFoundException ;
    public  boolean save(Salary salary) throws SQLException, ClassNotFoundException ;

    public Salary searchById(String id) throws SQLException, ClassNotFoundException;
}
