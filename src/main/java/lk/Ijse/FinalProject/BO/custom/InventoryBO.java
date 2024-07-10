package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.BO.SuperBO;
import lk.Ijse.FinalProject.entity.Inventory;

import java.sql.SQLException;
import java.util.List;

public interface InventoryBO  extends SuperBO {
    public List<String> getInventoryIds() throws SQLException, ClassNotFoundException ;

    public Inventory searchByInventoryId(String id) throws SQLException, ClassNotFoundException;


}
