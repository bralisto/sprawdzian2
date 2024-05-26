package pl.kurs.question4.model;

public class Prostokat extends FiguraAbstrakcyjna implements Figura{

    private double bok1;
    private double bok2;

    public Prostokat(double bok1, double bok2) {
        this.bok1 = bok1;
        this.bok2 = bok2;
    }

    public Prostokat(double bok1, double bok2, boolean isFactoryMethod) {
        this.bok1 = bok1;
        this.bok2 = bok2;
        if (isFactoryMethod) {
            assignFactoryId();
        }
    }

    @Override
    public double calculateArea() {
        return bok1 * bok2;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (bok1 + bok2);
    }

    @Override
    public String toString() {
        return "Figura nr " + getFigureId() + ": Prostokat o bokach " + bok1 + "x" + bok2;
    }

    @Override
    public String saveToFileString() {
        return "Prostokat;" + bok1 + ";" + bok2;
    }
}
