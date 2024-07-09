package lk.Ijse.FinalProject.BO.custom.impl;

//import lk.Ijse.FinalProject.BO.Custom.InventoryBO;
import lk.Ijse.FinalProject.BO.custom.InventoryBO;
import lk.Ijse.FinalProject.dao.Custom.InventoryDAO;
//import lk.Ijse.FinalProject.dao.impl.InventoryDAOImpl;
import lk.Ijse.FinalProject.dao.Custom.impl.InventoryDAOImpl;
import lk.Ijse.FinalProject.dto.InventoryDTO;

import java.sql.SQLException;
import java.util.List;

public class InventoryBOImpl implements InventoryBO {
    InventoryDAO inventoryDAO = new InventoryDAOImpl();
    @Override
    public List<String> getInventoryIds() throws SQLException, ClassNotFoundException {
        return inventoryDAO.getIds();
    }
    @Override
    public InventoryDTO searchByInventoryId(String id) throws SQLException, ClassNotFoundException {
       return inventoryDAO.searchById(id);

    }
}
