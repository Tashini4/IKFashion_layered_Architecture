package lk.Ijse.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T>  {
    public List<T> getAll() throws SQLException, ClassNotFoundException ;

    public  boolean update(T dto) throws SQLException, ClassNotFoundException ;

    public T searchById(String id) throws SQLException, ClassNotFoundException ;

    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public  boolean save(T dto) throws SQLException, ClassNotFoundException ;
    public  List<String> getIds() throws SQLException, ClassNotFoundException ;

}
