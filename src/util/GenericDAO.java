package util;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    T get(int idEvento) throws SQLException;

    List<T> getAll() throws SQLException;

    int save(T t)throws SQLException;

    int insert(T t)throws SQLException;

    int update(T t)throws SQLException;

    int delete(T t) throws SQLException;



}
