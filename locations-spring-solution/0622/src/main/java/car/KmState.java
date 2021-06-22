package car;

import java.util.Date;
import java.util.List;

public class KmState {
    private Date date;
    private double kilometer;
    private int age;
    private List<KmState> kmStates;

    public KmState(Date date, double kilometer, int age, List<KmState> kmStates) {
        this.date = date;
        this.kilometer = kilometer;
        this.age = age;
        this.kmStates = kmStates;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<KmState> getKmStates() {
        return kmStates;
    }

    public void setKmStates(List<KmState> kmStates) {
        this.kmStates = kmStates;
    }
}
