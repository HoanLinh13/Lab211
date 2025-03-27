package model;

import java.util.Date;

public class Fresher extends Candidate {
    private Date graduationDate;
    private String graduationRank;
    private String universityName;

    public Fresher(String id, String firstName, String lastName, Date graduationDate, String graduationRank, String universityName) {
        super(id, firstName, lastName, null, null, null, null, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {
        System.out.println("Fresher Candidate: " + getFullName() + ", Graduated: " + graduationDate + ", Rank: " + graduationRank);
    }
}
