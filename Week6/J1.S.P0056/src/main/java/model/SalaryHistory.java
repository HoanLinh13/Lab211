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
        return String.format("%-10s %-15s %-5d %-10.2f %-10s %-15s",
                worker.getCode(), worker.getName(), worker.getAge(), adjustedSalary, status, date);

    }
}
