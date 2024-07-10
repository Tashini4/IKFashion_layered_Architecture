package lk.Ijse.FinalProject.BO.custom;

import lk.Ijse.FinalProject.BO.SuperBO;
import lk.Ijse.FinalProject.dto.RegisterDTO;
import lk.Ijse.FinalProject.entity.Register;

import java.sql.SQLException;
import java.util.List;

public interface RegisterBO extends SuperBO {
    public List<Register> getAllRegister() throws SQLException, ClassNotFoundException ;


    public boolean deleteRegister(String id) throws SQLException, ClassNotFoundException ;


    public boolean saveRegister(Register register) throws SQLException, ClassNotFoundException;

    public boolean updateRegister(Register register) throws SQLException, ClassNotFoundException;


    public Register searchByRegisterId(String id) throws SQLException, ClassNotFoundException ;
}
