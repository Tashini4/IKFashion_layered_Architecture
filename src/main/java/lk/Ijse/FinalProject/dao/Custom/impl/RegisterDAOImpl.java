package lk.Ijse.FinalProject.dao.Custom.impl;

import lk.Ijse.FinalProject.dao.Custom.RegisterDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.RegisterDTO;
import lk.Ijse.FinalProject.entity.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public List<Register> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM register");

        List<Register> registerList = new ArrayList<>();

        while (resultSet.next()) {
            String registerId = resultSet.getString(1);
            String name = resultSet.getString(2);
            String position = resultSet.getString(3);
            String password = resultSet.getString(4);


            Register register = new Register(registerId, name, position, password);
            registerList.add(register);
        }
        return registerList;
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("DELETE FROM register WHERE registerId = ?",id);
    }
    @Override
    public boolean save(Register register) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO register (registerId, registerName, registerPosition, registerPassword) VALUES(?,?,?,?)",register.getRegisterId(),
                register.getRegiterName(),register.getRegisterPosition(),register.getRegisterPosition());
    }
    @Override
    public boolean update(Register register) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE register SET registerName = ?, registerPosition = ?, registerPassword = ? WHERE registerId = ?",register.getRegisterId(),register.getRegiterName(),
                register.getRegisterPosition(),register.getRegisterPassword());
    }
    @Override
    public Register searchById(String id) throws SQLException, ClassNotFoundException {


        ResultSet rst = SQLUtil.execute( "SELECT * FROM register WHERE registerId = ?",id);
        rst.next();
        return new Register(id + "", rst.getString("Name"),rst.getString("Position"), rst.getString("Password") );
    }
}
