package utility;

import model.Worker;
import java.util.List;

public class CheckValidate {
   public boolean checkMenu(int choice) {
       if (choice > 0 && choice <= 5)
           return true;
       else {
           System.err.println("Error: Please enter a number between 1 and 5!");
           return false;
       }
   }

    public boolean checkCode(String code, List<Worker> workerList) {
        if (code == null || code.trim().isEmpty()) {
            System.err.println("Worker ID cannot be null or empty!");
            return false;
        }
        for (Worker w : workerList) {
            if (w.getCode().equalsIgnoreCase(code)) {
                System.err.println("Invalid or existing Code! Please enter again.");
                return false;
            }
        }
        return true;
    }

    public boolean checkAge(int age) {
        if (age < 18 || age > 50) {
            System.err.println("Invalid worker information: Age must be between 18-50.");
            return false;
        }
        return true;
    }

    public boolean checkSalary(double salary) {
        if (salary <= 0) {
            System.err.println("Invalid salary information: Salary must be greater than 0.");
            return false;
        }
        return true;
    }

    public boolean isCodeExist(String code, List<Worker> workerList) {
        for (Worker w : workerList) {
            if (w.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        System.err.println("Worker ID does not exist! Please enter again.");
        return false;
    }

}
