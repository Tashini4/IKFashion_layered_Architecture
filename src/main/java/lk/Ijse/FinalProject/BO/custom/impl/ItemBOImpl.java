package lk.Ijse.FinalProject.BO.custom.impl;

//import lk.Ijse.FinalProject.BO.Custom.ItemBO;
import lk.Ijse.FinalProject.BO.custom.ItemBO;
import lk.Ijse.FinalProject.dao.Custom.ItemDAO;
//import lk.Ijse.FinalProject.dao.impl.ItemDAOImpl;
import lk.Ijse.FinalProject.dao.DAOFactory;
import lk.Ijse.FinalProject.dto.ItemDTO;
import lk.Ijse.FinalProject.entity.Item;

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
        public Item searchByItemId(String itemId) throws SQLException, ClassNotFoundException {
            return itemDAO.searchById(itemId);
        }

        @Override
        public List<String> getItemIds() throws SQLException, ClassNotFoundException {
            return itemDAO.getIds();
        }
    }
