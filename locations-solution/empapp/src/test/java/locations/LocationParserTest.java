package locations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationParserTest {

    LocationParser locationParser;

    @BeforeEach
    void init() {
        locationParser = new LocationParser();
    }

    @Test
    @DisplayName("Parser test")
    void testParse() {
        Location loc = locationParser.parse("Budapest,47.497912,19.040235");
        assertEquals("Budapest", loc.getName());
        assertEquals(47.497912, loc.getLat());
        assertEquals(19.040235, loc.getLon());
    }

}