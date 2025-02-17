package view;

import controller.InformationManagement;
import model.Person;
import model.Student;
import model.Teacher;
import utility.CheckValidate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    CheckValidate check = new CheckValidate();

    private int menu(){
        System.out.println("*** Information Management ***");
        System.out.println("1. Teacher\n" +
                "2. Student\n" +
                "3. Person\n" +
                "4. Exit\n");
        System.out.print("Enter your choose: ");
        int choice = check.checkMenu();
        return choice;
    }

    public void start() {
        int option;
        boolean flag;
        InformationManagement im = new InformationManagement();
        while (true) {
            switch (menu()) {
                case 1:
                    flag = false;
                    while (!flag) {
                        option = 0;
                        System.out.println("*** Teacher Management ***");
                        System.out.println("1. Input\n"
                                + "2. Print\n"
                                + "3. Exit\n");
                        System.out.println("Enter your choice: ");
                        option = sc.nextInt();
                        switch (option) {
                            case 1:
                                Teacher t = new Teacher();
                                im.inputTeacherData(t);
                                teachers.add(t);
                                teachers.sort(Comparator.comparingInt(a -> -a.getYearsInProfession()));

                                break;
                            case 2:
                                im.printTeachers(teachers);

                                break;
                            case 3:
                                flag = true;

                                break;
                            default:
                                System.err.println("Invalid choice. Please try again.");
                        }
                    }

                    break;
                case 2:
                    flag = false;
                    while (!flag) {
                        option = 0;
                        System.out.println("*** Student Management ***");
                        System.out.println("1. Input\n"
                                + "2. Print\n"
                                + "3. Exit\n");
                        System.out.println("Enter your choice: ");
                        option = sc.nextInt();
                        switch (option){
                            case 1:
                                Student s = new Student();
                                im.inputStudentData(s);
                                students.add(s);
                                students.sort(Comparator.comparingInt(a -> a.getYearOfAdmission()));

                                break;
                            case 2:
                                im.printStudents(students);

                                break;
                            case 3:
                                flag = true;

                                break;
                            default:
                                System.err.println("Invalid choice. Please try again.");
                        }
                    }

                    break;
                case 3:
                    flag = false;
                    while (!flag) {
                        option = 0;
                        System.out.println("*** Person Management ***");
                        System.out.println("1. Search\n"
                                + "2. Print all\n"
                                + "3. Exit\n");
                        System.out.println("Enter your choice: ");
                        option = sc.nextInt();
                        sc.nextLine();
                        switch (option){
                            case 1:
                                System.out.print("Enter name to search: ");
                                sc.nextLine();
                                String name = sc.nextLine();

                                Person foundPerson = im.findPerson(teachers, students, name);

                                System.out.println("Result:");
                                System.out.println("# - ID - Fullname - Phone number - Year of birth - Major");

                                if (foundPerson != null) {
                                    System.out.println(foundPerson);
                                } else {
                                    System.out.println("No results found.");
                                }

                                break;
                            case 2:
                                im.printAllPersons(teachers, students);

                                break;
                            case 3:
                                flag = true;

                                break;
                            default:
                                System.err.println("Invalid choice. Please try again.");
                        }
                    }

                    break;
                case 4:
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;
            }
        }
    }
}
