package bike;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BikeControllerTest {

    @Mock
    BikeService bikeService;

    @InjectMocks
    BikeController bikeController;

    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    void getAllBikes() {
        List<Bike> bikes = new ArrayList<>(List.of(
                new Bike("FH675", "US3434", LocalDateTime.parse("2021-06-24 17:12:50", DATE_TIME_FORMAT), 0.8),
                new Bike("FH676", "US3a34", LocalDateTime.parse("2021-06-25 11:20:42", DATE_TIME_FORMAT), 1.2),
                new Bike("FH676", "US3334", LocalDateTime.parse("2021-06-25 12:40:37", DATE_TIME_FORMAT), 0.7),
                new Bike("FH636", "US336", LocalDateTime.parse("2021-06-23 09:36:12", DATE_TIME_FORMAT), 1.9),
                new Bike("FH631", "US346", LocalDateTime.parse("2021-06-24 08:53:21", DATE_TIME_FORMAT), 2.9)));

        when(bikeService.getAllBikes()).thenReturn(bikes);

        List<Bike> result = bikeService.getAllBikes();

        assertThat(result)
                .hasSize(5)
                .extracting(Bike::getBikeId)
                .contains("FH676", "FH631");
        verify(bikeService, times(1)).getAllBikes();
    }

    @Test
    void getAllUsers() {
        when(bikeService.getAllUsers()).thenReturn(Set.of("US3434", "US336"));

        Set<String> result = bikeController.getAllUsers();

        assertThat(result)
                .hasSize(2)
                .contains("US3434", "US336");
        verify(bikeService, times(1)).getAllUsers();
    }
}
