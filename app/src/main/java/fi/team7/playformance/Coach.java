package fi.team7.playformance;

public class Coach extends Person {
    private String email;
    private String phoneNumber;

    public Coach(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + this.email + this.phoneNumber;
    }
}
