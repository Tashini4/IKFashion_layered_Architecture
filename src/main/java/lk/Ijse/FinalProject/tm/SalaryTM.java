package lk.Ijse.FinalProject.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalaryTM {
    private String salaryId;
    private String date;
    private String amount;
    private  String employeeId;
}
