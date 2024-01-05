package J1.S.P0001;

import java.util.ArrayList;
import java.util.Scanner;


public class BubbleSort {
    protected ArrayList<Integer> data;

    public BubbleSort(ArrayList<Integer> data) {
        this.data = data;
    }

    public void showArray(){
        for(int i=0; i<data.size(); i++){
            System.out.print(data.get(i)+ " ");
        }
    }

    public void BubbleSort1(){
        for(int i = 0; i<data.size(); i++){
            boolean sort = true;
            for (int j = 0; j < data.size()-1-i; j++) {
                if(data.get(j)>data.get(j+1)){
                    int temp = data.get(j);
                    data.set(j, data.get(j+1));
                    data.set(j+1, temp);
                    sort=false;
                }

            }
            if(sort)
                return;

        }
    }
}
