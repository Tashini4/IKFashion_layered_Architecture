package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.ItemDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.ItemDTO;
import lk.Ijse.FinalProject.dto.OrderDetailsDTO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO items VALUES(?, ?, ?, ? , ?, ? ,?)", itemDTO.getItemId(), itemDTO.getDescription(), itemDTO.getBrand(), itemDTO.getSize(), itemDTO.getPrice(), itemDTO.getQtyOnHand(), itemDTO.getInventoryId());


    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM items");

        ArrayList<ItemDTO> allItems = new ArrayList<>();

        while (rst.next()) {
            allItems.add(new ItemDTO(
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
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE items SET Description = ?, brand = ? , size = ? , price = ?, qtyOnHand = ?, inventoryId = ? WHERE itemId = ?",
                itemDTO.getDescription(), itemDTO.getBrand(), itemDTO.getSize(), itemDTO.getPrice(), itemDTO.getQtyOnHand(), itemDTO.getInventoryId(), itemDTO.getItemId());
    }

    @Override
    public ItemDTO searchById(String itemId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM items WHERE id=?", itemId);
        rst.next();
        return new ItemDTO(itemId + "", rst.getString("Description"),
                rst.getString("Brand"), rst.getString("Size"), rst.getDouble("Price"), rst.getInt("QtyOnHand"), rst.getString("InventoryId"));

    }

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

    private  boolean updateQty(String itemId, int qty) throws SQLException, ClassNotFoundException {
       /* String sql = "UPDATE items SET qtyOnHand = qtyOnHand - ? WHERE itemId= ?";

        PreparedStatement pvsm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pvsm.setInt(1, qty);
        pvsm.setString(2, itemId);

        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("UPDATE items SET qtyOnHand = qtyOnHand - ? WHERE itemId= ?",itemId,qty);
    }
}

