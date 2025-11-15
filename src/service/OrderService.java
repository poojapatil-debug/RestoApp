package service;

import model.*;
import exception.*;

import java.util.HashMap;

public class OrderService {

    private HashMap<Integer, Order> orderMap = new HashMap<>();

    public void createOrder(int orderId, int customerId) throws DuplicateEntryException {
        if (orderMap.containsKey(orderId))
            throw new DuplicateEntryException("Order ID already exists!");

        orderMap.put(orderId, new Order(orderId, customerId));
    }

    public void addItemToOrder(int orderId, MenuItem item) throws ResourceNotFoundException {
        Order order = orderMap.get(orderId);
        if (order == null) throw new ResourceNotFoundException("Order not found!");

        order.addItem(item);
    }

    public void removeItemFromOrder(int orderId, MenuItem item) throws ResourceNotFoundException {
        Order order = orderMap.get(orderId);
        if (order == null) throw new ResourceNotFoundException("Order not found!");

        order.removeItem(item);
    }

    public HashMap<Integer, Order> getAllOrders() {
        return orderMap;
    }

    public void cancelOrder(int id) throws ResourceNotFoundException {
        if (orderMap.remove(id) == null)
            throw new ResourceNotFoundException("Order not found!");
    }
}
