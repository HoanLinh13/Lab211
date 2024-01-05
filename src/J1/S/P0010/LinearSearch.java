package J1.S.P0010;

import Model.EnterArray;
import java.util.ArrayList;


public class LinearSearch extends EnterArray {
    protected ArrayList<Integer> data;

    public LinearSearch(ArrayList<Integer> data) {
        this.data = data;
    }
    public int linearSearch(int target) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == target) {
                return i;
            }
        }
        return -1;
    }
}

