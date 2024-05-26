package pl.kurs.question4.model;

public abstract class FiguraAbstrakcyjna {

    private static int idCount = 0;
    protected int id;

    public FiguraAbstrakcyjna() {
        this.id = 0;
    }

    protected void assignFactoryId() {
        idCount++;
        this.id = idCount;
    }

    public int getFigureId() {
        return id;
    }
}
