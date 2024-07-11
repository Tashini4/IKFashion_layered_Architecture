package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.CrudDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.OrderDetailsDTO;
import lk.Ijse.FinalProject.entity.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDAO extends CrudDAO<OrderDetails> {

    public  boolean save(List<OrderDetailsDTO> odList) throws SQLException, ClassNotFoundException ;

    public boolean saveOrderDetail(OrderDetailsDTO od) throws SQLException, ClassNotFoundException ;
}
