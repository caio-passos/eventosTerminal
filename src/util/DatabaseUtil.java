package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {

    private static String url = "jdbc:mysql://localhost:3306/eventos";
    private static String user = "root";
    private static String password = "123456";

    private DatabaseUtil() {


    }

    public static Connection getConnection()throws SQLException{
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    //para fechar a conexão com o DB
    public static void closeConnection(Connection connection){
        if (connection != null){
            try{
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //para fechar o PS
    public static void closePreparedStatement(PreparedStatement ps){
        if (ps != null){
            try{
                ps.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
