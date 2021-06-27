package locations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class LocationsService {

    private final ModelMapper modelMapper;

    private final AtomicLong idGenerator = new AtomicLong();

    private final List<Location> locations = new ArrayList<>();

    public LocationsService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        locations.add(new Location(idGenerator.incrementAndGet(), "elso", 2.5, 6.7));
        locations.add(new Location(idGenerator.incrementAndGet(), "masodik", 4.5, 5.7));
        locations.add(new Location(idGenerator.incrementAndGet(), "harmadik", 8.74, 15.74));
    }

    public List<LocationDto> getLocations() {
        Type targetListType = new TypeToken<List<LocationDto>>() {
        }.getType();
        return modelMapper.map(locations, targetListType);
    }

    public List<LocationDto> listFavoriteLocations(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<LocationDto>>() {
        }.getType();
        List<Location> filtered = locations.stream()
                .filter(e -> prefix.isEmpty() || e.getName().toLowerCase().startsWith(prefix.get().toLowerCase()))
                .collect(Collectors.toList());
        return modelMapper.map(filtered, targetListType);
    }

    public LocationDto findLocationsById(long id) {
        return modelMapper.map(locations.stream()
                        .filter(e -> e.getId() == id).findAny()
                        .orElseThrow(() -> new LocationNotFoundException("Location not fount: " + id)),
                LocationDto.class);
    }

    public LocationDto createLocation(CreateLocationCommand command) {
        Location location = new Location(idGenerator.incrementAndGet(), command.getName(), command.getLat(), command.getLon());
        locations.add(location);
        return modelMapper.map(location, LocationDto.class);
    }

    public LocationDto updateLocation(long id, UpdateLocationCommand command) {
        Location location = locations.stream()
                .filter(e -> e.getId() == id)
                .findFirst().orElseThrow(() -> new LocationNotFoundException("Location not found: " + id));
        location.setName(command.getName());
        location.setLat(command.getLat());
        location.setLon(command.getLon());
        return modelMapper.map(location, LocationDto.class);
    }

    public void deleteLocation(long id) {
        Location location = locations.stream()
                .filter(e -> e.getId() == id)
                .findFirst().orElseThrow(() -> new LocationNotFoundException("Location not found: " + id));
        locations.remove(location);
    }

}
