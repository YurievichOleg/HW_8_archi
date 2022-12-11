package Model;

public class User {
    String firstName;
    String lastName;
    int telephone;
    public User(String firstName, String lastName, int telephone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public String getName(){
        String name = firstName + lastName;
        return name;
    }
    public int getTelephone(){
        int telephone1 = telephone;
        return telephone1;
    }

}
