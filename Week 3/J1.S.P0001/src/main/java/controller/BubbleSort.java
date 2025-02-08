package controller;

import model.DataOpperation;

import java.util.Random;

public class BubbleSort implements DataOpperation {
    private int[] array;
    private int size;

    public BubbleSort(int size) {
        this.size = size;
        this.array = new int[size];
        generateRandomArray(); // Khởi tạo mảng
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
        this.size = array.length; // Đồng bộ kích thước với mảng mới
    }

    // Tạo mảng ngẫu nhiên
    private int[] generateRandomArray() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            this.array[i] = rand.nextInt(100) - 50; // Số ngẫu nhiên từ -50 đến 50
        }
        return array;
    }

    @Override
    public void bubbleSort() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Hoán đổi
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
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
