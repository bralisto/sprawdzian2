package pl.kurs.question2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Doctor {

    private int Id;
    private String lastName;
    private String firstName;
    private String specialisation;
    private LocalDate birthDate;
    private long nip;
    private long pesel;
    private List<Visit> visitList;

    public List<Visit> getVisitList() {
        return visitList;
    }

    public Doctor(int id, String lastName, String firstName, String specialisation, LocalDate birthDate, long nip, long pesel) {
        this.Id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.specialisation = specialisation;
        this.birthDate = birthDate;
        this.nip = nip;
        this.pesel = pesel;
        this.visitList = new ArrayList<>();
    }

    public void addVisit(Visit visit) {
        this.visitList.add(visit);
    }

    public int getId() {
        return Id;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public long getNip() {
        return nip;
    }

    public long getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Id=" + Id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", specialisation='" + specialisation + '\'' +
                ", birthDate=" + birthDate +
                ", nip=" + nip +
                ", pesel=" + pesel +
                ", number of visists=" + visitList.size() +
                '}';
    }
}
