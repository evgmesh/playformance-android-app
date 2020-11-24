package fi.team7.playformance;

public class Person {
    private final String firstName;
    private final String lastName;

    /**
     * Creates a person with known name and number in a team
     * @param firstName
     * @param lastName

     */

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    //Called automatically when listView shows info of players
    public String toString() {
        return firstName + " " + lastName;
    }

}

