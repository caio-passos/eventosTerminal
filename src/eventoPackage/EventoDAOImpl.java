package eventoPackage;

import util.DatabaseUtil;

import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventoDAOImpl implements EventosDAO {

    //CRUD
    @Override
    public EventoData get(int idEvento) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        EventoData eventoData = null;


        String sql = "SELECT idEvento, nomeEvento, localEvento, categoriaEvento, descricaoEvento," +
                "emailProducao, telefoneProducao, horarioEvento FROM eventos WHERE idEvento = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idEvento);
        ResultSet rs = ps.executeQuery();

        if (rs.next()){
//            int oid = rs.getInt("id");
            idEvento = rs.getInt("idEvento");
            String nomeEvento = rs.getString("nomeEvento");
            String localEvento = rs.getString("localEvento");
            String categoriaEvento = rs.getString("categoriaEvento");
            String descricaoEvento = rs.getString("descricaoEvento");
            String emailProducao = rs.getString("emailProducao");
            String telefoneProducao = rs.getString("telefoneProducao");
            //recebendo o horario em timestamp do DB e connectionvertendo para LocalDateTime
            Timestamp timestamp = rs.getTimestamp("horarioEvento");
            LocalDateTime horarioEventoLocalDateTime = timestamp.toLocalDateTime();

            eventoData = new EventoData(idEvento, nomeEvento, localEvento, categoriaEvento, descricaoEvento, emailProducao, telefoneProducao, horarioEventoLocalDateTime);
        }
        return eventoData;
    }
    @Override
    public List<EventoData> getAll() throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        String sql = "SELECT idEvento, nomeEvento, localEvento, categoriaEvento, descricaoEvento, emailProducao, telefoneProducao, horarioEvento FROM eventos";

        List<EventoData> eventosData = new ArrayList<>();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            int idEvento = rs.getInt("idEvento");
            String nomeEvento = rs.getString("NomeEvento");
            String localEvento = rs.getString("localEvento");
            String categoriaEvento = rs.getString("categoriaEvento");
            String descricaoEvento = rs.getString("DescricaoEvento");
            String telefoneProducao = rs.getString("telefoneProducao");
            String emailProducao =  rs.getString("EmailProducao");
            LocalDateTime horarioEvento = rs.getTimestamp("horarioEvento").toLocalDateTime();

            EventoData eventoData = new EventoData(idEvento, nomeEvento, localEvento, categoriaEvento, descricaoEvento, emailProducao, telefoneProducao, horarioEvento);

            eventosData.add(eventoData);

            return eventosData;
        }


        return null;
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
        LocalDateTime horarioEvento =  eventoData.getHorarioEvento();
        if (horarioEvento != null){
        Timestamp timestamp =  Timestamp.valueOf(horarioEvento);
        ps.setTimestamp(7, timestamp);
        } else{
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

        String sql = "UPDATE eventos set nomeEvento = ?, localEvento = ? , categoriaEvento = ?, descricaoEvento = ?, emailProducao = ?, telefoneProducao = ?, horarioEvento = ? WHERE idEvento = ?";
        //esse bloco de código abaixo se aplica a todos os métodos de manipulação do DB na
        // implementação do GenericDAO
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, eventoData.getNomeEvento());
        ps.setString(2, eventoData.getLocalEvento());
        ps.setString(3, eventoData.getCategoriaEvento());
        ps.setString(4, eventoData.getDescricaoEvento());
        ps.setString(5, eventoData.getEmailProducao());
        ps.setString(6, eventoData.getTelefoneProducao());
        // Convertendo LocalDateTime para Timestamp antes de inserir no banco de dados
        LocalDateTime horarioEvento =  eventoData.getHorarioEvento();
        if (horarioEvento != null){
            Timestamp timestamp =  Timestamp.valueOf(horarioEvento);
            ps.setTimestamp(7, timestamp);
        } else{
            ps.setObject(7, null);
        }

        int result = ps.executeUpdate();
        DatabaseUtil.closePreparedStatement(ps);
        DatabaseUtil.closeConnection(connection);

        return result;
    }

    @Override
    public int delete(EventoData eventoData) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();

        String sql = "DELETE FROM eventos Where idEvento = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, eventoData.getIdEvento());

        int result = ps.executeUpdate();

        DatabaseUtil.closePreparedStatement(ps);
        DatabaseUtil.closeConnection(connection);

        return result;


    }

}
