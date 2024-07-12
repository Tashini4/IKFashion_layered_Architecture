package lk.Ijse.dao;

import lk.ijse.entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO extends CrudDAO<OrderDetail> {
    public boolean save(List<OrderDetail> odList) throws SQLException, ClassNotFoundException;

    public boolean saveOrderItem(OrderDetail od) throws SQLException, ClassNotFoundException;
}
