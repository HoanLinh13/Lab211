package J1.S.P0006;

import Model.EnterArray;
import java.util.ArrayList;

public class BinarySearch extends EnterArray {
    protected ArrayList<Integer> data;

    public BinarySearch(ArrayList<Integer> data) {
        this.data = data;
    }

    public void output(ArrayList<Integer> a) {
        System.out.println(a);
    }

    public void sort(ArrayList<Integer> numArray, int left, int right) {
        int i, j, middle;
        middle = (numArray.get(left) + numArray.get(right)) / 2;
        i = left;
        j = right;
        do {
            while (numArray.get(i) < middle) {
                i++;
            }
            while (numArray.get(j) > middle) {
                j--;
            }
            if (i <= j) {
                int swap = numArray.get(i);
                numArray.set(i, numArray.get(j));
                numArray.set(j, swap);
                i++;
                j--;
            }
        } while (i < j);

        if (left < j) {
            sort(numArray, left, j);
        }
        if (i < right) {
            sort(numArray, i, right);
        }
    }


    public int search(ArrayList<Integer> numArray,int left , int right, int n){
        int i=left,j=right;
        int middle=(left+right)/2;

        if(numArray.get(middle)==n) return middle;
        else if(i<j){
            if (n>numArray.get(middle)) return search(numArray,middle+1,j,n);
            else if (n<numArray.get(middle)) return search(numArray,i,middle-1,n);
        }
        return -1;
    }
}
