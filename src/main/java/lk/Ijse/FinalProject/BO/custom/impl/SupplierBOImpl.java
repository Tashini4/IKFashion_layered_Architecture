package lk.Ijse.FinalProject.BO.custom.impl;

import lk.Ijse.FinalProject.BO.custom.SupplierBO;
import lk.Ijse.FinalProject.dao.Custom.SupplierDAO;
import lk.Ijse.FinalProject.dao.DAOFactory;
import lk.Ijse.FinalProject.dto.SupplierDTO;
import lk.Ijse.FinalProject.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    public List<Supplier> getAll() throws SQLException, ClassNotFoundException {
        List<Supplier> allSupplierEntityData = supplierDAO.getAll();
        List<SupplierDTO> allDTOData = new ArrayList<>();
        for (Supplier s : allSupplierEntityData){
            allDTOData.add(new SupplierDTO(s.getSupplierId(),s.getSupplierName(),s.getSupplierEmail(),s.getSupplierAddress(),s.getSupplierContact()));
        }
        return allSupplierEntityData;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       return supplierDAO.delete(id);

    }

    public boolean save(Supplier supplier) throws SQLException, ClassNotFoundException {
       return supplierDAO.save(supplier);
    }


    public boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {
      return supplierDAO.update(supplier);
}

}
