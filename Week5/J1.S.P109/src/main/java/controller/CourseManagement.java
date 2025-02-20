package controller;

import model.Course;
import model.OfflineCourse;
import model.OnlineCourse;

import java.util.*;

public class CourseManagement {
    private Map<String, Course> courseMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    public void addCourse(Course course) {
        String courseID = course.getCourseID();

        if (!courseID.isEmpty() && !courseMap.containsKey(courseID)) {
            courseMap.put(courseID, course);
            System.out.println("Course added successfully.");
        } else {
            System.err.println("Course ID already exists or is empty.");
        }
    }

    public Course findCourseById(String courseID) {
        if (courseMap.containsKey(courseID)) {
            return courseMap.get(courseID);
        }
        return null;
    }

    public void updateCourse(Course updatedCourse) {
        String courseID = updatedCourse.getCourseID();

        courseMap.put(courseID, updatedCourse); // Ghi đè dữ liệu cũ
    }


    public void deleteCourse(String courseID) {
        courseMap.remove(courseID);
    }

    public void printCourses(String type) {
        if (courseMap.isEmpty()) {
            System.err.println("No courses available.");
            return;
        }

        if (type.equals("A")) {
            for (Course course : courseMap.values()) {
                if (course instanceof OnlineCourse) {
                    System.out.println("Course ID-Course Name-Credits-Platform-Instructors-Note");
                    System.out.println(course);
                }
            }
            for (Course course : courseMap.values()) {
                if (course instanceof OfflineCourse) {
                    System.out.println("Course ID-Course Name-Credits-Begin-End-Campus");
                    System.out.println(course);
                }
            }
        } else if (type.equals("O")) {
            System.out.println("Course ID-Course Name-Credits-Platform-Instructors-Note");
            for (Course course : courseMap.values()) {
                if (course instanceof OnlineCourse) {
                    System.out.println(course);
                }
            }
        } else if (type.equals("F")) {
            System.out.println("Course ID-Course Name-Credits-Begin-End-Campus");
            for (Course course : courseMap.values()) {
                if (course instanceof OfflineCourse) {
                    System.out.println(course);
                }
            }
        } else {
            System.err.println("Invalid input");
        }
    }

    public void searchCourse(String courseID) {
        Course course = courseMap.get(courseID);
        System.out.println(course);
    }
}
