package pl.kurs.question3.model;

public class Student extends Person{

    public Student(String firstName, String lastName, long pesel, String city, String group, int scholarship) {
        super(firstName, lastName, pesel, city);
        this.group = group;
        this.scholarship = scholarship;
    }

    private String group;
    private double scholarship;

    public String getGroup() {
        return group;
    }

    public double getScholarship() {
        return scholarship;
    }

    @Override
    public String toString() {
        return super.toString() +
                "group='" + group + '\'' +
                ", scholarship=" + scholarship +
                '}';
    }
}
