package lk.Ijse.FinalProject.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerTM {
    private String id;
    private String name;
    private String email;
    private String contact;
    private String address;
}
