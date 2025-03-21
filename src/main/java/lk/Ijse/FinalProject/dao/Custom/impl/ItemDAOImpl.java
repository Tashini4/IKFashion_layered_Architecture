package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.ItemDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.OrderDetailsDTO;
import lk.Ijse.FinalProject.entity.Item;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item item) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO items VALUES(?, ?, ?, ? , ?, ? ,?)", item.getItemId(), item.getDescription(),
                item.getBrand(), item.getSize(), item.getPrice(), item.getQtyOnHand(), item.getInventoryId());


    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM items");

        ArrayList<Item> allItems = new ArrayList<>();

        while (rst.next()) {
            allItems.add(new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getInt(6),
                    rst.getString(7)
            ));
        }
        return allItems;

    }

    @Override

    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("DELETE FROM items WHERE itemId = ?", id);
    }

    @Override
    public boolean update(Item item) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE items SET Description = ?, brand = ? , size = ? , price = ?, qtyOnHand = ?, inventoryId = ? WHERE itemId = ?",
                item.getDescription(), item.getBrand(), item.getSize(), item.getPrice(), item.getQtyOnHand(), item.getInventoryId(), item.getItemId());
    }

    @Override
    public Item searchById(String itemId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM items WHERE id=?", itemId);
        rst.next();
        return new Item(itemId + "", rst.getString("Description"),
                rst.getString("Brand"), rst.getString("Size"), rst.getDouble("Price"), rst.getInt("QtyOnHand"), rst.getString("InventoryId"));

    }
    @Override

    public List<String> getIds() throws SQLException, ClassNotFoundException {
        List<String> idList = new ArrayList<>();

        ResultSet resultSet = SQLUtil.execute("SELECT itemId FROM items");
        while (resultSet.next()) {
            String id = resultSet.getString("itemId");
            idList.add(id);
        }
        return idList;
    }
    @Override
    public  boolean update1(List<OrderDetailsDTO> odList) throws SQLException, ClassNotFoundException {
        for (OrderDetailsDTO od : odList) {
            boolean isUpdateQty = updateQty(od.getItemId(), od.getQty());
            if(!isUpdateQty) {
                return false;
            }
        }
        return true;

    }
    @Override
    public  boolean updateQty(String itemId, int qty) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE items SET qtyOnHand = qtyOnHand - ? WHERE itemId= ?",qty,itemId);
    }
}

