package bike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BikeServiceTest {

    BikeService bikeService;

    @BeforeEach
    void setUp() {
        bikeService = new BikeService();
    }

    @Test
    void getAllBikes() {
        List<Bike> result = bikeService.getAllBikes();

        assertThat(result)
                .hasSize(5)
                .extracting(Bike::getBikeId)
                .contains("FH676", "FH631");
    }

    @Test
    void getAllBrands() {
        bikeService.getAllBikes();
        Set<String> result = bikeService.getAllUsers();

        assertThat(result)
                .hasSize(5)
                .contains("US3434", "US336");
    }
}
