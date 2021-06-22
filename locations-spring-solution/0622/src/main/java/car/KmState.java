package car;

import java.time.LocalDate;

public class KmState {
    private final LocalDate date;
    private final double kilometer;

    public KmState(LocalDate date, double kilometer) {
        this.date = date;
        this.kilometer = kilometer;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getKilometer() {
        return kilometer;
    }
}
