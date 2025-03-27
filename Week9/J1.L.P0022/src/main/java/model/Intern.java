package model;

public class Intern extends Candidate {
    private String major;
    private String semester;
    private String universityName;

    public Intern(String id, String firstName, String lastName, String major, String semester, String universityName) {
        super(id, firstName, lastName, null, null, null, null, 2);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {
        System.out.println("Intern Candidate: " + getFullName() + ", Major: " + major + ", Semester: " + semester);
    }
}
