package view;

import controller.CourseManagement;
import model.Course;
import model.OfflineCourse;
import model.OnlineCourse;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    private int menu() {
        int option = 0;
        System.out.println("\n*** Course Management ***");
        System.out.println("1. Add online course/ offline course\n" +
                "2. Update course\n" +
                "3. Delete course\n" +
                "4. Print all / online course / offline course\n" +
                "5. Search information base on course name\n" +
                "6. Exit\n");
        System.out.print("Your choice: ");
        option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }

    public void start() {
        CourseManagement cm = new CourseManagement();

        while (true) {
            switch (menu()) {
                case 1:
                    System.out.println("*** Add new course ***");
                    while (true) {
                        System.out.print("Online (O) or Offline (F): ");
                        String type = scanner.nextLine().toUpperCase();

                        if (type.equals("O")) {
                            System.out.println("Create new online onCourse");
                            OnlineCourse onCourse = new OnlineCourse();

                            System.out.print("Course ID: ");
                            String courseID = scanner.nextLine();
                            System.out.print("Course Name: ");
                            String courseName = scanner.nextLine();
                            System.out.print("Credits: ");
                            int credits = Integer.parseInt(scanner.nextLine());
                            System.out.print("Platform: ");
                            String platform = scanner.nextLine();
                            System.out.print("Instructors: ");
                            String instructors = scanner.nextLine();
                            System.out.print("Note: ");
                            String note = scanner.nextLine();

                            onCourse.inputAll(courseID, courseName, instructors, credits, platform, instructors, note);
                            cm.addCourse(onCourse);

                            break;
                        } else if (type.equals("F")) {
                            System.out.println("Create new offline offCourse");
                            OfflineCourse offCourse = new OfflineCourse();
                            System.out.print("Course ID: ");
                            String courseID = scanner.nextLine();
                            System.out.print("Course Name: ");
                            String courseName = scanner.nextLine();
                            System.out.print("Credits: ");
                            int credits = Integer.parseInt(scanner.nextLine());
                            System.out.print("Begin date (dd/mm/yyyy): ");
                            String begin = scanner.nextLine();
                            System.out.print("End date (dd/mm/yyyy): ");
                            String end = scanner.nextLine();
                            System.out.print("Campus: ");
                            String campus = scanner.nextLine();

                            offCourse.inputAll(courseID, courseName, credits, begin, end, campus);
                            cm.addCourse(offCourse);

                            break;
                        } else {
                            System.err.println("Data input is invalid");
                        }
                    }

                    break;
                case 2:
                    while (true) {
                        System.out.println("*** Update course ***");
                        System.out.print("Course ID: ");
                        String idUpdate = scanner.nextLine();

                        Course existingCourse = cm.findCourseById(idUpdate); // kiểm tra khóa học có tồn tại không

                        if (existingCourse == null) {
                            System.out.print("No data found, do you want to find again? (Y/N): ");
                            String choice = scanner.nextLine().toUpperCase();
                            if (choice.equals("N")) {
                                break;
                            }
                            continue;
                        }

                        System.out.println("\n*** Search results ***");
                        System.out.print(existingCourse);
                        System.out.println("*** Updating ***");
                        System.out.println("Note: Enter empty if you don't want to change it.");

                        // Cập nhật thông tin khóa học
                        System.out.print("Course name: ");
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) {
                            existingCourse.setCourseName(newName);
                        }

                        System.out.print("Credits: ");
                        String creditsStr = scanner.nextLine();
                        if (!creditsStr.isEmpty()) {
                            try {
                                int newCredits = Integer.parseInt(creditsStr);
                                existingCourse.setCredits(newCredits);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number format. Credits not changed.");
                            }
                        }


                        if (existingCourse instanceof OnlineCourse) {
                            OnlineCourse onlineCourse = (OnlineCourse) existingCourse; // Ép kiểu existingCourse thành OnlineCourse

                            System.out.print("Platform: ");
                            String newPlatform = scanner.nextLine();
                            if (!newPlatform.isEmpty()) {
                                onlineCourse.setPlatform(newPlatform);
                            }

                            System.out.print("Instructors: ");
                            String newInstructors = scanner.nextLine();
                            if (!newInstructors.isEmpty()) {
                                onlineCourse.setInstructors(newInstructors);
                            }

                            System.out.print("Note: ");
                            String newNote = scanner.nextLine();
                            if (!newNote.isEmpty()) {
                                onlineCourse.setNote(newNote);
                            }
                            cm.updateCourse(onlineCourse);
                        } else if (existingCourse instanceof OfflineCourse) {
                            OfflineCourse offlineCourse = (OfflineCourse) existingCourse;

                            System.out.print("Begin date (dd/mm/yyyy): ");
                            String begin = scanner.nextLine();
                            if (!begin.isEmpty()) {
                                offlineCourse.setBegin(begin);
                            }
                            System.out.print("End date (dd/mm/yyyy): ");
                            String end = scanner.nextLine();
                            if (!end.isEmpty()) {
                                offlineCourse.setEnd(end);
                            }
                            System.out.print("Campus: ");
                            String campus = scanner.nextLine();
                            if (!campus.isEmpty()) {
                                offlineCourse.setCampus(campus);
                            }
                            cm.updateCourse(offlineCourse);
                        }

                        System.out.println("Updated successfully.");
                        break;
                    }

                    break;
                case 3:
                    while (true) {
                        System.out.println("*** Delete course ***");
                        System.out.print("Course ID: ");
                        String idDelete = scanner.nextLine();

                        Course existingCourse = cm.findCourseById(idDelete);
                        if (existingCourse == null) {
                            System.out.print("No data found, do you want to find again? (Y/N): ");
                            String choice = scanner.nextLine().toUpperCase();
                            if (choice.equals("N")) {
                                break;
                            }
                            continue;
                        }

                        cm.deleteCourse(idDelete);
                        System.out.print("Deleted successfully");
                        break;
                    }

                    break;
                case 4:
                    System.out.println("*** Print course ***");
                    System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
                    String type = scanner.nextLine().toUpperCase();

                    cm.printCourses(type);

                    break;
                case 5:
                    while (true) {
                        System.out.println("*** Searching ***");
                        System.out.print("Course ID: ");
                        String idSearch = scanner.nextLine();
                        Course existingCourse = cm.findCourseById(idSearch);

                        if (existingCourse == null) {
                            System.out.print("No data found, do you want to find again? (Y/N): ");
                            String choice = scanner.nextLine().toUpperCase();
                            if (choice.equals("N")) {
                                return;
                            }
                            continue;
                        }
                        cm.searchCourse(idSearch);

                        break;
                    }
                 break;
                case 6:
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;
            }
        }
    }
}
