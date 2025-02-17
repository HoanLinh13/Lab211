package model;

import java.util.Scanner;
import java.util.Set;

public class OfflineCourse extends Course {
    private String begin;
    private String end;
    private String campus;

    public OfflineCourse() {}
    public OfflineCourse(String courseName, String instructor, int credits, String begin, String end, String campus) {
        super(courseName, instructor, credits);
        this.begin = begin;
        this.end = end;
        this.campus = campus;
    }

    public void inputAll(Scanner scanner, Set<String> existingIDs) {
        super.inputAll(scanner, existingIDs);

        while (true) {
            System.out.print("Begin date (dd/mm/yyyy): ");
            begin = scanner.nextLine();

            System.out.print("End date (dd/mm/yyyy): ");
            end = scanner.nextLine();

            if (!begin.isEmpty() && !end.isEmpty() && begin.compareTo(end) < 0)
                break;
            System.err.println("Data input is invalid, end must be after begin");
        }

        while (true) {
            System.out.print("Campus: ");
            campus = scanner.nextLine();
            if (!campus.isEmpty()) break;
            System.err.println("Data input is invalid");
        }
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return super.toString() + begin + " - " +
                end + " - " +
                campus ;
    }
}
