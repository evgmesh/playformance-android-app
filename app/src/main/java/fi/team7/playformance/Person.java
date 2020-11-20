package fi.team7.playformance;

public class Person {
    private final String firstName;
    private final String lastName;
    private int number;

    /**
     * Creates a person with known name and number in a team
     * @param firstName
     * @param lastName
     * @param number
     */

    public Person(String firstName, String lastName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    @Override
    //Called automatically when listView shows info of players
    public String toString() {
        return "Player " + firstName + " " + lastName + ", number " + number;
    }

}

