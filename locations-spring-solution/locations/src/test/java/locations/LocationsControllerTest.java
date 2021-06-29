package locations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LocationsControllerTest {

    @Mock
    LocationsService locationsService;

    @InjectMocks
    LocationsController locationsController;

//    @Test
//    void getLocations() {
//        List<Location> expected = new ArrayList<>(List.of(
//
//                new Location(1L, "elso", 2.5, 6.7),
//                new Location(2L, "masodik", 4.5, 5.7),
//                new Location(3L, "harmadik", 8.74, 15.74)
//
//        ));
//
//        when(locationsController.getLocations()).thenReturn(expected);
//
//        String message = locationsService.getLocations().toString();
//
//        assertThat(message).isEqualTo("[Location(id=1, name=elso, ");
//    }
}
