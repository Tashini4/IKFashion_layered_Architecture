package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public interface OrderDAO {
    public  Map<String, Integer> GetDailyOrderCounts() throws SQLException, ClassNotFoundException ;
    public  Map<String, Integer> GetDailyIncome() throws SQLException, ClassNotFoundException ;


    public String getCurrentId() throws SQLException, ClassNotFoundException ;

    public String getPayCurrentId() throws SQLException, ClassNotFoundException ;
}





