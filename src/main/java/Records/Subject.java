package Records;

public class Subject {

    private String subjectId;
    private String subjectName;
    private int marks;
    private int studentId;

    public Subject(String subjectId, String subjectName, int marks, int studentId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.marks = marks;
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", marks=" + marks +
                ", studentId=" + studentId +
                '}';
    }
}
