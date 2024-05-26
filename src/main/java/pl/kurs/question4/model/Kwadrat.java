package pl.kurs.question4.model;

import java.util.Objects;

public class Kwadrat extends FiguraAbstrakcyjna implements Figura {

    private double bok;

    public Kwadrat(double bok) {
        this.bok = bok;
    }

    public Kwadrat(double bok, boolean isFactoryMethod) {
        this.bok = bok;
        if (isFactoryMethod) {
            assignFactoryId();
        }
    }

    @Override
    public double calculateArea() {
        return bok * bok;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * bok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kwadrat kwadrat = (Kwadrat) o;
        return Double.compare(kwadrat.bok, bok) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bok);
    }

    @Override
    public String toString() {
        return "Figura nr " + getFigureId() + ": Kwadrat o boku " + bok;
    }

    @Override
    public String saveToFileString() {
        return "Kwadrat;" + bok;
    }
}
