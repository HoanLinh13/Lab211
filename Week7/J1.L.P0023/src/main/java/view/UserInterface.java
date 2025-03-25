package view;

import controller.FruitShopManagement;
import model.Fruit;
import utility.CheckValidate;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    CheckValidate validate = new CheckValidate();
    FruitShopManagement fsManagement = new FruitShopManagement();

//    public UserInterface(FruitShopManagement fsManagement) {
//        this.fsManagement = fsManagement;
//    }

    private int menu(){
        System.out.println("\n=== FRUIT SHOP SYSTEM ===");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        validate.checkMenu(choice);
        return choice;
    }

    public void start() {
        while (true) {
            switch (menu()) {
                case 1 :
                    while (true) {
                            String name;
                            String origin;
                            while (true) {
                                System.out.print("Enter name fruit: ");
                                name = scanner.nextLine();

                                System.out.print("Enter origin: ");
                                origin = scanner.nextLine();

                                if (!validate.isExitsName(name, origin, fsManagement.getFruitList())) {
                                    break;
                                } else {
                                    System.err.println("Error: Fruit with the same name and origin already exists!");
                                }
                            }

                            double price;
                            while (true) {
                                System.out.print("Enter price fruit: ");
                                price = scanner.nextDouble();
                                if (validate.checkPrice(price))
                                    break;
                            }

                            int quantity;
                            while (true) {
                                System.out.print("Enter quantity: ");
                                quantity = scanner.nextInt();
                                scanner.nextLine();
                                if (validate.checkQuantity(quantity))
                                    break;
                            }

                            Fruit fruit = new Fruit(name, price, quantity, origin);
                            fsManagement.addFruit(fruit);

                            System.out.print("Continue to add? (Y/N): ");
                            String type = scanner.nextLine();
                            if (type.equalsIgnoreCase("N"))
                                break;
                    }

                    fsManagement.displayFruits();
                    break;
                case 2 :
                    fsManagement.viewOrders();

                    break;
                case 3 :
                    List<Fruit> cart = new ArrayList<>();
                    boolean shopping = true;
                    while (shopping) {
                        fsManagement.displayFruits();
                        System.out.print("Select fruit ID to buy (0 to exit): ");
                        int choice = scanner.nextInt();

                        if (choice == 0){
                            shopping = false;
                        }

                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();

                        if (fsManagement.addToShoppingCart(choice, quantity, cart)) {
                            System.out.print("Enter your name: ");
                            scanner.nextLine();
                            String customerName = scanner.nextLine();
                            fsManagement.placeOrder(customerName,cart);
                        }
                        break;
                    }

                    break;
                case 4 :
                    System.exit(0);
            }
        }
    }
}
