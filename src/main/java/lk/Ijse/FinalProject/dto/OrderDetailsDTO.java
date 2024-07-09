package lk.Ijse.FinalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetailsDTO {
    private String itemId;
    private String orderId;
    private int qty;
    private double unitPrice;
    private  double total;
}
