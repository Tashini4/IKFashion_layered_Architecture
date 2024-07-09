package lk.Ijse.FinalProject.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaymentTM {
    private String paymentId;
    private double paymentAmount;
    private Date paymentDate;
}
