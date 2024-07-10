package lk.Ijse.FinalProject.BO.custom.impl;


import lk.Ijse.FinalProject.BO.custom.RegisterBO;
import lk.Ijse.FinalProject.dao.Custom.RegisterDAO;
//import lk.Ijse.FinalProject.dao.impl.RegisterDAOImpl;
import lk.Ijse.FinalProject.dao.DAOFactory;
import lk.Ijse.FinalProject.dto.RegisterDTO;
import lk.Ijse.FinalProject.entity.Register;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {

    RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.REGISTTER);
        @Override
        public List<Register> getAllRegister() throws SQLException, ClassNotFoundException {
            List<Register> allRegisterEntityData = registerDAO.getAll();
            List<RegisterDTO> allDTOData = new ArrayList<>();
            for (Register r : allRegisterEntityData){
                allDTOData.add(new RegisterDTO(r.getRegisterId(),r.getRegiterName(),r.getRegisterPosition(),r.getRegisterPassword()));
            }
            return allRegisterEntityData;
        }


            @Override
            public boolean deleteRegister (String id) throws SQLException, ClassNotFoundException {
                return registerDAO.delete(id);
            }

            @Override
            public boolean saveRegister (Register registerDTO) throws SQLException, ClassNotFoundException {
                return registerDAO.save(registerDTO);
            }

            @Override
            public boolean updateRegister (Register registerDTO) throws SQLException, ClassNotFoundException {
                return registerDAO.update(registerDTO);
            }

            @Override
            public Register searchByRegisterId (String id) throws SQLException, ClassNotFoundException {
                return registerDAO.searchById(id);
            }
        }

