package J1.S.P0004;

import Model.EnterArray;
import java.util.ArrayList;


public class QuickSort extends EnterArray {
    protected ArrayList<Integer> data;

    public QuickSort(ArrayList<Integer> data) {
        this.data = data;
    }

    public void showArray(){
        for(int i=0;i < data.size();i++){
            System.out.print(data.get(i)+"  ");
        }
    }
    public void sortArray() {
        quickSort(0, data.size() - 1);
    }

    public int partition(int low, int high) {
        int pivot = data.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (data.get(j) <= pivot) {
                i++;
                int temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, temp);
            }
        }

        int temp = data.get(i + 1);
        data.set(i + 1, data.get(high));
        data.set(high, temp);
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
