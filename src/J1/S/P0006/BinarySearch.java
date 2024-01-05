package J1.S.P0006;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {
    public void input(ArrayList<Integer> numArray) {
        Scanner scaner = new Scanner(System.in);
        System.out.print ("Enter the number of array : ");
        int n = scaner.nextInt();
        int num;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter array " + i + ": ");
            System.out.println();
            num = scaner.nextInt();
            numArray.add(num);
        }
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
