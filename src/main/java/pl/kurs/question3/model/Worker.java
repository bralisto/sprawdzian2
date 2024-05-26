package pl.kurs.question3.model;

public class Worker extends Person{
    private String occupation;
    private double salary;

    public Worker(String firstName, String lastName, long pesel, String city, String occupation, int salary) {
        super(firstName, lastName, pesel, city);
        this.occupation = occupation;
        this.salary = salary;
    }

    public String getOccupation() {
        return occupation;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "occupation='" + occupation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
