package Utility;

import java.util.Scanner;

public class CheckValidate {
    private static final Scanner scanner = new Scanner(System.in);

    // Kiểm tra nhập số nguyên dương
// Trong lớp CheckValidate
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


    // Kiểm tra course name
// Trong lớp CheckValidate
    public String checkCourseName() {
        while (true) {
            String course = scanner.nextLine().trim();
            if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net") || course.equalsIgnoreCase("C/C++")) {
                return course;
            } else {
                System.err.println("Error: Course must be Java, .Net, or C/C++!");
                System.out.println("Enter course name (There are only three courses: Java, .Net, C/C++): ");
            }
        }
    }
}
