package lk.Ijse.FinalProject.BO.custom;

import javafx.scene.control.Alert;
import lk.Ijse.FinalProject.BO.custom.impl.ItemBOImpl;
import lk.Ijse.FinalProject.BO.custom.impl.OrderBOImpl;
import lk.Ijse.FinalProject.BO.custom.impl.PaymentBOImpl;
import lk.Ijse.FinalProject.dao.Custom.ItemDAO;
import lk.Ijse.FinalProject.dao.Custom.OrderDAO;
import lk.Ijse.FinalProject.dao.Custom.OrderDetailsDAO;
import lk.Ijse.FinalProject.dao.Custom.PaymentDAO;
import lk.Ijse.FinalProject.dao.Custom.impl.ItemDAOImpl;
import lk.Ijse.FinalProject.dao.Custom.impl.OrderDAOImpl;
import lk.Ijse.FinalProject.dao.Custom.impl.OrderDetailsDAOImpl;
import lk.Ijse.FinalProject.dao.Custom.impl.PaymentDAOImpl;
import lk.Ijse.FinalProject.db.DbConnection;
import lk.Ijse.FinalProject.dto.PlaceOrderDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface PlaceOrderBO {
    public static boolean placeOrder(PlaceOrderDTO po) throws SQLException {
        PaymentBO paymentBO = new PaymentBOImpl();
        OrderBO orderBO = new OrderBOImpl();
        ItemBO itemBO = new ItemBOImpl();
        OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();


        Connection connection = DbConnection.getDbConnection().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isPaymentUpdated = paymentBO.save(po.getPayment());
            if (isPaymentUpdated) {
                boolean isOrderSaved =  orderBO.save(po.getOrder());
                if (isOrderSaved) {
                    boolean isQtyUpdated = itemBO.update1(po.getOdList());
                    if (isQtyUpdated) {
                        boolean isOrderItemSaved = orderDetailsDAO.save(po.getOdList());
                        if (isOrderItemSaved) {

                            connection.commit();
                            return true;
                        }
                    }
                }
            }
            connection.rollback();
            return false;
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
