package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl {
    public List<SupplierDTO> getAll() throws SQLException, ClassNotFoundException {
       /* String sql = "SELECT * FROM suppliers";

        PreparedStatement pvsm = DbConnection.getInstance().getConnection().prepareStatement(sql);*/
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM suppliers");

        List<SupplierDTO> supplierList = new ArrayList<>();

        while(resultSet.next()){
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String address = resultSet.getString(4);
            String contact = resultSet.getString(5);


            SupplierDTO supplier = new SupplierDTO(id,name,email,address,contact);
            supplierList.add(supplier);
        }
        return supplierList;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       /* String sql = "DELETE FROM suppliers WHERE supplierId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(1, id);

        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("DELETE FROM suppliers WHERE supplierId = ?",id);

    }

    public boolean save(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        /*String sql = "INSERT INTO suppliers VALUES(?, ?, ?, ? ,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(1, supplier.getSupplierId());
        pvsm.setObject(2,  supplier.getSupplierName());
        pvsm.setObject(3,  supplier.getSupplierEmail());
        pvsm.setObject(4,  supplier.getSupplierAddress());
        pvsm.setObject(5,  supplier.getSupplierContact());


        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("INSERT INTO suppliers VALUES(?, ?, ?, ? ,?)",supplierDTO.getSupplierId(),supplierDTO.getSupplierName(),supplierDTO.getSupplierEmail(),supplierDTO.getSupplierAddress(),
                supplierDTO.getSupplierContact());
    }

    public boolean update(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
       /* String sql = "UPDATE suppliers SET supplierName = ?, supplierEmail = ?, supplierAddress = ? , supplierContact = ?  WHERE supplierId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(1, supplier.getSupplierName());
        pvsm.setObject(2, supplier.getSupplierEmail());
        pvsm.setObject(3,supplier.getSupplierAddress());
        pvsm.setObject(4, supplier.getSupplierContact());
        pvsm.setObject(5, supplier.getSupplierId());

        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute( "UPDATE suppliers SET supplierName = ?, supplierEmail = ?, supplierAddress = ? , supplierContact = ?  WHERE supplierId = ?",supplierDTO.getSupplierName(),supplierDTO.getSupplierEmail(),supplierDTO.getSupplierAddress(),
                supplierDTO.getSupplierContact(),supplierDTO.getSupplierId());
    }
}
