package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.CustomerDTO;
import lk.Ijse.FinalProject.dto.InventoryDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface InventoryDAO {
    public List<String> getIds() throws SQLException, ClassNotFoundException ;
    public InventoryDTO searchById(String id) throws SQLException, ClassNotFoundException ;
}

