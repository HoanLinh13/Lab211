package model;

import java.time.LocalDate;

public class SalaryHistory {
    private Worker worker;
    private double adjustedSalary;
    private String status;
    private LocalDate date;

    public SalaryHistory(Worker worker, double adjustedSalary, String status, LocalDate date) {
        this.worker = worker;
        this.adjustedSalary = adjustedSalary;
        this.status = status;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public double getAdjustedSalary() {
        return adjustedSalary;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return  worker  + "\t\t" + adjustedSalary + "\t\t" + status + "\t\t" + date;

    }
}
