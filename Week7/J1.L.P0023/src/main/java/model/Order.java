package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private List<Fruit> items;

    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<Fruit>();
    }

    public void addItem(Fruit fruit) {
        items.add(fruit);
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Fruit> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customerName).append("\n");
        sb.append(String.format("%-15s %-10s %-7s %-7s%n", "Product", "Quantity", "Price", "Amount"));

        double total = 0;
        int index = 1;
        for (Fruit fruit : items) {
            double amount = fruit.getQuantity() * fruit.getPrice();
            total += amount;
            sb.append(String.format("%d. %-15s %-10d $%-7.2f $%-7.2f%n",
                    index++, fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), amount));
        }
        sb.append(String.format("Total: $%.2f%n", total));
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Order order = (Order) obj;
        return customerName.equals(order.customerName);
    }

    @Override
    public int hashCode() {
        return customerName.hashCode();
    }
}
