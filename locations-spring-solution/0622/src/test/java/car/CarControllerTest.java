package car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    CarService carService;

    @InjectMocks
    CarController carController;

    @Test
    void getAllCars() {
        List<Car> cars = new ArrayList<>(List.of(
                new Car("Suzuki", "Swift", 20, Condition.BAD,
                        new ArrayList<>(List.of(
                                new KmState(LocalDate.of(2000, Month.DECEMBER, 1), 100543),
                                new KmState(LocalDate.of(2001, Month.DECEMBER, 1), 415241)))),
                new Car("Opel", "Astra", 13, Condition.EXCELLENT,
                        new ArrayList<>(List.of(
                                new KmState(LocalDate.of(2017, Month.DECEMBER, 1), 5006),
                                new KmState(LocalDate.of(2020, Month.DECEMBER, 1), 154214))))));

        when(carService.getAllCars()).thenReturn(cars);

        List<Car> result = carService.getAllCars();

        assertThat(result)
                .hasSize(2)
                .extracting(Car::getBrand)
                .contains("Suzuki", "Opel");
        verify(carService, times(1)).getAllCars();
    }

    @Test
    void getAllTypes() {
        when(carService.getAllBrands()).thenReturn(Set.of("Suzuki", "Opel"));

        Set<String> result = carController.getAllBrands();

        assertThat(result)
                .hasSize(2)
                .contains("Suzuki", "Opel");
        verify(carService, times(1)).getAllBrands();
    }
}
