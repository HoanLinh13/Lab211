package View;

import Controller.ManageStudent;
import Model.Student;
import Utility.CheckValidate;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    CheckValidate validate = new CheckValidate();

    private int menu() {
        System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create\n" +
                            "2. Find and Sort\n" +
                            "3. Update/Delete\n" +
                            "4. Report\n" +
                            "5. Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program)");
        System.out.println("Enter your choice: ");
        int option = validate.checkMenu();
        return option;
    }

    public void start(){
        ManageStudent ms = new ManageStudent();
        while (true){
            switch (menu()){
                case 1:
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Semester: ");
                    int semester = scanner.nextInt();
                    System.out.println("Enter course name (There are only three courses: Java, .Net, C/C++): ");
                    String courseName = validate.checkCourseName();

                    Student student = new Student(id, name, semester, courseName);
                    ms.addStudent(student);

                    break;
                case 2:
                    System.out.println("Enter name want to find: ");
                    String nameFind = scanner.next();
                    ms.findStudent(nameFind);

                    break;
                case 3:
                    ms.updateOrDeleteStudent();

                    break;
                case 4:
                    ms.displayStudents();

                    break;
                case 5:
                    return;
            }
        }
    }
}
