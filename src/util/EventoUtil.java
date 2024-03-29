package util;

import eventoPackage.EventoDAOImpl;
import eventoPackage.EventoData;

import java.sql.SQLException;
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
        return "Usuário ID: " + usuarioID + ", Nome: " + nomeUsuario + "\n";
    }
}

