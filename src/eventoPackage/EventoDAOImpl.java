package eventoPackage;

import java.sql.SQLException;
import java.util.List;

public class EventoDAOImpl implements EventosDAO{
    @Override
    public EventoData get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<EventoData> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(EventoData eventoData) throws SQLException {
        return 0;
    }

    @Override
    public int insert(EventoData eventoData) throws SQLException {
        return 0;
    }

    @Override
    public int update(EventoData eventoData) throws SQLException {
        return 0;
    }

    @Override
    public int delete(EventoData eventoData) {
        return 0;
    }
}
