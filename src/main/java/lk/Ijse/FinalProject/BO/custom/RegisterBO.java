package lk.Ijse.FinalProject.BO.Custom;

import lk.Ijse.FinalProject.dto.RegisterDTO;

import java.sql.SQLException;
import java.util.List;

public interface RegisterBO {
    public List<RegisterDTO> getAllRegister() throws SQLException, ClassNotFoundException ;


    public boolean deleteRegister(String id) throws SQLException, ClassNotFoundException ;


    public boolean saveRegister(RegisterDTO registerDTO) throws SQLException, ClassNotFoundException;

    public boolean updateRegister(RegisterDTO registerDTO) throws SQLException, ClassNotFoundException;


    public RegisterDTO searchByRegisterId(String id) throws SQLException, ClassNotFoundException ;
}
