package lk.Ijse.FinalProject.dto;

import lk.Ijse.FinalProject.view.tm.CustomerTM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerDTO  {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerContact;
    private String customerAddress;
}
