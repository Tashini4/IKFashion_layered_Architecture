package lk.Ijse.FinalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaymentDTO {
    private String paymentId;
    private double paymentAmount;
    private Date paymentDate;
}
