package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.BO.SuperBO;

import java.sql.SQLException;
import java.util.Map;

public interface OrderBO extends SuperBO {
    public Map<String, Integer> GetDailyOrderCounts() throws SQLException, ClassNotFoundException ;

    public  Map<String, Integer> GetDailyIncome() throws SQLException, ClassNotFoundException ;
    public String getCurrentId() throws SQLException, ClassNotFoundException;

    public String getPayCurrentId() throws SQLException, ClassNotFoundException;

}
