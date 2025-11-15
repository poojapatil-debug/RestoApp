import exception.*;
import model.*;
import service.*;

import java.util.*;

public class RestaurantApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MenuService menuService = new MenuService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Menu Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Order Management");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // fix

                switch (choice) {
                    case 1 -> menuMenu(sc, menuService);
                    case 2 -> customerMenu(sc, customerService);
                    case 3 -> orderMenu(sc, orderService, menuService);
                    case 4 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> throw new MenuSelectionException("Invalid main menu choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.nextLine();
            } catch (MenuSelectionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // ---------------- MENU MANAGEMENT ----------------
    private static void menuMenu(Scanner sc, MenuService menuService) {
        while (true) {
            System.out.println("\n--- MENU MANAGEMENT ---");
            System.out.println("1. Add Menu Item");
            System.out.println("2. View Menu Items");
            System.out.println("3. Update Menu Item");
            System.out.println("4. Delete Menu Item");
            System.out.println("5. Back");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Category: ");
                        String category = sc.next();
                        sc.nextLine();

                        menuService.addMenuItem(new MenuItem(id, name, price, category));
                    }

                    case 2 -> menuService.getAllItems().forEach(System.out::println);

                    case 3 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New Name: ");
                        String name = sc.nextLine();

                        System.out.print("New Price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("New Category: ");
                        String category = sc.next();
                        sc.nextLine();

                        menuService.updateMenuItem(id, name, price, category);
                    }

                    case 4 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        menuService.deleteMenuItem(id);
                    }

                    case 5 -> { return; }

                    default -> throw new MenuSelectionException("Invalid menu option!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // -------- CUSTOMER MENU ----------
    private static void customerMenu(Scanner sc, CustomerService customerService) {
        while (true) {
            System.out.println("\n--- CUSTOMER MANAGEMENT ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Phone: ");
                        String phone = sc.next();
                        sc.nextLine();

                        customerService.addCustomer(new Customer(id, name, phone));
                    }

                    case 2 -> customerService.getAllCustomers().values().forEach(System.out::println);

                    case 3 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New Name: ");
                        String name = sc.nextLine();

                        System.out.print("New Phone: ");
                        String phone = sc.next();
                        sc.nextLine();

                        customerService.updateCustomer(id, name, phone);
                    }

                    case 4 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        customerService.deleteCustomer(id);
                    }

                    case 5 -> { return; }

                    default -> throw new MenuSelectionException("Invalid selection!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // -------- ORDER MENU ----------
    private static void orderMenu(Scanner sc, OrderService orderService, MenuService menuService) {
        while (true) {
            System.out.println("\n--- ORDER MANAGEMENT ---");
            System.out.println("1. Create Order");
            System.out.println("2. View Orders");
            System.out.println("3. Add Item to Order");
            System.out.println("4. Remove Item from Order");
            System.out.println("5. Cancel Order");
            System.out.println("6. Back");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Order ID: ");
                        int orderId = sc.nextInt();

                        System.out.print("Customer ID: ");
                        int customerId = sc.nextInt();
                        sc.nextLine();

                        orderService.createOrder(orderId, customerId);
                    }

                    case 2 -> orderService.getAllOrders().values().forEach(System.out::println);

                    case 3 -> {
                        System.out.print("Order ID: ");
                        int orderId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Menu ID to Add: ");
                        int menuId = sc.nextInt();
                        sc.nextLine();

                        MenuItem item = menuService.getAllItems()
                                .stream()
                                .filter(m -> m.getId() == menuId)
                                .findFirst().orElse(null);

                        if (item != null)
                            orderService.addItemToOrder(orderId, item);
                        else
                            throw new ResourceNotFoundException("Menu item not found!");
                    }

                    case 4 -> {
                        System.out.print("Order ID: ");
                        int orderId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Menu ID to Remove: ");
                        int menuId = sc.nextInt();
                        sc.nextLine();

                        MenuItem item = menuService.getAllItems()
                                .stream()
                                .filter(m -> m.getId() == menuId)
                                .findFirst().orElse(null);

                        if (item != null)
                            orderService.removeItemFromOrder(orderId, item);
                        else
                            throw new ResourceNotFoundException("Menu item not found!");
                    }

                    case 5 -> {
                        System.out.print("Order ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        orderService.cancelOrder(id);
                    }

                    case 6 -> { return; }

                    default -> throw new MenuSelectionException("Invalid option!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
