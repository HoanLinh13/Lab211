import J1.S.P0001.BubbleSort;
import J1.S.P0004.QuickSort;
import J1.S.P0006.BinarySearch;
import J1.S.P0010.LinearSearch;
import Model.Menu;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String[] mc={"BubbleSort","QuickSort","LinearSearch","BinarySearch","Quit"};
        Menu m= new Menu("Lab211 - Week 1",mc){
            Scanner scanner = new Scanner(System.in);
            int n;

            public void execute(int choice){
                switch (choice){
                    case 1:
                        System.out.print("Enter the number of array : ");
                        System.out.print("Enter the number of array : ");

                        n = scanner.nextInt();
                        BubbleSort bbs = new BubbleSort(n);

                        bbs.enterArray();
                        bbs.showArray();
                        bbs.BubbleSort1();
                        System.out.println();
                        System.out.print("Array after short : ");
                        bbs.showArray();
                        System.out.println();

                        break;
                    case 2:
                        System.out.print("Enter the number of array : ");
                        n = scanner.nextInt();
                        QuickSort qs = new QuickSort(n);

                        qs.enterArray();
                        System.out.print("before sort : ");
                        qs.showArray();
                        qs.sortArray();
                        System.out.println();
                        System.out.print("after sort : ");
                        qs.showArray();
                        System.out.println();

                        break;
                    case 3:
                        System.out.print("Enter the number of array : ");
                        n = scanner.nextInt();

                        LinearSearch ls = new LinearSearch(n);
                        ls.enterArray();
                        System.out.print("Enter search value : ");
                        System.out.println();
                        int numSearch = scanner.nextInt();

                        int result = ls.linearSearch(numSearch);
                        if (result != -1)
                            System.out.println("Element found at index: " + result);
                        else
                            System.out.println("Element not found in the array.");

                        break;
                    case 4:
                        BinarySearch searchList=new BinarySearch();
                        ArrayList<Integer> numArray = new ArrayList<Integer>();

                        searchList.input(numArray);
                        searchList.sort(numArray, 0, numArray.size() - 1);
                        searchList.output(numArray);
                        System.out.println("Enter search value : ");
                        n = scanner.nextInt();
                        int k=searchList.search(numArray, 0, numArray.size()-1, n);
                        if(k>=0)
                            System.out.println("Found " + n + " at index = " + k);
                        else
                            System.out.println("Not found");

                        break;
                    case 5:
                        System.exit(0);

                        break;
                    default:
                        System.out.println("Invalid choice. Please try again!");
                }
            }
        };
        m.run();
    }

}
