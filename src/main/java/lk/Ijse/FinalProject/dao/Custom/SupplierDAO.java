package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.CrudDAO;

import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SupplierDAO extends CrudDAO<Supplier> {
    public List<Supplier> getAll() throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean save(Supplier supplier) throws SQLException, ClassNotFoundException ;
    public boolean update(Supplier supplier) throws SQLException, ClassNotFoundException;

}


