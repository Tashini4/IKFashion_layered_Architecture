package lk.Ijse.FinalProject.dao;

import lk.Ijse.FinalProject.dao.Custom.InventoryDAO;
import lk.Ijse.FinalProject.dao.Custom.impl.CustomerDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)? daoFactory = new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,INVENTORY,REGISTTER,SALARY,SUPPLIER
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case CUSTOMER :
               // return  new CustomerDAOImpl();
        }
    }








    }

