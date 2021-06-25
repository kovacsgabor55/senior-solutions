package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {

    CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    void getAllCars() {
        List<Car> result = carService.getAllCars();

        assertThat(result)
                .hasSize(2)
                .extracting(Car::getBrand)
                .contains("Suzuki", "Opel");
    }

    @Test
    void getAllTypes() {
        Set<String> result = carService.getAllBrands();

        assertThat(result)
                .hasSize(2)
                .contains("Suzuki", "Opel");
    }
}
