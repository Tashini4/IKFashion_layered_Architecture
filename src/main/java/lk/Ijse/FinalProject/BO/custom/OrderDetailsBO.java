package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.BO.SuperBO;
import lk.Ijse.FinalProject.dto.OrderDetailsDTO;
import lk.Ijse.FinalProject.entity.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsBO extends SuperBO {

    public boolean save(List<OrderDetails> odList) throws SQLException, ClassNotFoundException;


    public boolean saveOrderDetail(OrderDetails od) throws SQLException, ClassNotFoundException ;
}
