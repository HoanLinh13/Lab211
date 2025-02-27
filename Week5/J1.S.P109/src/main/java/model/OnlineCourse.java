package model;

import java.util.Scanner;

public class OnlineCourse extends Course {
    private String platform;
    private String instructors;
    private String note;
    Scanner scanner = new Scanner(System.in);

    public OnlineCourse() {
        this.platform = "";
        this.instructors = "";
        this.note = "";

    }

    public void inputAll(String courseID, String courseName, String instructor, int credits, String platform, String instructors, String note){
        super.inputAll(courseID, courseName, credits);
        this.platform = platform;
        this.instructors = instructors;
        this.note = note;
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
