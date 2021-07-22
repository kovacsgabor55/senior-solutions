package locations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@DataJpaTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(statements = "delete from locations")
class LocationsRepositoryIT {

    @Autowired
    LocationRepository locationRepository;

    @Test
    void testPersist() {
        Location location = new Location("name", 5.2, 7.3);
        locationRepository.save(location);
        List<Location> locations = locationRepository.findAll();
        assertThat(locations)
                .extracting(Location::getName)
                .containsExactly("name");
    }
}
