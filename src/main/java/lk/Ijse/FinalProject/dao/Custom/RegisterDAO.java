package lk.Ijse.FinalProject.dao.Custom;

import lk.Ijse.FinalProject.dao.CrudDAO;
import lk.Ijse.FinalProject.dao.SQLUtil;
import lk.Ijse.FinalProject.dto.RegisterDTO;
import lk.Ijse.FinalProject.entity.Register;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RegisterDAO extends CrudDAO<Register> {
    public List<Register> getAll() throws SQLException, ClassNotFoundException ;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean save(RegisterDTO registerDTO) throws SQLException, ClassNotFoundException;

    public boolean update(RegisterDTO registerDTO) throws SQLException, ClassNotFoundException ;

    public Register searchById(String id) throws SQLException, ClassNotFoundException;
}
