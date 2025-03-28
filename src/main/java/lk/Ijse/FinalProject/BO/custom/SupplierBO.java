package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.BO.SuperBO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SupplierBO extends SuperBO {
    public List<Supplier> getAllSupplier() throws SQLException, ClassNotFoundException;

    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException ;

    public boolean saveSupplier(Supplier supplier) throws SQLException, ClassNotFoundException ;


    public boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException ;



}
