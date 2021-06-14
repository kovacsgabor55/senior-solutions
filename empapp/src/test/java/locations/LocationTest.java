package locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    Location location;

    @BeforeEach
    void init() {
        location = new Location("Budapest", 47.497912, 19.040235);
    }

    @Test
    void constructorTest() {
        assertEquals("Budapest", location.getName());
        assertEquals(47.497912, location.getLat());
        assertEquals(19.040235, location.getLon());
    }

    @Test
    void isOnEquator() {
        Location location1 = new Location("Equator", 0d, 19.040235);
        assertFalse(location.isOnEquator());
        assertTrue(location1.isOnEquator());
    }

    @Test
    void isOnPrimeMeridian() {
        Location location1 = new Location("PrimeMeridian", 47.497912, 0d);
        assertFalse(location.isOnPrimeMeridian());
        assertTrue(location1.isOnPrimeMeridian());
    }

    @Test
    @DisplayName("Distance calculate")
    void distanceFrom() {
        double distance=location.distanceFrom(new Location("PrimeMeridian", 47.497912, 0d));
        assertEquals(1426808.42, distance,0.05);
    }
}
