package lk.Ijse.FinalProject.BO.custom.impl;

import lk.Ijse.FinalProject.BO.custom.PaymentBO;
import lk.Ijse.FinalProject.dao.Custom.PaymentDAO;
import lk.Ijse.FinalProject.dao.Custom.impl.PaymentDAOImpl;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.PaymentDTO;
import lk.Ijse.FinalProject.dto.SalaryDTO;
import lk.Ijse.FinalProject.entity.Payment;
import lk.Ijse.FinalProject.entity.Salary;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = new PaymentDAOImpl();

    @Override
    public boolean save(Payment payment) throws SQLException, ClassNotFoundException {

        return paymentDAO.save(payment);
    }

    @Override
    public Payment searchById(String id) throws SQLException, ClassNotFoundException {

        return paymentDAO.searchById(id);
    }


    @Override
    public List<Payment> getAll() throws SQLException, ClassNotFoundException {

        List<Payment> allPaymentEntityData = paymentDAO.getAll();
        List<PaymentDTO> allDTOData = new ArrayList<>();
        for (Payment m : allPaymentEntityData) {
            allDTOData.add(new PaymentDTO(m.getPaymentId(), m.getPaymentAmount(), m.getPaymentDate()));
        }

        return allPaymentEntityData;
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {

        return paymentDAO.getIds();

    }
}
