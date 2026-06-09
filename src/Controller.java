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
        System.out.println("Suchbegriff eingeben: ");
        String searchTerm = SCANNER.nextLine();
        Person person = searchPerson(searchTerm);

        if(person == null){
            System.out.println("Person ungültig bzw. nicht gefunden");
            return;
        }

        viewPerson(person);
        requestDeletePerson(person);

    }

    private void requestDeletePerson( Person person ){
        System.out.println("Person löschen = D: ");
        String action = SCANNER.nextLine();

        if(action.equals("D")){
            personList.remove(person);
        }
    }

    private void viewPerson( Person person) {

       // System.out.println(person instanceof Student);

        System.out.println( "Name: " + person.getName() );
        System.out.println( "Vorname: " + person.getFirstname() );
        System.out.println( "Email: " + person.getEmail() );

        if(person instanceof Student){
            Student student = (Student) person;
            System.out.println("Raum: "+ student.getClassRoom());
        }

        else if(person instanceof Teacher){
            Teacher teacher = (Teacher) person;

            for( String subject : teacher.getSubjects()){
                System.out.println("Fach: "+ subject );
            }
        }
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

        for(Person person : personList){

            if(person.getName().contains(searchTerm)){
                return person;
            }
            else if(person.getFirstname().contains(searchTerm)){
                return person;
            }
            else if(person.getEmail().contains(searchTerm)){
                return person;
            }
        }

        return null;
    }


    //Hausaufgabe:

    // Hinweis: das entfernen aus ArrayListen
    //erledigt die Methode remove( )

    //implementieren Sie nach einer gefundenen Person die Möglichkeit
    //diese zu löschen
}
