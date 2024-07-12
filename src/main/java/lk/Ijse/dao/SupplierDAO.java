package lk.Ijse.dao;

import lk.ijse.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO extends CrudDAO<Supplier> {
    public List<Supplier> getAll() throws SQLException, ClassNotFoundException ;

    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public  boolean save(Supplier supplier) throws SQLException, ClassNotFoundException ;


    public  boolean update(Supplier supplier) throws SQLException, ClassNotFoundException ;
}
