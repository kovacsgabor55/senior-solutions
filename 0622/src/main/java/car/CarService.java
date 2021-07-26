package car;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarService {

    List<Car> cars = new ArrayList<>(List.of(
            new Car("Suzuki", "Swift", 20, Condition.BAD,
                    new ArrayList<>(List.of(
                            new KmState(LocalDate.of(2000, Month.DECEMBER, 1), 100543),
                            new KmState(LocalDate.of(2001, Month.DECEMBER, 1), 415241)))),
            new Car("Opel", "Astra", 13, Condition.EXCELLENT,
                    new ArrayList<>(List.of(
                            new KmState(LocalDate.of(2017, Month.DECEMBER, 1), 5006),
                            new KmState(LocalDate.of(2020, Month.DECEMBER, 1), 154214))))));

    public List<Car> getAllCars() {
        return cars;
    }

    public Set<String> getAllBrands() {
        return cars.stream().map(Car::getBrand).collect(Collectors.toSet());
    }
}
