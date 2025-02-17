package view;

import controller.CourseManagement;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private int menu(){
        int option = 0;
        System.out.println("*** Course Management ***");
        System.out.println("1. Add online course/ offline course\n" +
                "2. Update course\n" +
                "3. Delete course\n" +
                "4. Print all / online course / offline course\n" +
                "5. Search information base on course name\n" +
                "6. Exit\n");
        System.out.print("Your choice: ");
        option = scanner.nextInt();
        return option;
    }

    public void start(){
        CourseManagement cm = new CourseManagement();
        while (true){
            switch (menu()){
                case 1:
                    cm.addCourse();

                    break;
                case 2:
                    cm.updateCourse();

                    break;
                case 3:
                    cm.deleteCourse();

                    break;
                case 4:
                    cm.printCourses();

                    break;
                case 5:
                    cm.searchCourse();

                    break;
                case 6:
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;
            }
        }
    }
}
