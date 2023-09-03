package ir.digikala.session1.models;

public class Student extends Person {
    private String studentId;
    private Integer passedCourse;
    private String field;

    public static void main(String[] args) {
        Student student = new Student();

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getPassedCourse() {
        return passedCourse;
    }

    public void setPassedCourse(Integer passedCourse) {
        this.passedCourse = passedCourse;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
