package lk.Ijse.FinalProject.tm;

import lk.Ijse.FinalProject.dto.OrderDetailsDTO;
import lk.Ijse.FinalProject.dto.PaymentDTO;
import lk.Ijse.FinalProject.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PlaceOrderTM {
    private Order order;
    private List<OrderDetailsDTO> odList;
    private PaymentDTO payment;
}
