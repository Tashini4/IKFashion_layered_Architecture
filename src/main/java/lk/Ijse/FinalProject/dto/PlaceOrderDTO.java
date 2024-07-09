package lk.Ijse.FinalProject.dto;

import lk.Ijse.FinalProject.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PlaceOrderDTO {
    private Order order;
    private List<OrderDetailsDTO> odList;
    private PaymentDTO payment;
}
