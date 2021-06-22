package car;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarService {

    List<Car> cars = List.of(new Car("BMW", "M5"),
            new Car("Audi", "A6"),
            new Car("Audi", "RS6"),
            new Car("Volkswagen", "Golf"));

    public String getAllCars() {
        return cars.toString();
    }

    public String getAllTypes() {
        Set<String> brands = cars.stream().map(Car::getBrand).collect(Collectors.toSet());
        return brands.toString();
    }
}
