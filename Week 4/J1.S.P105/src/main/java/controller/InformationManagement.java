package controller;

import model.Person;
import model.Student;
import model.Teacher;
import utility.CheckValidate;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class InformationManagement {
    Scanner sc = new Scanner(System.in);
    CheckValidate check = new CheckValidate();

    public void inputTeacherData(Teacher t) {
        inputPersonData(t);
        while (true) {
            try {
                System.out.print("Years in profession: ");
                t.setYearsInProfession(Integer.parseInt(sc.next()));
                if (t.getYearsInProfession() >= 0 && t.getYearsInProfession() < (Calendar.getInstance().get(Calendar.YEAR) - t.getYearOfBirth()))
                    break;
                System.err.println("Data input is invalid");
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format, please try again");
            }
        }

        sc.nextLine(); // Clear buffer
        while (true) {
            System.out.print("Contract type (Long/Short): ");
            t.setContractType(sc.next());
            if (check.checkContractType(t.getContractType()))
                break;
            System.err.println("Data input is invalid");
        }

        while (true) {
            try {
                System.out.print("Salary coefficient: ");
                t.setSalaryCoefficient(Double.parseDouble(sc.next()));
                if (t.getSalaryCoefficient() >= 0)
                    break;
                System.err.println("Data input is invalid");
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format, please try again");
            }
        }
    }

    public void inputStudentData(Student s) {
        inputPersonData(s);
        while (true) {
            try {
                System.out.print("Year of admission: ");
                s.setYearOfAdmission(Integer.parseInt(sc.next()));
                if (s.getYearOfAdmission() >= s.getYearOfBirth() && s.getYearOfAdmission() <= Calendar.getInstance().get(Calendar.YEAR))
                    break;
                System.err.println("Data input is invalid");
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format, please try again");
            }
        }

        while (true) {
            try {
                System.out.print("Entrance English score (0-100): ");
                s.setEnglishScore(Double.parseDouble(sc.next()));
                if (s.getEnglishScore() >= 0 && s.getEnglishScore() <= 100)
                    break;
                System.err.println("Data input is invalid");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format, please try again");
            }
        }
    }

    private void inputPersonData(Person p) {
        while (true) {
            System.out.print("ID (6 digits): ");
            p.setId(sc.next());
            if (check.checkID(p.getId()))
                break;
            System.out.println("Data input is invalid");
        }

        sc.nextLine(); // Clear buffer
        while (true) {
            System.out.print("Fullname: ");
            p.setFullName(sc.nextLine());
            if (p.getFullName().matches("[a-zA-Z ]+")) break;
            System.out.println("Data input is invalid");
        }

        while (true) {
            System.out.print("Phone number (12 digits): ");
            p.setPhoneNumber(sc.next());
            if (check.checkPhone(p.getPhoneNumber()))
                break;
            System.out.println("Data input is invalid");
        }

        while (true) {
            try {
                System.out.print("Year of birth: ");
                p.setYearOfBirth(Integer.parseInt(sc.next()));
                if (p.getYearOfBirth() < Calendar.getInstance().get(Calendar.YEAR))
                    break;
                System.out.println("Data input is invalid");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format, please try again");
            }
        }

        sc.nextLine(); // Clear buffer
        while (true) {
            System.out.print("Major (max 30 characters): ");
            p.setMajor(sc.nextLine());
            if (p.getMajor().length() <= 30)
                break;
            System.out.println("Data input is invalid");
        }
    }

    public Person findPerson(List<Teacher> teachers, List<Student> students, String name) {
        name = name.toLowerCase().trim();

        for (Teacher teacher : teachers) {
            if (teacher.getFullName().toLowerCase().contains(name)) {
                return teacher;
            }
        }

        for (Student student : students) {
            if (student.getFullName().toLowerCase().contains(name)) {
                return student;
            }
        }

        return null;
    }



    public void printTeachers(List<Teacher> teachers) {
        System.out.println("# - ID - Fullname - Phone number - Year of birth - Major - Years in Profession - Contract Type - Salary Coefficient");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + " - " + teachers.get(i));
        }
    }

    public void printStudents(List<Student> students) {
        System.out.println("# - ID - Fullname - Phone number - Year of birth - Major - Year of Admission - English Score");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + " - " + students.get(i));
        }
    }


    public void printAllPersons(List<Teacher> teachers, List<Student> students) {
        if (teachers.isEmpty() && students.isEmpty()) {
            System.out.println("No persons available.");
        } else {
            System.out.println("# - ID - Fullname - Phone number - Year of birth - Major");
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

}
