package controller;

import model.Fruit;
import model.Order;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class FruitShopManagement {
    private List<Fruit> fruitList;
    private Hashtable<Order, List<Fruit>> ordersCart = new Hashtable<>(); // Danh sách đơn hàng
    private int countID = 0;

    public FruitShopManagement() {
        fruitList = new ArrayList<Fruit>();
    }

    public void addFruit(Fruit fruit) {
        fruit.setFruitId(++countID);
        fruitList.add(fruit);
    }

    public void displayFruits() {
        if (fruitList.isEmpty()) {
            System.out.println("There is currently no fruit to buy.");
        }

        System.out.println("List of Fruit:");
        System.out.printf("%-5s %-15s %-10s %-15s %-15s %n", "Item", "Fruit Name", "Quantity", "Origin", "Price");
        for (Fruit fruit : fruitList) {
            System.out.println(fruit);
        }
    }


    public boolean addToShoppingCart(int index, int quantity, List<Fruit> cart) {
        Fruit selectedFruit = fruitList.get(index - 1); // Lấy trái cây theo vị trí trong danh sách

        System.out.println("You selected : " + selectedFruit.getFruitName());
        // kiểm tra số lượng item có đủ kh
        if (selectedFruit.getQuantity() >= quantity) {
            cart.add(new Fruit(selectedFruit.getFruitName(), selectedFruit.getPrice(), quantity, selectedFruit.getOrigin()));
            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);

            return true;
        } else {
            System.err.println("Not enough items in the current warehouse!");

            return false;
        }

    }

    public boolean placeOrder(String customerName, int quantity, List<Fruit> cart) {
        if (!cart.isEmpty()) {
            Order newOrder = new Order(customerName);
            ordersCart.put(newOrder, new ArrayList<>(cart)); // Lưu danh sách sản phẩm vào đơn hàng

            System.out.println("--- Your Order List ---");
            System.out.printf("%-15s %-10s %-7s %-7s %n", "Product", "Quantity", "Price", "Amount");

            double total = 0;
            for (Fruit fruit : cart) {
                double amount = fruit.getPrice() * fruit.getQuantity();
                total += amount;
                System.out.printf("%-15s %-10d $%-7.2f $%-7.2f %n", fruit.getFruitName(), quantity, fruit.getPrice(), amount);
            }
            System.out.printf("Total: $%.2f\n", total);

            cart.clear();
            System.out.println("Your order has been saved!");

            return true;
        } else {
            System.err.println("Cart is empty! Cannot place an order.");

            return false;
        }
    }

    public void viewOrders() {
        if (ordersCart.isEmpty()) {
            System.out.println("No orders found!");
            return;
        }

        for (Order order : ordersCart.keySet()) {
            System.out.println("Customer: " + order.getCustomerName());
            System.out.printf("%-15s %-10s %-7s %-7s %n", "Product", "Quantity", "Price", "Amount");

            List<Fruit> cart = ordersCart.get(order); // ✅ Lấy đúng danh sách
            if (cart == null || cart.isEmpty()) {
                System.out.println("No items found for this order.");
                continue;
            }

            double total = 0;
            int index = 1;
            for (Fruit fruit : cart) {
                double amount = fruit.getQuantity() * fruit.getPrice();
                total += amount;
                System.out.printf("%d. %-15s %-10d $%-7.2f $%-7.2f %n", index++, fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), amount);
            }
            System.out.printf("Total: $%.2f\n\n", total);
        }
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }
}

