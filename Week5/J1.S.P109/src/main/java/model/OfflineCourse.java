package model;

public class OfflineCourse extends Course {
    private String begin;
    private String end;
    private String campus;

    public OfflineCourse() {
        this.begin = "";
        this.end = "";
        this.campus = "";
    }
    public void inputAll(String courseID, String courseName, int credits, String begin, String end, String campus) {
        super.inputAll(courseID, courseName, credits);
        this.begin = begin;
        this.end = end;
        this.campus = campus;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return super.toString() + begin + " - " +
                end + " - " +
                campus ;
    }
}
