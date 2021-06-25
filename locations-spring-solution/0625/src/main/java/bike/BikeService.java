package bike;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BikeService {

    private final List<Bike> bikes = new ArrayList<>();
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String SEPARATOR = ";";
    private static final String FILE = "/bikes.csv";

    public List<Bike> getAllBikes() {
        if (bikes.isEmpty()) {
            loadAllBikeData();
        }
        return new ArrayList<>(bikes);
    }

    public Set<String> getAllUsers() {
        return bikes.stream().map(Bike::getUserId).collect(Collectors.toSet());
    }

    private void loadAllBikeData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(BikeService.class.getResourceAsStream(FILE)))) {
            bikes.addAll(readAndParse(reader));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private List<Bike> readAndParse(BufferedReader reader) throws IOException {
        String line;
        List<Bike> parsed = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(SEPARATOR);
            parsed.add(new Bike(data[0],
                    data[1],
                    LocalDateTime.parse(data[2], DATE_TIME_FORMAT),
                    Double.parseDouble(data[3])));
        }
        return parsed;
    }
}
