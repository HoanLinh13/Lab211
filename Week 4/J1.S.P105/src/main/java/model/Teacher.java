package model;

public class Teacher extends Person {
    protected int yearsInProfession;
    protected String contractType;
    protected double salaryCoefficient;

    public Teacher() {
        super();
        this.yearsInProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0.0;
    }

    public int getYearsInProfession() {
        return yearsInProfession;
    }

    public void setYearsInProfession(int yearsInProfession) {
        this.yearsInProfession = yearsInProfession;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + yearsInProfession + " - " + contractType + " - " + salaryCoefficient;
    }

}