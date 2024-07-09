package lk.Ijse.FinalProject.BO.Custom.impl;

import lk.Ijse.FinalProject.BO.Custom.RegisterBO;
import lk.Ijse.FinalProject.dao.Custom.RegisterDAO;
import lk.Ijse.FinalProject.dao.impl.RegisterDAOImpl;
import lk.Ijse.FinalProject.dto.RegisterDTO;

import java.sql.SQLException;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {

    RegisterDAO registerDAO = new RegisterDAOImpl() ;
        @Override
        public List<RegisterDTO> getAllRegister() throws SQLException, ClassNotFoundException {
            return registerDAO.getAll();
        }

        @Override
        public boolean deleteRegister(String id) throws SQLException, ClassNotFoundException {
            return registerDAO.delete(id);
        }

        @Override
        public boolean saveRegister(RegisterDTO registerDTO) throws SQLException, ClassNotFoundException {
            return registerDAO.save(registerDTO);
        }

        @Override
        public boolean updateRegister(RegisterDTO registerDTO) throws SQLException, ClassNotFoundException {
            return registerDAO.update(registerDTO);
        }

        @Override
        public RegisterDTO searchByRegisterId(String id) throws SQLException, ClassNotFoundException {
            return registerDAO.searchById(id);
        }
    }

