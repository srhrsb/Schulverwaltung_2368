import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private ArrayList<Person> personList;

    public Controller(){
        personList = new ArrayList<Person>();
         scanInput();
    }

    private void scanInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Aktion eingeben: " +
                "(Schüler hinzufügen = S, Lehrer hinzufügen = L, Person suchen = F)");

        String action  = scanner.nextLine();
        System.out.println("Aktion war: " + action);




    }

    private void addStudent(String name, String firstname, String email, String classRoom){
       Person student = new Student(name, firstname, email, classRoom);
       personList.add(student);
    }

    private void addTeacher(String name, String firstname, String email, String[] subjects){
        Person teacher = new Teacher(name, firstname, email, subjects);
        personList.add(teacher);
    }
}
