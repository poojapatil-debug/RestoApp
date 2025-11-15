package model;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private int orderId;
    private int customerId;
    private List<MenuItem> items;

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = new LinkedList<>();
    }

    public int getOrderId() { return orderId; }
    public int getCustomerId() { return customerId; }
    public List<MenuItem> getItems() { return items; }

    public void addItem(MenuItem item) { items.add(item); }
    public void removeItem(MenuItem item) { items.remove(item); }

    @Override
    public String toString() {
        return "OrderID: " + orderId + ", Customer: " + customerId + ", Items: " + items;
    }
}
