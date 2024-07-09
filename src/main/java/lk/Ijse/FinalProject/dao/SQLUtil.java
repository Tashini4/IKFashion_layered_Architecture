package lk.Ijse.FinalProject.dao;

import lk.Ijse.FinalProject.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static <T> T execute(String sql,Object... obj)  throws SQLException, ClassNotFoundException {
      Connection connection = DbConnection.getDbConnection().getConnection();
            PreparedStatement pvsm = connection.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                pvsm.setObject((i + 1), obj[i]);
            }
            if (sql.startsWith("SELECT")) {
                return (T) pvsm.executeQuery();
            } else {
                return (T) (Boolean) (pvsm.executeUpdate() > 0);
            }
        }
    }

