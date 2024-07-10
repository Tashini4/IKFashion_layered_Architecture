package lk.Ijse.FinalProject.BO.custom.impl;

//import lk.Ijse.FinalProject.BO.Custom.ItemBO;
import lk.Ijse.FinalProject.BO.custom.ItemBO;
import lk.Ijse.FinalProject.dao.Custom.ItemDAO;
//import lk.Ijse.FinalProject.dao.impl.ItemDAOImpl;
import lk.Ijse.FinalProject.dao.DAOFactory;
import lk.Ijse.FinalProject.dto.OrderDetailsDTO;
import lk.Ijse.FinalProject.dto.SalaryDTO;
import lk.Ijse.FinalProject.entity.Item;
import lk.Ijse.FinalProject.entity.Salary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);


    @Override
    public boolean saveItem(Item item) throws SQLException, ClassNotFoundException {
        return itemDAO.save(item);
    }

    @Override
    public ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }

    @Override
    public boolean updateItem(Item item) throws SQLException, ClassNotFoundException {
        return itemDAO.update(item);
    }

    @Override
    public Item searchByItemId(String itemId) throws SQLException, ClassNotFoundException {
        return itemDAO.searchById(itemId);
    }

    @Override
    public List<String> getItemIds() throws SQLException, ClassNotFoundException {
        return itemDAO.getIds();
    }

    @Override
    public boolean update1(List<OrderDetailsDTO> odList) throws SQLException, ClassNotFoundException {
        return itemDAO.update1(odList);

    }

    @Override
    public boolean updateQty(String itemId, int qty) throws SQLException, ClassNotFoundException {
        return itemDAO.updateQty(itemId, qty);
    }
}


