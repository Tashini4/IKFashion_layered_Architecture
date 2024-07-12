package lk.Ijse.FinalProject.dao;

import lk.ijse.entity.Item;
import lk.ijse.entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item> {
    public List<Item> getAll() throws SQLException, ClassNotFoundException ;
    public  boolean save(Item item) throws SQLException, ClassNotFoundException;

    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public boolean update(Item item) throws SQLException, ClassNotFoundException ;

    public  List<String> getIds() throws SQLException, ClassNotFoundException ;

    public Item searchById(String id) throws SQLException, ClassNotFoundException;

    public  boolean update1(List<OrderDetail> odList) throws SQLException, ClassNotFoundException;
    public boolean updateQty(String itemId, int qty) throws SQLException, ClassNotFoundException ;

}
