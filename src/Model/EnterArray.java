package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class EnterArray {
    private Scanner scanner;

    public EnterArray() {
        this.scanner = new Scanner(System.in);
    }
    public ArrayList<Integer> getInputArray() {
        ArrayList<Integer> inputArray = new ArrayList<>();

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + i + " : ");
            inputArray.add(scanner.nextInt());
            System.out.println();
        }

        return inputArray;
    }
}