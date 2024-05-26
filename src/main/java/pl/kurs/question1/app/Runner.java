package pl.kurs.question1.app;

import pl.kurs.question1.model.Mother;
import pl.kurs.question1.model.Newborn;

import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

import static java.util.Arrays.sort;

public class Runner {

    public static void main(String[] args) throws FileNotFoundException {

        File file1 = new File("src/main/java/pl/kurs/question1/data/mamy.txt");
        File file2 = new File("src/main/java/pl/kurs/question1/data/noworodki.txt");

        List<Mother> mothers = new ArrayList<Mother>();
        List<Newborn> newborns = new ArrayList<Newborn>();

        try {
            Scanner motherList = new Scanner(file1);

            while (motherList.hasNextLine()) {
                String line = motherList.nextLine();
                String[] lineData = line.split(" ");
                String name = lineData[1];
                int ID = Integer.parseInt(lineData[0]);
                int age = Integer.parseInt(lineData[2]);
                mothers.add(new Mother(name, ID, age));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Scanner newbornList = new Scanner(file2);

            while (newbornList.hasNextLine()) {
                String line = newbornList.nextLine();
                String[] lineData = line.split(" ");
                int newbornId = Integer.parseInt(lineData[0]);
                String gender = lineData[1];
                String name = lineData[2];
                LocalDate birthDate = LocalDate.parse(lineData[3]);
                int mass = Integer.parseInt(lineData[4]);
                int height = Integer.parseInt(lineData[5]);
                int motherId = Integer.parseInt(lineData[6]);
                newborns.add(new Newborn(gender, name, birthDate, mass, height, motherId, newbornId));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Newborn newborn : newborns) {
            for (Mother mother : mothers) {
                if (newborn.getMotherID() == mother.getId()) {
                    newborn.setMother(mother);
                    mother.addNewborn(newborn);
                    break;
                }
            }
        }

        //podpunkt A
        System.out.println(getTallestNewborns(getBoysFromNewborn(newborns)));
        System.out.println(getTallestNewborns(getGirlsFromNewborn(newborns)));

        //podpunkt B
        System.out.println(getMostCommonBirthDay(countBirthsOnWeekdays(newborns)));
        System.out.println(getNumberOfBirthsOnWeekday(getMostCommonBirthDay(countBirthsOnWeekdays(newborns)), countBirthsOnWeekdays(newborns)));
        //Podać liczbe urodzen dnia najpopularniejszego

        //podpunkt C
        List<Mother> mothersC = getMothersWithNewbornsHeavierThan(getMothersBelowAge(mothers, 25), 4000);
        for (Mother motherC : mothersC) {
            System.out.println(motherC.getFirstName());
        }

        //podpunkt D
        List<Newborn> newbornsD = findGirlsWithMotherName(getGirlsFromNewborn(newborns));
        for (Newborn newbornD : newbornsD) {
            System.out.println(newbornD.getFirstName());
            System.out.println(newbornD.getBirthDate());
        }

        //podpunkt E
        List<Mother> mothersWithTwins = findMothersWithTwins(mothers);
        System.out.println("Mothers with twins: " + mothersWithTwins);

    }

    public static List<Newborn> getBoysFromNewborn(List<Newborn> newborns) {
        String gender = "s";
        List<Newborn> boysFromNewborn = new ArrayList<>();

        for (Newborn newborn : newborns) {
            if (gender.equals(newborn.getGender())) {
                boysFromNewborn.add(newborn);
            }
        }
        return boysFromNewborn;
    }

    public static List<Newborn> getGirlsFromNewborn(List<Newborn> newborns) {
        String gender = "c";
        List<Newborn> girlsFromNewborns = new ArrayList<>();

        for (Newborn newborn : newborns) {
            if (gender.equals(newborn.getGender())) {
                girlsFromNewborns.add(newborn);
            }
        }
        return girlsFromNewborns;
    }

    public static List<Newborn> getTallestNewborns(List<Newborn> newborns) {
        List<Newborn> tallestNewborns = new ArrayList<>();
        Newborn tallestNewborn = null;
        for (Newborn newborn : newborns) {
            if (tallestNewborn == null || newborn.getHeight() > tallestNewborn.getHeight()) {
                tallestNewborn = newborn;
            }
        }
        tallestNewborns.add(tallestNewborn);
        for (Newborn newborn : newborns) {
            if (!(tallestNewborn.equals(newborn)) && tallestNewborn.getHeight() == newborn.getHeight()) {
                tallestNewborns.add(newborn);
            }
        }
        return tallestNewborns;
    }

    public static int[] countBirthsOnWeekdays(List<Newborn> newborns) {
        int[] dayCounts = new int[DayOfWeek.values().length];
        for (Newborn newborn : newborns) {
            DayOfWeek day = newborn.getBirthDate().getDayOfWeek();
            dayCounts[day.getValue() - 1]++;
        }
        return dayCounts;
    }


    public static DayOfWeek getMostCommonBirthDay(int[] dayCounts) {
        int maxCount = 0;
        DayOfWeek modeDay = null;
        for (int i = 0; i < dayCounts.length; i++) {
            if (dayCounts[i] > maxCount) {
                maxCount = dayCounts[i];
                modeDay = DayOfWeek.of(i + 1);
            }
        }
        return modeDay;
    }

    public static int getNumberOfBirthsOnWeekday(DayOfWeek day, int[] dayCounts) {
        int birthOnWeekday = dayCounts[day.ordinal()];
        return birthOnWeekday;
    }

    public static List<Mother> getMothersBelowAge(List<Mother> mothers, int age) {
        List<Mother> mothersBelowAge = new ArrayList<>();
        for (Mother mother : mothers) {
            if (mother.getAge() < age) {
                mothersBelowAge.add(mother);
            }
        }
        return mothersBelowAge;
    }

    public static List<Mother> getMothersWithNewbornsHeavierThan(List<Mother> mothers, int mass) {
        List<Mother> mothersWithNewbornsHeavierThan = new ArrayList<>();
        for (Mother mother : mothers) {
            for (Newborn newborn : mother.getNewborns()) {
                if (newborn.getMass() > mass) {
                    mothersWithNewbornsHeavierThan.add(mother);
                }
            }
        }
        return mothersWithNewbornsHeavierThan;
    }

    public static List<Newborn> findGirlsWithMotherName(List<Newborn> newborns) {
        List<Newborn> girlsWithMotherName = new ArrayList<>();
        for (Newborn newborn : newborns) {
            if (newborn.getMother().getFirstName() == newborn.getFirstName()) {
                girlsWithMotherName.add(newborn);
            }
        }
        return girlsWithMotherName;
    }

    private static boolean hasTwins(Mother mother) {
        List<Newborn> newborns = mother.getNewborns();
        for (int i = 0; i < newborns.size(); i++) {
            LocalDate birthDate = newborns.get(i).getBirthDate();
            int count = 1;
            for (int j = i + 1; j < newborns.size(); j++) {
                if (newborns.get(j).getBirthDate().equals(birthDate)) {
                    count++;
                }
            }
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    public static List<Mother> findMothersWithTwins(List<Mother> mothers) {
        List<Mother> mothersWithTwins = new ArrayList<>();
        for (Mother mother : mothers) {
            if (hasTwins(mother)) {
                mothersWithTwins.add(mother);
            }
        }
        return mothersWithTwins;
    }


}

