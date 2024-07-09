package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.InventoryDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.InventoryDTO;
import lk.Ijse.FinalProject.dto.ItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAOImpl implements InventoryDAO {
    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
        /*String sql = "SELECT inventoryId FROM inventory";
        PreparedStatement pvsm = DbConnection.getInstance().getConnection().prepareStatement(sql);*/
        List<String> idList = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT inventoryId FROM inventory");
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            idList.add(id);
        }
        return idList;
    }
    @Override
    public  InventoryDTO searchById(String id) throws SQLException, ClassNotFoundException {
        /*String sql = "SELECT * FROM inventory WHERE inventoryId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(1, id);

        ResultSet resultSet = pvsm.executeQuery();

        if (resultSet.next()) {
            String inventoryId = resultSet.getString(1);
            int qty = Integer.parseInt(resultSet.getString(2));
            double costPrice = Double.parseDouble((resultSet.getString(3)));
            double sellingPrice = Double.parseDouble((resultSet.getString(4)));
            String  supplierId = resultSet.getString(5);

            Inventory inventory = new Inventory(inventoryId,qty,costPrice,sellingPrice,supplierId);

            return inventory;
        }
        return null;
    }*/
        ResultSet rst = SQLUtil.execute("SELECT * FROM inventory WHERE id=?",id);
        rst.next();
        return new InventoryDTO(id + "", rst.getInt("Qty"),
                rst.getDouble("CostPrice"),rst.getDouble("SellingPrice"),rst.getString("SupplierId"));

    }
}

