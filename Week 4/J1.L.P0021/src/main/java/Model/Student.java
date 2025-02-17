package Model;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int semester;
    private String courseName;

    public Student(int id, String name, int semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + semester + "|" + courseName ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Student o) {
        int nameCompare = this.name.compareTo(o.name);
        if (nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(this.id, o.id); // Nếu trùng tên, so sánh theo ID
    }

}
