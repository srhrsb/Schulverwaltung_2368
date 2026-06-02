import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private ArrayList<Person> personList;
    private final Scanner SCANNER = new Scanner(System.in);

    public Controller(){
        personList = new ArrayList<Person>();
         scanInput();


    }

    private void scanInput(){

        System.out.println("Es sind "+ personList.size() + " Personen gespeichert." );
        System.out.println("Bitte Aktion eingeben: " +
                "(Schüler hinzufügen = S, Lehrer hinzufügen = L, Person suchen = F, Programm beenden = E)");

        String action  = SCANNER.nextLine();
        System.out.println("Aktion war: " + action);

        switch(action){
            case "S": handleStudentData();
                      break;
            case "L": handleTeacherData();
                      break;
            case "F": handleSearchTerm();
                      break;

            case "E": return;

            default:
                System.out.println("ungültiger Befehl");
        }

        scanInput();
    }

    private void handleStudentData(){
        System.out.println("Name des Schülers: ");
        String name = SCANNER.nextLine();

        System.out.println("Vorname des Schülers: ");
        String firstName = SCANNER.nextLine();

        System.out.println("Email-Adresse des Schülers: ");
        String email = SCANNER.nextLine();

        System.out.println("Klassenraum des Schülers: ");
        String classRoom = SCANNER.nextLine();

        addStudent(name, firstName, email, classRoom);
    }

    private void handleTeacherData(){
        System.out.println("Name des Lehrers: ");
        String name = SCANNER.nextLine();

        System.out.println("Vorname des Lehrers: ");
        String firstName = SCANNER.nextLine();

        System.out.println("Email-Adresse des Lehrers: ");
        String email = SCANNER.nextLine();

        System.out.println("Fächer des Lehrers mit Komma getrennt: ");
        String[] subjects = SCANNER.nextLine().trim().split(",");

        addTeacher(name, firstName, email, subjects);
    }

    private void handleSearchTerm(){



    }



    private void addStudent(String name, String firstname, String email, String classRoom){
       Person student = new Student(name, firstname, email, classRoom);
       personList.add(student);
    }

    private void addTeacher(String name, String firstname, String email, String[] subjects){
        Person teacher = new Teacher(name, firstname, email, subjects);
        personList.add(teacher);
    }

    private Person searchPerson( String searchTerm ){

        //ToDo: Person suchen
        return null;
    }
}
