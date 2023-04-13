package coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        if (orders.isEmpty()) {
            order = new Order(1, order.getCustomerName());
        } else {
            Order lastOrder = orders.get(orders.size() - 1);
            order = new Order(lastOrder.getOrderId() + 1, order.getCustomerName());
        }
        orders.add(order);
    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order nextOrder = orders.get(0);
            System.out.println("Delivering order " + nextOrder.getOrderId() + " for " + nextOrder.getCustomerName());
            orders.remove(0);
        }
    }

    public void deliver(int orderId) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getOrderId() == orderId) {
                System.out.println("Delivering order " + order.getOrderId() + " for " + order.getCustomerName());
                orders.remove(i);
                break;
            }
        }
    }

    public void draw() {
        System.out.println("Coffee order board:");
        for (Order order : orders) {
            System.out.println(order.getOrderId() + ": " + order.getCustomerName());
        }
    }
}

