public class Person {

   private String name;
   private String firstname;
   private String email;

   public Person(String name, String firstname, String email ){
       this.name = name;
       this.firstname = firstname;
       this.email = email;
   }

   public String getName(){
       return this.name;
   }

    public void setName( String name){
       this.name = name;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
