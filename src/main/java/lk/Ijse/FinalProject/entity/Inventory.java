package lk.Ijse.FinalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Inventory {
    private String inventoryId;
    private int qty;
    private double costPrice;
    private double sellingPrice;
    private String supplierId;
}
