package car;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CarControllerIT {

    @Autowired
    CarController carController;

    @Test
    void getAllCarsIT() {
        List<Car> result = carController.getAllCars();

        assertThat(result)
                .hasSize(2)
                .extracting(Car::getBrand)
                .contains("Suzuki", "Opel");
    }

    @Test
    void getAllTypesIT() {
        Set<String> result = carController.getAllBrands();

        assertThat(result)
                .hasSize(2)
                .contains("Suzuki", "Opel");
    }
}
