package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.CrudDAO;
import lk.Ijse.FinalProject.dao.SuperDAO;
import lk.Ijse.FinalProject.dto.OrderDetailsDTO;
import lk.Ijse.FinalProject.entity.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDAO extends SuperDAO {

    public  boolean save(List<OrderDetails> odList) throws SQLException, ClassNotFoundException ;

    public boolean saveOrderDetail(OrderDetails od) throws SQLException, ClassNotFoundException ;
}
