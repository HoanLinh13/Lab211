package controller;

import model.SalaryHistory;
import model.Worker;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkerManagement {
    private List<Worker> workerList = new ArrayList<>();
    private List<SalaryHistory> salaryHistories = new ArrayList<>();

    public void addWorker(Worker worker)  {
        workerList.add(worker);
    }

    public void changeSalary(String code, double amount, String status) {
        for (Worker worker : workerList) {
            if (worker.getCode().equalsIgnoreCase(code)) {
                worker.setSalary(amount);
                salaryHistories.add( new SalaryHistory(worker, amount, status, LocalDate.now()) );

                return;
            }
        }
    }

    public void displaySalaryHistory(){
        if (salaryHistories.isEmpty()) {
            System.err.println("No salary adjustment history available.");
            return;
        }

        System.out.println("--------------- Display Information Salary ---------------");
        System.out.printf("%-10s %-15s %-5s %-10s %-10s %-15s%n",
                "Code", "Name", "Age", "Salary", "Status", "Date");
        System.out.println("----------------------------------------------------------");

        for (SalaryHistory history : salaryHistories) {
            System.out.println(history);
        }

    }


    public List<Worker> getWorkerList() {  // lấy danh sách công nhân
        return workerList;
    }

}
