package com.mycompany.j1.s.p0010.view;

import com.mycompany.j1.s.p0010.controller.LinearSearch;

import java.util.Scanner;

public class UserInterface {
    public void start(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements in the array: ");
        int size = scanner.nextInt();

        LinearSearch search = new LinearSearch(size);

        System.out.print("Enter search value: ");
        int searchValue = scanner.nextInt();

        search.displayArray();
        int result = search.search(searchValue);

        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Found " + searchValue + " at index: " + result);
    }
}
