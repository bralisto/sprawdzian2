package pl.kurs.question4.app;

import pl.kurs.question4.model.Figura;
import pl.kurs.question4.model.FiguraAbstrakcyjna;
import pl.kurs.question4.model.Kwadrat;
import pl.kurs.question4.model.Prostokat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Figura> figury = Arrays.asList(Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10, 20));
        for (Figura f : figury) {
            System.out.println(f);
        }

        double maxArea = 0;
        double maxPerimeter = 0;
        int maxAreaId = 0;
        int maxPerimeterId = 0;

        for (int i = 0; i < figury.size(); i++) {
            if (figury.get(i).calculateArea() > maxArea) {
                maxArea = figury.get(i).calculateArea();
                maxAreaId = i;
            }
        }

        for (int i = 0; i < figury.size(); i++) {
            if (figury.get(i).calculatePerimeter() > maxPerimeter) {
                maxPerimeter = figury.get(i).calculatePerimeter();
                maxPerimeterId = i;
            }
        }

        System.out.println("Figura z największym obwodem to: " + figury.get(maxPerimeterId));
        System.out.println("Figura z największym polem to: " + figury.get(maxAreaId));

        System.out.println(figury.contains(new Kwadrat(10)));

        saveFiguryToFile(figury, "src/main/java/pl/kurs/question4/figury.txt");

        Figura prostokat = new Prostokat(15,30);
        System.out.println(prostokat);


    }

    public static void saveFiguryToFile(List<Figura> figury, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            StringBuilder sb = new StringBuilder();
            for (Figura f : figury) {
                sb.append(f.saveToFileString()).append(System.lineSeparator());
            }
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


