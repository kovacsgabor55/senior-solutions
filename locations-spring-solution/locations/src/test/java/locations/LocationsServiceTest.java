package locations;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LocationsServiceTest {

    @Test
    void getLocations() {
        LocationsService locationsService = new LocationsService();
        String message = locationsService.getLocations();

        assertThat(message).startsWith("[Location{id=1, name='elso', ");
    }
}
