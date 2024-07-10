package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.dto.ItemDTO;
import lk.Ijse.FinalProject.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemBO extends SalaryBO{
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean saveItem(Item item) throws SQLException, ClassNotFoundException;

    public ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException;

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean updateItem(Item item) throws SQLException, ClassNotFoundException;

    public Item searchByItemId(String itemId) throws SQLException, ClassNotFoundException ;

    public List<String> getItemIds() throws SQLException, ClassNotFoundException ;

    Item searchById1(String id);
}
