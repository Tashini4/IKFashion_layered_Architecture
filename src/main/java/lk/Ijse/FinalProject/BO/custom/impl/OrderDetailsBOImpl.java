package lk.Ijse.FinalProject.BO.custom.impl;

import lk.Ijse.FinalProject.BO.custom.OrderDetailsBO;
import lk.Ijse.FinalProject.dao.Custom.OrderDetailsDAO;
import lk.Ijse.FinalProject.dao.Custom.impl.OrderDetailsDAOImpl;
import lk.Ijse.FinalProject.dao.DAOFactory;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.OrderDetailsDTO;
import lk.Ijse.FinalProject.entity.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailsBOImpl implements OrderDetailsBO {
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);

    @Override
    public boolean save(List<OrderDetailsDTO> odList) throws SQLException, ClassNotFoundException {
        for (OrderDetailsDTO od : odList){
            boolean isSaved = saveOrderDetail(od);
            if (!isSaved){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean saveOrderDetail(OrderDetailsDTO od) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.saveOrderDetail(new OrderDetails(od.getItemId(),od.getOrderId(),
                od.getQty(),od.getUnitPrice(),od.getTotal()));
    }


}
