package lk.Ijse.FinalProject.BO.custom.impl;


import lk.Ijse.FinalProject.BO.custom.InventoryBO;
import lk.Ijse.FinalProject.dao.Custom.InventoryDAO;
import lk.Ijse.FinalProject.dao.DAOFactory;
import lk.Ijse.FinalProject.entity.Inventory;

import java.sql.SQLException;
import java.util.List;

public class InventoryBOImpl implements InventoryBO {
    InventoryDAO inventoryDAO = (InventoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.INVENTORY);
    @Override
    public List<String> getInventoryIds() throws SQLException, ClassNotFoundException {
        return inventoryDAO.getIds();
    }
    @Override
    public Inventory searchByInventoryId(String id) throws SQLException, ClassNotFoundException {
       return inventoryDAO.searchById(id);

    }
}
