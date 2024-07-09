package lk.Ijse.FinalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Customer {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerContact;
    private String customerAddress;
}
