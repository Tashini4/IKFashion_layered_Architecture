package lk.Ijse.FinalProject.BO;

import lk.Ijse.FinalProject.BO.custom.impl.*;
import lk.Ijse.FinalProject.dao.CrudDAO;


public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory == null)?boFactory = new BOFactory():boFactory;
    }
    public enum BOType{
        CUSTOMER,ITEM,ORDER,INVENTORY,REGISTTER,SALARY,SUPPLIER,EMPLOYEE,PAYMENT,ORDERDETAILS
    }

    public SuperBO getBO(BOType type){
        switch (type){
            case CUSTOMER :
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return (SuperBO) new OrderBOImpl();
            case INVENTORY:
                return new InventoryBOImpl();
            case REGISTTER:
                return new RegisterBOImpl();
            case SALARY:
                return new SalaryBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case ORDERDETAILS:
                return new OrderDetailsBOImpl();
            default:
                return null;
        }
    }
}
