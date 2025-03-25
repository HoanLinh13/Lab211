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
        // Tạo bản sao để không ảnh hưởng đến trái cây gốc
        Fruit copy = new Fruit(
                fruit.getFruitName(),
                fruit.getPrice(),
                fruit.getQuantity(), // Số lượng ĐÃ MUA
                fruit.getOrigin()
        );
        items.add(copy);
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Fruit> getItems() {
        return items;
    }


    // Hiển thị đơn hàng
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double total = 0.0;

        sb.append("Customer: ").append(customerName).append("\n");
        sb.append(String.format("%-15s %-10s %-10s %-10s%n",
                "Product", "Quantity", "Price", "Amount"));

        int index = 1;
        for (Fruit fruit : items) {
            double amount = fruit.getQuantity() * fruit.getPrice();
            total += amount;

            sb.append(String.format("%d. %-13s %-10d $%-9.2f $%-9.2f%n",
                    index++,
                    fruit.getFruitName(),
                    fruit.getQuantity(), // Số lượng ĐÃ MUA
                    fruit.getPrice(),
                    amount
            ));
        }

        sb.append(String.format("Total: $%.2f%n", total));
        return sb.toString();
    }
}
