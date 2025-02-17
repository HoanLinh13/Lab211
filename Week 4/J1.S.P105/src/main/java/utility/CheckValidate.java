package utility;

import java.util.Scanner;

public class CheckValidate {
    Scanner scanner = new Scanner(System.in);

    public int checkMenu() {
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 0 && number <= 5) {
                    return number;
                } else {
                    System.err.println("Error: Please enter a number between 1 and 5!");
                    System.out.println("Enter your choice: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid input! Please enter a valid integer.");
                System.out.println("Enter your choice: ");
            }
        }
    }

    public boolean checkID(String id) {
        return id.matches("\\d{6}");
    }

    public boolean checkPhone(String phoneNumber) {
        return phoneNumber.matches("\\d{12}");
    }

    public boolean checkContractType(String contractType) {
        return contractType.toLowerCase().equals("Long") || contractType.equals("Short") ;
    }

}
