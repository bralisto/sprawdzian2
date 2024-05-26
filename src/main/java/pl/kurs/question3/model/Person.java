package pl.kurs.question3.model;

public class Person {

    private final String firstName;
    private final String lastName;

    private final long pesel;
    private final String city;

    public Person(String firstName, String lastName, long pesel, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.city = city;
    }

    public String getGender() {
        long genderDigit = (pesel / 10) % 10;
        if (genderDigit % 2 == 0) {
            return "w";
        } else {
            return "m";
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPesel() {
        return pesel;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{ firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                ", city='" + city + '\'' +
                ", ";
    }
}
