package lk.Ijse.FinalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetails {
    private String itemId;
    private String orderId;
    private int qty;
    private double unitPrice;
    private  double total;
}
