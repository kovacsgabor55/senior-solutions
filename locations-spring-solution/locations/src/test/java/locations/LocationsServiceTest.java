package locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LocationsServiceTest {

    ModelMapper modelMapper = new ModelMapper();

    @Test
    void getLocations() {
        LocationsService locationsService = new LocationsService(modelMapper);
        String message = locationsService.getLocations().toString();

        assertThat(message).startsWith("[LocationDto(id=1, name=elso, ");
    }
}
