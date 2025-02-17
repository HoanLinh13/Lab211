package model;

import java.util.Scanner;
import java.util.Set;

public class OnlineCourse extends Course {
    private String platform;
    private String instructors;
    private String note;
    Scanner scanner = new Scanner(System.in);

    public OnlineCourse() {}
    public OnlineCourse(String courseName, String instructor, int credits, String platform, String instructors, String note) {
        super(courseName, instructor, credits);
        this.platform = platform;
        this.instructors = instructors;
        this.note = note;
    }

    public void inputAll(Scanner scanner, Set<String> existingIDs) {
        super.inputAll(scanner, existingIDs);

        while (true) {
            System.out.print("Platform: ");
            platform = scanner.nextLine();
            if (!platform.isEmpty())
                break;
            System.err.println("Data input is invalid");
        }

        System.out.print("Instructors: ");
        instructors = scanner.nextLine();

        System.out.print("Note: ");
        note = scanner.nextLine();
    }


    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return super.toString() + platform + " - " +
                instructors + " - " +
                note ;
    }
}
