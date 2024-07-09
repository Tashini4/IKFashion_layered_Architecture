package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.db.DbConnection;
import lk.Ijse.FinalProject.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl {


    public  Boolean check(UserDTO userDTO) throws SQLException {
        String sql = "SELECT password FROM users WHERE userId = ?";
        Connection connection = DbConnection.getDbConnection().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(1, userDTO.getUserName());
        ResultSet resultSet = pvsm.executeQuery();
        if (resultSet.next()) {
            String password = resultSet.getString(1);
            if (userDTO.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
