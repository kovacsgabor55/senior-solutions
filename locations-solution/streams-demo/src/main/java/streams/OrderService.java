package streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    private final List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    //Adjuk vissza, hogy hány darab order elem van a paraméterül kapott státuszból.
    public long countOrdersByStatus(String status) {
        return orders.stream()
                .filter(o -> o.getStatus().equals(status))
                .count();
    }

    //Azokat a rendeléseket, melyek termékei között van a paraméterül kapott kategóriából
    public List<Order> collectOrdersWithProductCategory(String category) {
        return orders
                .stream()
                .filter(o -> o.getProducts()
                        .stream()
                        .anyMatch(p -> p.getCategory().equals(category)))
                .collect(Collectors.toList());
    }

    //Rendelt termékek között azokat akik egy bizonyos ár felett vannak rendelve
    public List<Product> productOverAmountPrice(int amount) {
        return orders
                .stream()
                .flatMap(o -> o.getProducts()
                        .stream())
                .filter(p -> p.getPrice() > amount)
                .distinct()
                .collect(Collectors.toList());
    }
}
