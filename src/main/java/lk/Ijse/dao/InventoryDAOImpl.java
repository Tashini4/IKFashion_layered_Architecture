package lk.Ijse.dao;


import lk.ijse.entity.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAOImpl implements InventoryDAO {
    @Override
    public  List<String> getIds() throws SQLException, ClassNotFoundException {
        List<String> idList = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT inventoryId FROM inventory");
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            idList.add(id);
        }
        return idList;
    }
@Override
    public  Inventory searchById(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute( "SELECT * FROM inventory WHERE inventoryId = ?");

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
    }
}



