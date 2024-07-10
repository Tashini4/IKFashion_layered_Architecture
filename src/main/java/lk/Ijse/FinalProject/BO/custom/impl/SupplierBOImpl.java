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
    @Override
    public List<Supplier> getAllSupplier() throws SQLException, ClassNotFoundException {
        List<Supplier> allSupplierEntityData = supplierDAO.getAll();
        List<SupplierDTO> allDTOData = new ArrayList<>();
        for (Supplier s : allSupplierEntityData){
            allDTOData.add(new SupplierDTO(s.getSupplierId(),s.getSupplierName(),s.getSupplierEmail(),s.getSupplierAddress(),s.getSupplierContact()));
        }
        return allSupplierEntityData;
    }
@Override
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
       return supplierDAO.delete(id);

    }
@Override
    public boolean saveSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
       return supplierDAO.save(supplier);
    }

@Override
    public boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
      return supplierDAO.update(supplier);
}

}
