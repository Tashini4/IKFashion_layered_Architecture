package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.ItemDTO;
import lk.Ijse.FinalProject.dto.OrderDetailsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemDAO {
    public  boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    public ItemDTO searchById(String itemId) throws SQLException, ClassNotFoundException;
    public List<String> getIds() throws SQLException, ClassNotFoundException ;

    public  boolean update1(List<OrderDetailsDTO> odList) throws SQLException, ClassNotFoundException;


}
