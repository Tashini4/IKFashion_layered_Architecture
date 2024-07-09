package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.RegisterDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.RegisterDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public List<RegisterDTO> getAll() throws SQLException, ClassNotFoundException {
       /* String sql = "SELECT * FROM register";

        PreparedStatement pvsm = DbConnection.getInstance().getConnection().prepareStatement(sql);*/
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM register");

        List<RegisterDTO> registerList = new ArrayList<>();

        while (resultSet.next()) {
            String registerId = resultSet.getString(1);
            String name = resultSet.getString(2);
            String position = resultSet.getString(3);
            String password = resultSet.getString(4);


            RegisterDTO register = new RegisterDTO(registerId, name, position, password);
            registerList.add(register);
        }
        return registerList;
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       /* String sql = "DELETE FROM register WHERE registerId = ?";
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setString(1, id);

        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("DELETE FROM register WHERE registerId = ?",id);
    }
    @Override
    public boolean save(RegisterDTO registerDTO) throws SQLException, ClassNotFoundException {
       /* String sql = "INSERT INTO register (registerId, registerName, registerPosition, registerPassword) VALUES(?,?,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);

        pvsm.setString(1, register.getRegisterId());
        pvsm.setString(2, register.getRegiterName());
        pvsm.setString(3, register.getRegisterPosition());
        pvsm.setString(4, register.getRegisterPassword());

        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("INSERT INTO register (registerId, registerName, registerPosition, registerPassword) VALUES(?,?,?,?)",registerDTO.getRegisterId(),
                registerDTO.getRegiterName(),registerDTO.getRegisterPosition(),registerDTO.getRegisterPosition());
    }
    @Override
    public boolean update(RegisterDTO registerDTO) throws SQLException, ClassNotFoundException {
        /*String sql = "UPDATE register SET registerName = ?, registerPosition = ?, registerPassword = ? WHERE registerId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);

        pvsm.setString(1, register.getRegiterName());
        pvsm.setString(2, register.getRegisterPosition());
        pvsm.setString(3, register.getRegisterPassword());
        pvsm.setString(4, register.getRegisterId());

        return pvsm.executeUpdate() > 0;*/
        return SQLUtil.execute("UPDATE register SET registerName = ?, registerPosition = ?, registerPassword = ? WHERE registerId = ?",registerDTO.getRegisterId(),registerDTO.getRegiterName(),
                registerDTO.getRegisterPosition(),registerDTO.getRegisterPassword());
    }
    @Override
    public RegisterDTO searchById(String id) throws SQLException, ClassNotFoundException {
       /* String sql = "SELECT * FROM register WHERE registerId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pvsm = connection.prepareStatement(sql);
        pvsm.setObject(1,id);

        ResultSet resultSet = pvsm.executeQuery();
        if (resultSet.next()) {
            String registerId = resultSet.getString(1);
            String name = resultSet.getString(2);
            String position = resultSet.getString(3);
            String password = resultSet.getString(4);


            Register register = new Register(registerId,name,position,password);

            return register;
        }

        return null;
    }
*/
        ResultSet rst = SQLUtil.execute( "SELECT * FROM register WHERE registerId = ?",id);
        rst.next();
        return new RegisterDTO(id + "", rst.getString("Name"),rst.getString("Position"), rst.getString("Password") );
    }
}
