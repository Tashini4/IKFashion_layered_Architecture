package lk.Ijse.dao;

import lk.ijse.entity.Register;

import java.sql.SQLException;
import java.util.List;

public interface RegisterDAO extends CrudDAO<Register> {
    public List<Register> getAll() throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public boolean save(Register register) throws SQLException, ClassNotFoundException ;

    public boolean update(Register register) throws SQLException, ClassNotFoundException;

    public Register searchById(String id) throws SQLException, ClassNotFoundException;

}
