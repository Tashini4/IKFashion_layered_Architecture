package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.dto.InventoryDTO;

import java.sql.SQLException;
import java.util.List;

public interface InventoryBO {
    public List<String> getInventoryIds() throws SQLException, ClassNotFoundException ;

    public InventoryDTO searchByInventoryId(String id) throws SQLException, ClassNotFoundException;


}
