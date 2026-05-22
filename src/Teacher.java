public class Teacher extends Person {

     private String[] subjects;

    public Teacher(String name, String firstname, String email, String[] subjects) {
        super(name, firstname, email);//geerbt
        this.subjects = subjects;//zusätzlich
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}
