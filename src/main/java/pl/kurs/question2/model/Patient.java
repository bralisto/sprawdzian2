package pl.kurs.question2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int Id;
    private String lastName;
    private String firstName;
    private long pesel;
    private LocalDate birthDate;
    private List<Visit> visitList;

    public Patient(int id, String lastName, String firstName, long pesel, LocalDate birthDate) {
        this.Id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.pesel = pesel;
        this.birthDate = birthDate;
        this.visitList = new ArrayList<>();
    }

    public void addVisit(Visit visit) {
        this.visitList.add(visit);
    }

    public int getId() {
        return Id;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public long getPesel() {
        return pesel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Id=" + Id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pesel=" + pesel +
                ", birthDate=" + birthDate +
                ", number of visists=" + visitList.size() +
                '}';
    }


}
