package pl.kurs.question1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Serializable;

public class Mother {

    private String firstName;

    private int Id;

    private int age;

    private List<Newborn> newborns;

    public Mother(String firstName, int motherId, int age) {
        this.firstName = firstName;
        this.Id = motherId;
        this.age = age;
        this.newborns = new ArrayList<>();
    }

    public void addNewborn(Newborn newborn){
        this.newborns.add(newborn);
    }


    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return Id;
    }

    public int getAge() {
        return age;
    }

    public List<Newborn> getNewborns() {
        return newborns;
    }

    @Override
    public String toString() {
        return "Mother{" + "firstName='" + firstName + '\'' + ", motherId=" + Id + ", age=" + age + ", newborn.size=" + newborns.size() + '}';
    }

}
