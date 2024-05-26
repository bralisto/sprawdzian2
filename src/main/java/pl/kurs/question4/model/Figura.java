package pl.kurs.question4.model;

public interface Figura {

    static double pi = 3.14;

    double calculateArea();

    double calculatePerimeter();

    String saveToFileString();

    static Figura stworzKwadrat(double bok) {
        return new Kwadrat(bok, true);
    }

    static Figura stworzProstokat(double bok1, double bok2) {
        return new Prostokat(bok1, bok2, true);
    }

    static Figura stworzKolo(double promien) {
        return new Kolo(promien, true);
    }


}
