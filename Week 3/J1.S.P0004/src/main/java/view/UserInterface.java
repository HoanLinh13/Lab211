package view;

import controller.QuickSort;

import java.util.Scanner;

public class UserInterface {
    public void start(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of array: ");
        int size = scanner.nextInt();
        QuickSort quickSort = new QuickSort(size);

        System.out.print("Unsorted array: ");
        quickSort.displayArray();

        quickSort.quickSort();
        System.out.print("Sorted array: ");
        quickSort.displayArray();
    }
}
