package util;

import eventoPackage.EventoDAOImpl;
import eventoPackage.EventoData;
import usuarioPackage.UsuarioData;

import java.sql.*;
import java.util.List;

public class EventoUtil {
    public static void listarEventos() throws SQLException {

        EventoDAOImpl eventoDAO = new EventoDAOImpl();
        List<EventoData> eventos = eventoDAO.getAll();

        if (eventos != null && !eventos.isEmpty()) {
            System.out.println("Lista de Eventos:");
            for (EventoData evento : eventos) {
                System.out.println(evento);
            }
        } else {
            System.out.println("Nenhum evento encontrado");
        }
    }
    //printar todos os nomes de usuários
    @Override
    public String toString() {
        try {
            String sqlbuscaUsers = "SELECT * FROM usuario ";
            Connection connection = DatabaseUtil.getConnection();
            Statement psAllUsers = connection.createStatement();
            ResultSet rs = psAllUsers.executeQuery(sqlbuscaUsers);

            while (rs.next()){

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        UsuarioData usuarioData = new UsuarioData();
        String nomeUser = usuarioData.getNomeUsuario();
        int usuarioID = usuarioData.getIdUsuario();
        return "Usuário ID: " + usuarioID + ", Nome: " + nomeUser + "\n";
    }
}

