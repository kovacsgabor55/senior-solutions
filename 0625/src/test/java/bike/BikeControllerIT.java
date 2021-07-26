package bike;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BikeControllerIT {

    @Autowired
    BikeController bikeController;

    @Test
    void getAllCarsIT() {
        List<Bike> result = bikeController.getAllBikes();

        assertThat(result)
                .hasSize(5)
                .extracting(Bike::getBikeId)
                .contains("FH676", "FH631");
    }

    @Test
    void getAllTypesIT() {
        Set<String> result = bikeController.getAllUsers();

        assertThat(result)
                .hasSize(5)
                .contains("US3434", "US336");
    }
}
