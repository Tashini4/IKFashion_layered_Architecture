package lk.Ijse.FinalProject.BO.custom;

import javafx.scene.control.Alert;
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
        PaymentDAO paymentDAO = new PaymentDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();
        ItemDAO itemDAO = new ItemDAOImpl();
        OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();


        Connection connection = DbConnection.getDbConnection().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isPaymentUpdated = paymentDAO.save(po.getPayment());
            if (isPaymentUpdated) {
                boolean isOrderSaved = orderDAO.save(po.getOrder());
                if (isOrderSaved) {
                    boolean isQtyUpdated = (itemDAO).update1(po.getOdList());
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
