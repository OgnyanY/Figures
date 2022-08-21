package Figures;

public abstract class Figure implements Cloneable{
    public abstract double perimeter();

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return (Figure) super.clone();
    }
}
