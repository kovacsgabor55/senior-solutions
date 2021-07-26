package bike;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/history")
    public List<Bike> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @GetMapping("/users")
    public Set<String> getAllUsers() {
        return bikeService.getAllUsers();
    }

    @GetMapping("/")
    public String hello() {
        return "Hello server!";
    }
}
