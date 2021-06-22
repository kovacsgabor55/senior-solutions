package car;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
 class CarIT {

    @Autowired
    CarController carController;

    @Test
    void getAllCarsIT() {
        String message = carController.getAllCars();

        assertThat(message).startsWith("[Car{brand='BMW', type='M5'}");
    }

    @Test
    void getAllTypesIT() {
        String message = carController.getAllTypes();

        assertThat(message).startsWith("[Volkswagen,");
    }
}
