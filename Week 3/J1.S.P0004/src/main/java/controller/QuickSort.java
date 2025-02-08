package controller;

import model.DataOperation;
import java.util.Random;

public class QuickSort implements DataOperation {
    private int[] array;
    private int size;

    public QuickSort(int size) {
        this.array = new int[size];
        this.size = size;
        generateRandomArray();
    }

    private int[] generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100) - 50;
        }
        return array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
        this.size = array.length;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void quickSort() {
        if (array == null || array.length <= 1) {
            return; // Không cần sắp xếp nếu mảng trống hoặc chỉ có 1 phần tử
        }
        quickSortHelper(array, 0, size - 1);

    }
    private void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1); // Sắp xếp bên trái
            quickSortHelper(arr, pi + 1, high); // Sắp xếp bên phải
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Hoán đổi
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Đưa phần tử trục (pivot) về đúng vị trí
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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

