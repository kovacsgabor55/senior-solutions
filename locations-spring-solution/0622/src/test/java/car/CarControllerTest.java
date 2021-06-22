package car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    CarService carService;

    @InjectMocks
    CarController carController;

    @Test
    void getAllCars() {
        when(carService.getAllCars()).thenReturn("Mock hello");

        String message = carService.getAllCars();

        assertThat(message).isEqualTo("Mock hello");
    }

    @Test
    void getAllTypes() {
        when(carService.getAllTypes()).thenReturn("Mock hello");

        String message = carService.getAllTypes();

        assertThat(message).isEqualTo("Mock hello");
    }
}
