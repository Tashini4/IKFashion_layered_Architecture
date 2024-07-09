package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SupplierDAO {
    public List<SupplierDTO> getAll() throws SQLException, ClassNotFoundException;


    public boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public boolean save(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException ;

    public boolean update(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException ;
}


