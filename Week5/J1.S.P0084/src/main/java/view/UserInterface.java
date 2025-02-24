package view;

import model.LargeNumberCalculator;

import java.util.Scanner;

public class UserInterface {
    private LargeNumberCalculator calculator;

    public UserInterface(LargeNumberCalculator calculator) {
        this.calculator = calculator;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        String num1Str = scanner.nextLine();
        System.out.print("Enter the second number: ");
        String num2Str = scanner.nextLine();

        int[] num1 = convertStringToArray(num1Str);
        int[] num2 = convertStringToArray(num2Str);

        System.out.print("Sum: ");
        printArrayAsNumber(calculator.addLargeNumbers(num1, num2));

        System.out.print("product: ");
        printArrayAsNumber(calculator.multiplyLargeNumbers(num1, num2));
    }

    private int[] convertStringToArray(String num) {
        int[] result = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            result[i] = num.charAt(i) - '0';
        }
        return result;
    }

    private void printArrayAsNumber(int[] num) {
        boolean leadingZero = true;
        for (int digit : num) {
            if (digit != 0) {
                leadingZero = false;
            }
            if (!leadingZero) {
                System.out.print(digit);
            }
        }
        if (leadingZero) {
            System.out.print("0");
        }
        System.out.println();
    }
}
