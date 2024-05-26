package pl.kurs.question3.app;

import pl.kurs.question3.model.Person;
import pl.kurs.question3.model.Student;
import pl.kurs.question3.model.Worker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Person[] people = new Person[15];
        people[0] = new Student("Jan", "Kowalski", 95010112315L, "Warszawa", "Informatyka", 1000);
        people[1] = new Student("Anna", "Nowak", 92020212345L, "Kraków", "Matematyka", 1200);
        people[2] = new Worker("Piotr", "Wiśniewski", 85030312375L, "Łódź", "Inżynier", 4000);
        people[3] = new Worker("Katarzyna", "Wójcik", 76040412345L, "Wrocław", "Manager", 6000);
        people[4] = new Student("Michał", "Kowalczyk", 97050512315L, "Poznań", "Fizyka", 900);
        people[5] = new Worker("Maria", "Kamińska", 74060612345L, "Gdańsk", "Nauczyciel", 3500);
        people[6] = new Student("Agnieszka", "Lewandowska", 99070712345L, "Szczecin", "Chemia", 1100);
        people[7] = new Worker("Tomasz", "Zieliński", 81080812375L, "Bydgoszcz", "Lekarz", 5000);
        people[8] = new Student("Monika", "Szymańska", 95090912345L, "Lublin", "Biologia", 1300);
        people[9] = new Worker("Barbara", "Woźniak", 73030312345L, "Katowice", "Prawnik", 4500);
        people[10] = new Student("Derek", "Kaczmarek", 96010112395L, "Białystok", "Informatyka", 1500);
        people[11] = new Worker("Wojciech", "Piotrowski", 82020212355L, "Rzeszów", "Architekt", 4700);
        people[12] = new Student("Ewa", "Kozłowska", 91030312345L, "Zielona Góra", "Ekonomia", 800);
        people[13] = new Worker("Joanna", "Jankowska", 77040412345L, "Opole", "Księgowa", 4200);
        people[14] = new Worker("Marek", "Mazur", 85050512335L, "Kielce", "Mechanik", 3800);

        System.out.println("Liczebność kobiet : " + countWomenInArray(people));
        System.out.println("Najlepiej zarabiająca osoba to : " + findHighestEarningPerson(people));
        savePeopleArrayToTxtFile(people, "src/main/java/pl/kurs/question3/people.txt");
    }

    private static int countWomenInArray(Person[] people) {
        int womenCounter = 0;
        for (Person person : people) {
            if (person.getGender() == "w") {
                womenCounter++;
            }
        }
        return womenCounter;
    }

    private static Person findHighestEarningPerson(Person[] people) {
        double highestIncome = 0;
        Person highestEarningPerson = null;
        for (Person person : people) {
            if (person instanceof Student) {
                if (((Student) person).getScholarship() > highestIncome) {
                    highestIncome = ((Student) person).getScholarship();
                    highestEarningPerson = person;
                }
            }
            if (person instanceof Worker) {
                if (((Worker) person).getSalary() > highestIncome) {
                    highestIncome = ((Worker) person).getSalary();
                    highestEarningPerson = person;
                }
            }
        }
        return highestEarningPerson;
    }


    private static void savePeopleArrayToTxtFile(Person[] people, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder sb = new StringBuilder();
            for (Person person : people) {
                sb.append(person.getClass().getSimpleName()).append("\t");
                sb.append(person.getFirstName()).append("\t");
                sb.append(person.getLastName()).append("\t");
                sb.append(person.getPesel()).append("\t");
                sb.append(person.getCity()).append("\t");
                if (person instanceof Student) {
                    Student student = (Student) person;
                    sb.append(student.getGroup()).append("\t");
                    sb.append(student.getScholarship()).append("\n");
                } else if (person instanceof Worker) {
                    Worker worker = (Worker) person;
                    sb.append(worker.getOccupation()).append("\t");
                    sb.append(worker.getSalary()).append("\n");
                }
            }
            writer.write(sb.toString());

        } catch (IOException e) {
            e.getMessage();
        }
    }


}
