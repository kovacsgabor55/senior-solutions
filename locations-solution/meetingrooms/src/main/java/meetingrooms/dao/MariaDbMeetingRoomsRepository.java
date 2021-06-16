package meetingrooms.dao;

import meetingrooms.entity.MeetingRoom;
import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class MariaDbMeetingRoomsRepository implements MeetingRoomsRepository {
    private JdbcTemplate jdbcTemplate;

    public MariaDbMeetingRoomsRepository() {
        try {
            MariaDbDataSource dataSource;
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/meetingrooms?useUnicode=true");
            dataSource.setUser("meetingrooms");
            dataSource.setPassword("meetingrooms");

            Flyway flyway = Flyway.configure().dataSource(dataSource).load();
            flyway.migrate();

            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Connection failed!", e);
        }
    }

    @Override
    public void save(String name, int width, int height) {
        jdbcTemplate.update("INSERT INTO employees(name,width,height) values(?,?,?)", name, width, height);
    }

    @Override
    public List<MeetingRoom> findAll() {
        return jdbcTemplate.query("select id, name, width, height from meetingrooms order by name",
                (rs, i) -> new MeetingRoom(rs.getLong("id"), rs.getString("name"), rs.getInt("width"), rs.getInt("height")));
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("delete from meetingrooms");
    }

    @Override
    public List<String> listMeetingRoomsByName() {
        return jdbcTemplate.query("select name from meetingrooms order by name asc",
                (rs, i) -> rs.getString("name"));
    }

    @Override
    public List<String> listMeetingRoomsByNameReverse() {
        return jdbcTemplate.query("select name from meetingrooms order by name desc",
                (rs, i) -> rs.getString("name"));
    }
}
