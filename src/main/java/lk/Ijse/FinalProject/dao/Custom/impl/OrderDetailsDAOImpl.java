package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.OrderDetailsDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.OrderDetailsDTO;
import lk.Ijse.FinalProject.entity.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailsDAOImpl  implements OrderDetailsDAO {
    @Override
    public boolean save(List<OrderDetails> odList) throws SQLException, ClassNotFoundException {
        for (OrderDetails od : odList){
            boolean isSaved= saveOrderDetail(od);
            if (! isSaved){
                return false;
            }
        }
        return true;
    }
@Override
    public boolean saveOrderDetail(OrderDetails od) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO orderDetails (itemId,orderId,qty,unitPrice,total) VALUES(?,?,?,?,?)",
                            od.getItemId(),
                            od.getOrderId(),
                            od.getQty(),
                            od.getUnitPrice(),
                            od.getTotal());
    }

}
