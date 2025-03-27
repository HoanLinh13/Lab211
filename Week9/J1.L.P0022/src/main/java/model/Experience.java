package model;

public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience(String id, String firstName, String lastName, int expInYear, String proSkill) {
        super(id, firstName, lastName, null, null, null, null, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        System.out.println("Experience Candidate: " + getFullName() + ", Exp: " + expInYear + " years, Skill: " + proSkill);
    }
}
