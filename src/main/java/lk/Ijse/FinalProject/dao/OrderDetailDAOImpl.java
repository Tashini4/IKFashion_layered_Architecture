package lk.Ijse.FinalProject.dao;

import lk.ijse.entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public  boolean save(List<OrderDetail> odList) throws SQLException, ClassNotFoundException {
        for (OrderDetail od : odList) {
            boolean isSaved = saveOrderItem(od);
            if(!isSaved) {
                return false;
            }
        }
        return true;

    }
    @Override

    public   boolean saveOrderItem(OrderDetail od) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO orderDetails (itemId, orderId, qty,unitPrice,total) VALUES (?, ?, ?, ?,?)",od);
    }
    }

