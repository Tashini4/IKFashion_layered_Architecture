package lk.Ijse.FinalProject.BO.custom;

import java.sql.SQLException;
import java.util.Map;

public interface OrderBO {
    public Map<String, Integer> GetDailyOrderCounts() throws SQLException, ClassNotFoundException ;

    public  Map<String, Integer> GetDailyIncome() throws SQLException, ClassNotFoundException ;
    public String getCurrentId() throws SQLException, ClassNotFoundException;

    public String getPayCurrentId() throws SQLException, ClassNotFoundException;

}
