package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.CrudDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.CustomerDTO;
import lk.Ijse.FinalProject.dto.InventoryDTO;
import lk.Ijse.FinalProject.entity.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface InventoryDAO extends CrudDAO<Inventory> {
    public List<String> getIds() throws SQLException, ClassNotFoundException ;
    public Inventory searchById(String id) throws SQLException, ClassNotFoundException ;
}

