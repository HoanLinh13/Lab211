package model;

import java.util.Scanner;
import java.util.Set;

public class Course {
    protected String courseID;
    protected String courseName;
    protected int credits;

    public Course() {}
    public Course(String courseID, String courseName, int credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }

    public void inputAll(Scanner scanner, Set<String> existingIDs) {
        while (true) {
            System.out.print("Course ID: ");
            courseID = scanner.nextLine();
            if (!courseID.isEmpty() && !existingIDs.contains(courseID)) {
                existingIDs.add(courseID);
                break;
            }
            System.err.println("Data input is invalid, ID must be unique");
        }

        while (true) {
            System.out.print("Course Name: ");
            courseName = scanner.nextLine();
            if (!courseName.isEmpty())
                break;
            System.err.println("Data input is invalid");
        }

        while (true) {
            System.out.print("Credits: ");
            try {
                credits = Integer.parseInt(scanner.nextLine());
                if (credits > 0)
                    break;
            } catch (NumberFormatException e) {}
            System.err.println("Data input is invalid");
        }
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return courseID + " - " +
                courseName + " - " +
                credits + " - ";
    }
}
