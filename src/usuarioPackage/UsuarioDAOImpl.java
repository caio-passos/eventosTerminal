package usuarioPackage;

import eventoPackage.EventosDAO;
import util.DatabaseUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl {

    public UsuarioData get(int idUsuario)throws SQLException{
        Connection connection = DatabaseUtil.getConnection();
        UsuarioData usuarioData = null ;

        String sql = "SELECT idUsuario, CPF, nomeUsuario, emailUsuario, cidadeUsuario, telefone FROM usuario WHERE idUsuario = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            idUsuario = rs.getInt("idUsuario");
            String CPF = rs.getString("CPF");
            String nomeUsuario = rs.getString("nomeUsuario");
            String emailUsuario = rs.getString("emailUsuario");
            String cidadeUsuario = rs.getString("cidadeUsuario");
            String telefone = rs.getString("telefone");

            usuarioData = new UsuarioData(idUsuario, CPF, nomeUsuario, emailUsuario, cidadeUsuario, telefone);
        }
        return usuarioData;
    }
    public List<UsuarioData> getAll() throws SQLException{
        Connection connection = DatabaseUtil.getConnection();
        String sql = "SELECT idUsuario, CPF, nomeUsuario, emailUsuario, cidadeUsuario, telefone FROM usuario";

        List<UsuarioData> usuariosData = new ArrayList<>();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            int idUsuario = rs.getInt("idUsuario");
            String CPF = rs.getString("CPF");
            String nomeUsuario = rs.getString("nomeUsuario");
            String emailUsuario = rs.getString("emailUsuario");
            String cidadeUsuario = rs.getString("cidadeUsuario");
            String telefone = rs.getString("telefone");

            UsuarioData usuarioData = new UsuarioData(idUsuario, CPF, nomeUsuario, emailUsuario, cidadeUsuario, telefone);

            usuariosData.add(usuarioData);

            return usuariosData;

        }
        return null;
    }
    public int save(UsuarioData usuarioData)throws SQLException{
        //fazer
        return 0;
    }
    public int insert (UsuarioData usuarioData)throws SQLException{
        Connection connection = DatabaseUtil.getConnection();

        String sql = "INSERT INTO usuario(idUsuario, CPF, nomeUsuario, emailUsuario, cidadeUsuario, telefone) VALUES(?,?,?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, usuarioData.getIdUsuario());
        ps.setString(2, usuarioData.getCPF());
        ps.setString(3, usuarioData.getNomeUsuario());
        ps.setString(4,usuarioData.getEmailUsuario());
        ps.setString(5,usuarioData.getCidadeUsuario());
        ps.setString(6,usuarioData.getTelefone());

        //resultado do set
        int result = ps.executeUpdate();
        //fechando a conexão com o banco
        DatabaseUtil.closePreparedStatement(ps);
        DatabaseUtil.closeConnection(connection);

        return result;

    }
    public int update(UsuarioData usuarioData)throws SQLException{
        Connection connection = DatabaseUtil.getConnection();
        String sql = "UPDATE eventos set idUsuario = ?, CPF = ?, nomeUsuario = ?, emailUsuario = ?,  cidadeUsuario = ?, telefone = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, usuarioData.getIdUsuario());
        ps.setString(2, usuarioData.getCPF());
        ps.setString(3, usuarioData.getNomeUsuario());
        ps.setString(4,usuarioData.getEmailUsuario());
        ps.setString(5,usuarioData.getCidadeUsuario());
        ps.setString(6,usuarioData.getTelefone());

        int result = ps.executeUpdate();
        DatabaseUtil.closePreparedStatement(ps);
        DatabaseUtil.closeConnection(connection);

        return result;
    }

    public int delete(UsuarioData usuarioData)throws SQLException{
        Connection connection = DatabaseUtil.getConnection();

        String sql = "DELETE FROM usuario Where idUsuario = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, usuarioData.getIdUsuario());

        int result = ps.executeUpdate();

        DatabaseUtil.closePreparedStatement(ps);
        DatabaseUtil.closeConnection(connection);

        return result;
    }
}
