package model;

public class Student extends Person {
    protected int yearOfAdmission;
    protected double englishScore;

    public Student() {
        super();
        this.yearOfAdmission = 0;
        this.englishScore = 0.0;
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + yearOfAdmission + " - " + englishScore;
    }

}