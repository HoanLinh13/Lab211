package J1.S.P0004;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    private int n;
    private int[] array;

    public QuickSort(int n) {
        this.n = n;
        this.array = new int[n];
    }
    public void enterArray(){
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i < array.length;i++){
            System.out.print("Enter array " + i + ": ");
            System.out.println();
            array[i]= scanner.nextInt();
        }
    }
    public void showArray(){
        for(int i=0;i < array.length;i++){
            System.out.print(array[i]+"  ");
        }
    }
    public void sortArray() {
        quickSort(0, array.length - 1);
    }
    public int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }


}
