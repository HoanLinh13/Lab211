package controller;

import model.Course;
import model.OfflineCourse;
import model.OnlineCourse;

import java.util.*;

public class CourseManagement {
    private  List<Course> courseList = new ArrayList<>();
    private  Set<String> existingIDs = new HashSet<>();
    Scanner scanner = new Scanner(System.in);


    public void addCourse() {
        System.out.println("*** Add new course ***");
        while (true) {
            System.out.print("Online (O) or Offline (F): ");
            String type = scanner.nextLine().toUpperCase();

            if (type.equals("O")) {
                System.out.println("Create new online course");
                OnlineCourse course = new OnlineCourse();
                course.inputAll(scanner, existingIDs);
                courseList.add(course);
                existingIDs.add(course.getCourseID());
                break;
            } else if (type.equals("F")) {
                System.out.println("Create new offline course");
                OfflineCourse course = new OfflineCourse();
                course.inputAll(scanner, existingIDs);
                courseList.add(course);
                existingIDs.add(course.getCourseID());
                break;
            } else {
                System.err.println("Data input is invalid");
            }
        }
    }


    public void printCourses() {
        System.out.println("*** Print course ***");
        System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
        String type = scanner.nextLine().toUpperCase();

        if (courseList.isEmpty()) {
            System.err.println("No courses available.");
            return;
        }

        if (type.equals("A")) {
            for (Course course : courseList) {
                if (course instanceof OnlineCourse) {
                    System.out.println("Course ID-Course Name-Credits-Platform-Instructors-Note");
                    System.out.println(course);
                }
            }
            for (Course course : courseList) {
                if (course instanceof OfflineCourse) {
                    System.out.println("Course ID-Course Name-Credits-Begin-End-Campus");
                    System.out.println(course);
                }
            }
        } else if (type.equals("O")) {
            System.out.println("Course ID-Course Name-Credits-Platform-Instructors-Note");
            for (Course course : courseList) {
                if (course instanceof OnlineCourse) {
                    System.out.println(course);
                }
            }
        } else if (type.equals("F")) {
            System.out.println("Course ID-Course Name-Credits-Begin-End-Campus");
            for (Course course : courseList) {
                if (course instanceof OfflineCourse) {
                    System.out.println(course);
                }
            }
        } else {
            System.err.println("Invalid input");
        }
    }

    public Course getCourseByID(String courseID) {
        for (Course course : courseList) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    public void updateCourse() {
        System.out.println("*** Update course ***");
        System.out.print("Course ID: ");
        String courseID = scanner.nextLine();
        Course course = getCourseByID(courseID);

        if (course == null) {
            System.out.print("No data found, do you want to find again? (Y/N): ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                updateCourse();
            }
            return;
        }

        System.out.println("*** Updating ***");
        System.out.println("Note: Enter empty if you don't want to change it.");

        if (course instanceof OnlineCourse) {
            ((OnlineCourse) course).inputAll(scanner, existingIDs);
        } else if (course instanceof OfflineCourse) {
            ((OfflineCourse) course).inputAll(scanner, existingIDs);
        }

        System.out.println("Updated successfully");
    }

    public void deleteCourse() {
        System.out.println("*** Delete course ***");
        System.out.print("Course ID: ");
        String courseID = scanner.nextLine();
        Course course = getCourseByID(courseID);

        if (course == null) {
            System.out.print("No data found, do you want to find again? (Y/N): ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                deleteCourse();
            }
            return;
        }

        courseList.remove(course);
        existingIDs.remove(course.getCourseID());
        System.out.println("Course deleted successfully");
    }

    public void searchCourse() {
        System.out.println("*** Searching ***");
        System.out.print("Course ID: ");
        String courseID = scanner.nextLine();
        Course course = getCourseByID(courseID);

        if (course == null) {
            System.out.print("No data found, do you want to find again? (Y/N): ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                searchCourse();
            }
            return;
        }

        System.out.println("*** Search results ***");

        if (course instanceof OnlineCourse) {
            System.out.println(course);
        } else if (course instanceof OfflineCourse) {
            System.out.println(course);
        } else {
            System.out.println(course);
        }
    }
}
