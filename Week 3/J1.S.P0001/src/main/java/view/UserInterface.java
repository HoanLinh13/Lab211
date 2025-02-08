package view;

import controller.BubbleSort;

import java.util.Scanner;

public class UserInterface {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of array: ");
        int size = scanner.nextInt();
        BubbleSort bubbleSort = new BubbleSort(size);

        System.out.print("Unsorted array: ");
        bubbleSort.displayArray();

        bubbleSort.bubbleSort();
        System.out.print("Sorted array: ");
        bubbleSort.displayArray();
    }
}
