package J1.S.P0010;

import java.util.Scanner;

public class LinearSearch {
        private int n;
        private int[] array;

        public LinearSearch(int n) {
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
        public int linearSearch(int numSearch) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == numSearch) {
                    return i;
                }
            }
            return -1;
        }

    }

