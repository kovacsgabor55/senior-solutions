package car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    @Test
    void getAllCars() {
        CarService carService = new CarService();
        String message = carService.getAllCars();

        assertThat(message).startsWith("[Car{brand='BMW', type='M5'}");
    }

    @Test
    void getAllTypes() {
        CarService carService = new CarService();
        String message = carService.getAllTypes();

        assertThat(message).startsWith("[Volkswagen,");
    }
}
