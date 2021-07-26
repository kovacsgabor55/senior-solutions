package bike;

import java.time.LocalDateTime;

public class Bike {
    String bikeId;
    String userId;
    LocalDateTime lastDock;
    double kilometer;

    public Bike(String bikeId, String userId, LocalDateTime lastDock, double kilometer) {
        this.bikeId = bikeId;
        this.userId = userId;
        this.lastDock = lastDock;
        this.kilometer = kilometer;
    }

    public String getBikeId() {
        return bikeId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getLastDock() {
        return lastDock;
    }

    public double getKilometer() {
        return kilometer;
    }
}
