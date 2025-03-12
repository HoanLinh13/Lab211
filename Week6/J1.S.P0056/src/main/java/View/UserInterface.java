package View;

import controller.WorkerManagement;
import model.Worker;
import utility.CheckValidate;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    CheckValidate validate = new CheckValidate();
    WorkerManagement wm = new WorkerManagement();

    private int menu(){
            int choice = 0;
            System.out.println("======== Worker Management ========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display Information salary");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            validate.checkMenu(choice);
            return choice;
    }

    public void start(){
        String status ;

        while(true){
            switch(menu()){
                case 1:
                    String code ;
                    do {
                        System.out.print("Enter Code: ");
                        code = scanner.nextLine();
                    } while( !validate.checkCode(code, wm.getWorkerList()) );

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    int age = 0;
                    do {
                        System.out.print("Enter Age: ");
                        age = scanner.nextInt();

                    } while( !validate.checkAge(age) );

                    double salary;
                    do {
                        System.out.print("Enter Salary: ");
                        salary = scanner.nextDouble();
                        scanner.nextLine();
                    } while( !validate.checkSalary(salary) );

                    System.out.print("Enter Work Location: ");
                    String workLocation = scanner.nextLine();

                    Worker worker = new Worker(code, name, age, salary, workLocation);
                    wm.addWorker(worker);
                    System.out.println("Worker added successfully!");

                    break;
                case 2:
                    status = "UP";
                    inputSalaryChange(status);

                    break;
                case 3:
                    status = "DOWN";
                    inputSalaryChange(status);

                    break;
                case 4:
                    wm.displaySalaryHistory();

                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void inputSalaryChange(String status){
        String codeSL;
        do {
            System.out.print("Enter Code: ");
            codeSL = scanner.nextLine();
        } while( !validate.isCodeExist(codeSL, wm.getWorkerList()) );

        double slChange;
        do {
            System.out.print("Enter Salary: ");
            slChange = scanner.nextDouble();
            scanner.nextLine();
        } while( !validate.checkSalary(slChange) );

        wm.changeSalary(codeSL, slChange, status);
        System.out.println("Salary changed successfully!");
    }
}
