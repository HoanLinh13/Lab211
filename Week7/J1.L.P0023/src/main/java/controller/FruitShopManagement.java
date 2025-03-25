package controller;

import model.Fruit;
import model.Order;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class FruitShopManagement {
    private List<Fruit> fruitList;
    private Hashtable<String, Order> ordersCart;

    public FruitShopManagement() {
        fruitList = new ArrayList<>();
        ordersCart = new Hashtable<>();
    }

    public void addFruit(Fruit fruit) {
        fruitList.add(fruit);
    }

    public void displayFruits() {
        if (fruitList.isEmpty()) {
            System.out.println("There is currently no fruit to buy.");
            return;
        }

        System.out.println("List of Fruit:");
        System.out.printf("%-5s %-15s %-10s %-15s %-15s %n", "Item", "Fruit Name", "Quantity", "Origin", "Price");

        int index = 1;
        for (Fruit fruit : fruitList) {
            System.out.printf("%-5d %-15s %-10d %-15s $%-14.2f%n",
                    index++, fruit.getFruitName(), fruit.getQuantity(), fruit.getOrigin(), fruit.getPrice());
        }
    }

    public boolean addToShoppingCart(int index, int quantity, List<Fruit> cart) {
        if (index < 1 || index > fruitList.size()) {
            System.err.println("Invalid fruit selection!");
            return false;
        }

        // Lấy trái cây theo vị trí trong danh sách
        Fruit selectedFruit = fruitList.get(index - 1);

        // Kiểm tra số lượng tồn kho
        if (selectedFruit.getQuantity() < quantity) {
            System.err.println("Not enough items in stock!");
            return false;
        }

        // Tạo bản sao của trái cây với số lượng đã mua
        Fruit cartItem = new Fruit(
                selectedFruit.getFruitName(),
                selectedFruit.getPrice(),
                quantity, // Số lượng MUA, không phải số lượng tồn kho
                selectedFruit.getOrigin()
        );

        // Kiểm tra xem trái cây đã có trong giỏ chưa
        boolean found = false;
        for (Fruit item : cart) {
            if (item.getFruitName().equalsIgnoreCase(cartItem.getFruitName())
                    && item.getOrigin().equalsIgnoreCase(cartItem.getOrigin())) {
                item.setQuantity(item.getQuantity() + cartItem.getQuantity());
                found = true;
                break;
            }
        }

        if (!found) {
            cart.add(cartItem);
        }

        // Cập nhật số lượng tồn kho
        selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
        return true;
    }

    public void placeOrder(String customerName, List<Fruit> cart) {
        if (cart.isEmpty()) {
            System.err.println("Cart is empty! Cannot place order.");
            return;
        }

        Order newOrder = new Order(customerName);
        for (Fruit item : cart) {
            newOrder.addItem(item); // Thêm bản sao từ giỏ hàng
        }

        ordersCart.put(customerName, newOrder);
        cart.clear(); // Xóa giỏ hàng sau khi đặt

        System.out.println("--- Your Order ---");
        System.out.println(newOrder);
        System.out.println("Order saved successfully!");
    }


    public void viewOrders() {
        for (Order order : ordersCart.values()) {
            System.out.println(order);
        }
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }
}

