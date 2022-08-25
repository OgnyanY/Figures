package Figures.TypesOfFigures;

public abstract class Figure implements Cloneable{
    public abstract double perimeter();
    public abstract void fromString(String data);
    public abstract String toString();

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return (Figure) super.clone();
    }
}
