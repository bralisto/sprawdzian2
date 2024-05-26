package pl.kurs.question1.model;

import java.time.LocalDate;
import java.util.List;
import java.io.Serializable;


public class Newborn {

    private String gender;

    private String firstName;

    private LocalDate birthDate;

    private int mass;

    private int height;

    private int motherID;

    private int newBornID;

    private Mother mother;


    public Newborn(String gender, String firstName, LocalDate birthDate, int mass, int height, int motherID, int newBornID) {
        this.gender = gender;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.mass = mass;
        this.height = height;
        this.motherID = motherID;
        this.newBornID = newBornID;

    }



    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }


    public int getMass() {
        return mass;
    }

    public int getHeight() {
        return height;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getMotherID() {
        return motherID;
    }

    public int getNewBornID() {
        return newBornID;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Newborn{" + "gender='" + gender + '\'' + ", firstName='" + firstName + '\'' + ", birthDate=" + birthDate + ", mass=" + mass + ", height=" + height + ", motherID=" + motherID + ", newBornID=" + newBornID + ", mother=" + mother + '}';
    }
}
