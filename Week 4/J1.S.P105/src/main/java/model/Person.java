package model;

public class Person {
    protected String id, fullName, phoneNumber, major;
    protected int yearOfBirth;

    public Person() {
        this.id = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.major = "";
        this.yearOfBirth = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return id + " - " + fullName + " - " + phoneNumber + " - " + yearOfBirth + " - " + major;
    }

}




