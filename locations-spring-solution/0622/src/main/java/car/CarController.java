package car;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/types")
    public String getAllTypes() {
        return carService.getAllTypes();
    }
}
