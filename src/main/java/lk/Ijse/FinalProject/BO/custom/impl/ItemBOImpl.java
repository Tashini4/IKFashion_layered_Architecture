package lk.Ijse.FinalProject.BO.custom.impl;

//import lk.Ijse.FinalProject.BO.Custom.ItemBO;
import lk.Ijse.FinalProject.BO.custom.ItemBO;
import lk.Ijse.FinalProject.dao.Custom.ItemDAO;
//import lk.Ijse.FinalProject.dao.impl.ItemDAOImpl;
import lk.Ijse.FinalProject.dao.Custom.impl.ItemDAOImpl;
import lk.Ijse.FinalProject.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = new ItemDAOImpl();
        @Override
        public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
            return itemDAO.save(itemDTO);
        }

        @Override
        public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
            return itemDAO.getAllItems() ;
        }

        @Override
        public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
            return itemDAO.delete(id);
        }

        @Override
        public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
            return itemDAO.update(itemDTO);
        }

        @Override
        public ItemDTO searchByItemId(String itemId) throws SQLException, ClassNotFoundException {
            return itemDAO.searchById(itemId);
        }

        @Override
        public List<String> getItemIds() throws SQLException, ClassNotFoundException {
            return itemDAO.getIds();
        }
    }
