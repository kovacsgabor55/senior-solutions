package car;

import java.util.List;

public class Car {
    private final String brand;
    private final String type;
    private final int age;
    private final Condition condition;
    private final List<KmState> kmStates;

    public Car(String brand, String type, int age, Condition condition, List<KmState> kmStates) {
        this.brand = brand;
        this.type = type;
        this.age = age;
        this.condition = condition;
        this.kmStates = kmStates;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public Condition getCondition() {
        return condition;
    }

    public List<KmState> getKmStates() {
        return kmStates;
    }
}
