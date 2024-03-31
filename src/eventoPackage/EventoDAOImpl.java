package eventoPackage;

import util.DatabaseUtil;

import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventoDAOImpl implements EventosDAO {

    //CRUD
    @Override
    public EventoData get(int idEvento) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        EventoData eventoData = null;


        String sql = "SELECT idEvento, nomeEvento, localEvento, categoriaEvento, descricaoEvento," +
                "emailProducao, telefoneProducao, horarioEvento, idUsuario FROM eventos WHERE idEvento = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idEvento);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            String nomeEvento = rs.getString("nomeEvento");
            String localEvento = rs.getString("localEvento");
            String categoriaEvento = rs.getString("categoriaEvento");
            String descricaoEvento = rs.getString("descricaoEvento");
            String emailProducao = rs.getString("emailProducao");
            String telefoneProducao = rs.getString("telefoneProducao");
            //recebendo o horario em timestamp do DB e connectionvertendo para LocalDateTime
            Timestamp timestamp = rs.getTimestamp("horarioEvento");
            LocalDateTime horarioEventoLocalDateTime = timestamp.toLocalDateTime();
            int idUsuario = rs.getInt("idUsuario");

            eventoData = new EventoData(nomeEvento, localEvento, categoriaEvento, descricaoEvento, emailProducao, telefoneProducao, horarioEventoLocalDateTime, idUsuario);
        }
        return eventoData;
    }

    @Override
    public List<EventoData> getAll() throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        String sql = "SELECT nomeEvento, localEvento, categoriaEvento, descricaoEvento, emailProducao, telefoneProducao, horarioEvento, idUsuario FROM eventos";

        List<EventoData> eventosData = new ArrayList<>();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String nomeEvento = rs.getString("NomeEvento");
            String localEvento = rs.getString("localEvento");
            String categoriaEvento = rs.getString("categoriaEvento");
            String descricaoEvento = rs.getString("DescricaoEvento");
            String telefoneProducao = rs.getString("telefoneProducao");
            String emailProducao = rs.getString("EmailProducao");
            LocalDateTime horarioEvento = rs.getTimestamp("horarioEvento").toLocalDateTime();
            int idUsuario = rs.getInt("idUsuario");

            EventoData eventoData = new EventoData(nomeEvento, localEvento, categoriaEvento, descricaoEvento, emailProducao, telefoneProducao, horarioEvento, idUsuario);

            eventosData.add(eventoData);
        }
        return eventosData;
    }

    @Override
    public int save(EventoData eventoData) throws SQLException {
        return 0;
    }

    @Override
    public int insert(EventoData eventoData) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();

        String sql = "INSERT INTO eventos(nomeEvento, localEvento, categoriaEvento, descricaoEvento, emailProducao, telefoneProducao, horarioEvento) VALUES (?,?,?,?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, eventoData.getNomeEvento());
        ps.setString(2, eventoData.getLocalEvento());
        ps.setString(3, eventoData.getCategoriaEvento());
        ps.setString(4, eventoData.getDescricaoEvento());
        ps.setString(5, eventoData.getEmailProducao());
        ps.setString(6, eventoData.getTelefoneProducao());
        // Convertendo LocalDateTime para Timestamp antes de inserir no banco de dados
        LocalDateTime horarioEvento = eventoData.getHorarioEvento();
        if (horarioEvento != null) {
            Timestamp timestamp = Timestamp.valueOf(horarioEvento);
            ps.setTimestamp(7, timestamp);
        } else {
            ps.setObject(7, null);
        }
        int result = ps.executeUpdate();

        DatabaseUtil.closePreparedStatement(ps);
        DatabaseUtil.closeConnection(connection);

        return result;
    }

    @Override
    public int update(EventoData eventoData) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        //Codigo para obter os eventos pesquisados pelo usuário
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do evento que quer modificar:");
        String nomeBusca = scanner.nextLine();
        scanner.close();

        //consulta SQL para buscar nomes similares ao evento
        String sqlBusca = "SELECT * FROM eventos where nomeEvento LIKE ?";
        PreparedStatement psBusca = connection.prepareStatement(sqlBusca);
        psBusca.setString(1, "%" + nomeBusca + "%");
        ResultSet buscaQuery = psBusca.executeQuery();
        //Listando os eventos encontrados com nomes similares
        System.out.println("Eventos similares:\n");
        while (buscaQuery.next()) {
            int idEvento = buscaQuery.getInt("idEvento");
            String nomeEvento = buscaQuery.getString("nomeEvento");
            System.out.println(idEvento + ": " + nomeEvento);
        }


        String sql = "UPDATE eventos set nomeEvento = ?, localEvento = ? , categoriaEvento = ?, descricaoEvento = ?, emailProducao = ?, telefoneProducao = ?, horarioEvento = ?, idUsuario = ? WHERE idEvento = ?";
        //esse bloco de código abaixo se aplica a todos os métodos de manipulação do DB na
        // implementação do GenericDAO
        PreparedStatement ps = connection.prepareStatement(sql);
        System.out.println(eventoData.getNomeEvento());
        ps.setString(1, eventoData.getNomeEvento());
        System.out.println(eventoData.getNomeEvento() + "\n");
        System.out.println(eventoData.getLocalEvento() + "\n");
        ps.setString(2, eventoData.getLocalEvento() + "\n");
        System.out.println(eventoData.getLocalEvento() + "\n");
        System.out.println(eventoData.getCategoriaEvento() + "\n");
        ps.setString(3, eventoData.getCategoriaEvento());
        System.out.println(eventoData.getLocalEvento() + "\n");
        System.out.println(eventoData.getDescricaoEvento() + "\n");
        ps.setString(4, eventoData.getDescricaoEvento());
        System.out.println(eventoData.getDescricaoEvento() + "\n");
        System.out.println(eventoData.getEmailProducao() + "\n");
        ps.setString(5, eventoData.getEmailProducao());
        System.out.println(eventoData.getEmailProducao() + "\n");
        System.out.println(eventoData.getTelefoneProducao() + "\n");
        ps.setString(6, eventoData.getTelefoneProducao());
        System.out.println(eventoData.getEmailProducao() + "\n");
        // Convertendo LocalDateTime para Timestamp antes de inserir no banco de dados
        LocalDateTime horarioEvento = eventoData.getHorarioEvento();
        if (horarioEvento != null) {
            Timestamp timestamp = Timestamp.valueOf(horarioEvento);
            ps.setTimestamp(7, timestamp);
        } else {
            ps.setObject(7, null);
        }
        System.out.println(eventoData.getIdUsuario());
        ps.setInt(1, eventoData.getIdUsuario());
        System.out.println(eventoData.getIdUsuario());

        int result = ps.executeUpdate();
        DatabaseUtil.closePreparedStatement(ps);
        DatabaseUtil.closeConnection(connection);

        return result;
    }

    @Override
    public int delete(EventoData eventoData) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();

        String sql = "DELETE FROM eventos Where nomeEvento = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, eventoData.getNomeEvento());

        int result = ps.executeUpdate();

        DatabaseUtil.closePreparedStatement(ps);
        DatabaseUtil.closeConnection(connection);

        return result;


    }

    @Override
    public int getIdUsuario(EventoData eventoData) throws SQLException {
        //this code will return the number of the idUsuario in the eventos table. the idUsuario is a
        //foreing key from the usuario table
        Connection connection = DatabaseUtil.getConnection();
        String sqlIdBusca = "SELECT idUsuario FROM eventos WHERE nomeEvento = ?";
        PreparedStatement psNomeEvento = connection.prepareStatement(sqlIdBusca);
        psNomeEvento.setString(1, eventoData.getNomeEvento());

        ResultSet rsNomeUsuario = psNomeEvento.executeQuery();

        if (rsNomeUsuario.next()) {
            int idUsuario = rsNomeUsuario.getInt("idUsuario");
            String aviso = "Sem eventos com o nome: " + eventoData.getNomeEvento();
            if (eventoData.getIdUsuario() > 0) {
                //incrementando com a mensagem anterior
                aviso += ", atribuídos ao usuário: " +
                        eventoData.getIdUsuario();

            }
            return idUsuario;

        }
        return 0;
    }

    public List<EventoData> eventosPassados() {

        List<EventoData> eventosPassados = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM eventos WHERE TIMESTAMPDIFF(DAY, '0000-00-00', horarioEvento) <= 0");

            while(rs.next()) {

                Timestamp timestamp = rs.getTimestamp("horarioEvento");
                LocalDateTime horarioEvento = timestamp != null ? timestamp.toLocalDateTime() : null;
                EventoData evento = new EventoData(
                        rs.getString("nomeEvento"),
                        rs.getString("localEvento"),
                        rs.getString("categoriaEvento"),
                        null,
                        null,
                        null,
                        null,
                        // pass other required fields here
                        0);
                eventosPassados.add(evento);
            }
        } catch (SQLException e) {
            // Handle SQL Exception here
            System.out.println("Nenhum evento ocorrido");
        }
        return eventosPassados;
    }



}
