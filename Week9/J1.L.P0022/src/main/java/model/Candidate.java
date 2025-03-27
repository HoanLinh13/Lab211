package model;

import java.util.Date;

public abstract class Candidate {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected Date birthDate;
    protected String address;
    protected String phone;
    protected String email;
    protected int candidateType;

    public Candidate(String id, String firstName, String lastName, Date birthDate, String address, String phone, String email, int candidateType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public abstract void showInfo();

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getCandidateType() {
        return candidateType;
    }
}
