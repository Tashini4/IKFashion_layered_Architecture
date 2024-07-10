package lk.Ijse.FinalProject.dao;

import lk.Ijse.FinalProject.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    public List<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T customerDTO) throws SQLException, ClassNotFoundException;

   // boolean update(T customerDTO) throws SQLException, ClassNotFoundException;

    //boolean delete(String id) throws SQLException, ClassNotFoundException;


}
