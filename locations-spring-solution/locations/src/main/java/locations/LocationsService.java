package locations;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsService {
    private List<Location> locations = List.of(
            new Location(1L, "elso", 2.5, 6.7),
            new Location(2L, "masodik", 4.5, 5.7),
            new Location(3L, "harmadik", 8.74, 15.74)
    );

    public String getLocations() {
        return locations.toString();
    }
}
