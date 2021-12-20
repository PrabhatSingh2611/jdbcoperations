package Records;

public class Student {

    private int studentId;
    private String studentName;
    private String studentSurname;
    private int age;
    private boolean gender;
    private String groupId;

    public Student(int studentId, String studentName, String studentSurname, int age, boolean gender, String groupId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.age = age;
        this.gender = gender;
        this.groupId = groupId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
