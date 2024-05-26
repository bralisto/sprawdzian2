package pl.kurs.question4.model;

public class Kolo extends FiguraAbstrakcyjna implements Figura{

    private double promien;

    public Kolo(double promien) {
        this.promien = promien;
    }

    public Kolo(double promien, boolean isFactoryMethod) {
        this.promien = promien;
        if (isFactoryMethod) {
            assignFactoryId();
        }
    }

    @Override
    public double calculateArea() {
        return Math.pow(promien, 2) * pi;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * promien * pi;
    }

    @Override
    public String toString() {
        return "Figura nr " + getFigureId() + ": Kolo o promieniu " + promien;
    }

    @Override
    public String saveToFileString() {
        return "Kolo;" + promien;
    }
}
