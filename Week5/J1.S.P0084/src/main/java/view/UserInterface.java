package view;

import controller.LargeNumberManager;
import model.LargeNumberCalculator;
import model.Number;

import java.util.Scanner;

public class UserInterface {
    private LargeNumberCalculator calculator = new LargeNumberManager();

    public UserInterface(LargeNumberCalculator calculator) {
        this.calculator = calculator;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        String num1Str = scanner.nextLine();
        System.out.print("Enter the second number: ");
        String num2Str = scanner.nextLine();

        Number num1 = new Number(num1Str);
        Number num2 = new Number(num2Str);

        System.out.print("Sum: ");
        calculator.printNumber(calculator.addLargeNumbers(num1, num2));

        System.out.print("product: ");
        calculator.printNumber(calculator.multiplyLargeNumbers(num1, num2));
    }


}
