public class Student extends Person {

    private String classRoom;

    public Student(String name, String firstname, String email, String classRoom) {
        super(name, firstname, email);
        this.classRoom = classRoom;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
