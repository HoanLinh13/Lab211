package Controller;

import Model.Student;
import Utility.CheckValidate;

import java.util.*;

public class ManageStudent {
    private ArrayList<Student> studentsList;
    CheckValidate validate = new CheckValidate();

    public ManageStudent() {
        this.studentsList = new ArrayList<Student>();
    }

    public ManageStudent(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public void addStudent(Student student) {
        this.studentsList.add(student);
    }

    // Tìm và sắp xếp sv theo tên
    public void findStudent(String name) {
        Collections.sort(this.studentsList, Comparator.comparing(Student::getName));

        boolean found = false;
        for (Student student : studentsList) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Found student named " + name + " in the list");
                System.out.println(student);
                found = true;
            }
        }

        System.out.println("Sorted student list :");
        for (Student student : studentsList) {
            System.out.println(student);
        }

        if (!found) {
            System.err.println("Student not found.");
        }
    }

    // Tìm sv theo ID
    private Student findST(int id) {
        for (Student sv : studentsList) {
            if (sv.getId() == id) {
                return sv;
            }
        }
        return null;
    }


    // Cập nhật hoặc xóa sv
    public void updateOrDeleteStudent() {
        Scanner scanner = new Scanner(System.in);
        int id;
        while (true) {
            try {
                System.out.print("Enter the student ID to find: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Invalid ID format! Please enter a valid integer.");
            }
        }

        Student st = findST(id);

        if (st == null) {
            System.err.println("Can't find student with ID: " + id);
            return;
        }

        System.out.println(st);
        System.out.print("Do you want to update (U) or delete (D)? ");
        String choice = scanner.nextLine().trim().toUpperCase();

        if (choice.equals("U")) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new semester: ");
            int newSemester = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new course: ");
            String newCourse = validate.checkCourseName();

            st.setName(newName);
            st.setSemester(newSemester);
            st.setCourseName(newCourse);

            System.out.println("Update successful!");
        } else if (choice.equals("D")) {
            studentsList.remove(st);
            System.out.println("Student successfully deleted!");
        } else {
            System.err.println("Invalid choice!");
        }
    }

    public void displayStudents() {
//        Map<String, Integer> studentCourseCount = new HashMap<>();
//
//        // Đếm số lượng khóa học
//        for (Student student : studentsList) {
//            studentCourseCount.put(student.getName(), studentCourseCount.getOrDefault(student.getName(), 0) + 1);
//        }
//
//        // Hiển thị kết quả
//        System.out.println("The report as below:");
//        for (Student student : studentsList) {
//            for (Map.Entry<String, Integer> entry : studentCourseCount.entrySet()) {
//                System.out.printf("%-12s | %-8s | %-5d\n", student.getName(), entry.getKey(), entry.getValue());
//            }
//        }

        System.out.println("The report as below:");
        // Duyệt qua từng sinh viên trong danh sách
        for (Student student : studentsList) {
            int count = 0;

            // Đếm số lần sinh viên đó đăng ký khóa học này
            for (Student s : studentsList) {
                if (s.getName().equals(student.getName()) && s.getCourseName().equals(student.getCourseName())) {
                    count++;
                }
            }

            // Chỉ hiển thị khi chưa in khóa học này của sinh viên
            boolean alreadyDisplayed = false;
            for (Student s : studentsList) {
                if (s == student) break; // Duyệt đến chính sinh viên này thì dừng
                if (s.getName().equals(student.getName()) && s.getCourseName().equals(student.getCourseName())) {
                    alreadyDisplayed = true;
                    break;
                }
            }

            if (!alreadyDisplayed) {
                System.out.printf("%-12s | %-8s | %-5d\n", student.getName(), student.getCourseName(), count);
            }
        }
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }
}

