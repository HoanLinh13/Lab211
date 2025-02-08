package view;

import controller.BinarySearch;

import java.util.Scanner;

public class UserInterface {
    public void start(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of array: ");
        int size = scanner.nextInt();
        BinarySearch bs = new BinarySearch(size);

        System.out.println("Enter search value: ");
        int searchValue = scanner.nextInt();
        System.out.print("Sorted array: ");
        bs.displayArray();
        if (bs.binarySearch(searchValue) == -1)
            System.out.println("Element not found");
        else
            System.out.println("Found " + searchValue + " at index " + bs.binarySearch(searchValue));

    }
}
