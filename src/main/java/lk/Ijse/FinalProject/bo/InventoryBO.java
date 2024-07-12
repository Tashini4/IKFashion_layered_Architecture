package lk.Ijse.FinalProject.bo;

import lk.ijse.entity.Inventory;

import java.sql.SQLException;
import java.util.List;

public interface InventoryBO extends SuperBO {

    public List<String> getIds() throws SQLException, ClassNotFoundException ;
    public Inventory searchById(String id) throws SQLException, ClassNotFoundException ;
}
