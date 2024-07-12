package lk.Ijse.FinalProject.dao;

import lk.ijse.entity.Inventory;

import java.sql.SQLException;
import java.util.List;

public interface InventoryDAO extends CrudDAO<Inventory> {
    public List<String> getIds() throws SQLException, ClassNotFoundException ;
    public Inventory searchById(String id) throws SQLException, ClassNotFoundException ;
}
