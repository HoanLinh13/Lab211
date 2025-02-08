package controller;

import model.DataOperation;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch implements DataOperation {
    private int[] array;
    private int size;

    public BinarySearch(int size) {
        array = new int[size];
        this.size = size;
        generateRandomArray();
        Arrays.sort(array);
    }

    private int[] generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100) - 50;
        }
        return array;
    }


    @Override
    public int binarySearch(int x) {
        return binarySearchRecursive(array, 0, size - 1, x);
    }

    private int binarySearchRecursive(int[] arr, int left, int right, int x) {
        if (left > right) {
            return -1; // Không tìm thấy
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == x) {
            return mid; // Tìm thấy phần tử
        }

        if (arr[mid] > x) {
            return binarySearchRecursive(arr, left, mid - 1, x); // Tìm ở nửa bên trái
        }

        return binarySearchRecursive(arr, mid + 1, right, x); // Tìm ở nửa bên phải
    }

    @Override
    public void displayArray() {
        if (array == null || array.length == 0) {
            System.out.println("The array is empty or uninitialized.");
            return;
        }
        System.out.print("[ ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("]");
    }
}
