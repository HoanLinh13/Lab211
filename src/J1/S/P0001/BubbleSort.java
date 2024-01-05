package J1.S.P0001;

import java.util.Random;
import java.util.Scanner;


public class BubbleSort {
    private int n;
    private int[] array;

    public BubbleSort(int n){
        this.n=n;
        this.array = new int[n];
    }

    public void enterArray(){
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i < array.length; i++){
            System.out.print("Enter array " + i + ": ");
            System.out.println();
            array[i] = scanner.nextInt();
        }
    }
    public void showArray(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+ " ");
        }
    }

    public void BubbleSort1(){
//        int sll = 0;
        for(int i = 0; i<array.length;i++){
//            sll = sll+1;
            boolean sort = true;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1]= temp;
                    sort=false;
                }

            }
            if(sort)
                return;

        }
    }
}
