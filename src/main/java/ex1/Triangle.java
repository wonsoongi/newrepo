package ex1;

public class Triangle implements ITriangle{
    
    IPoint p1, p2, p3;
    public Triangle(IPoint p1, IPoint p2, IPoint p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        double m1 = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        double m2 = (p3.getY() - p2.getY()) / (p3.getX() - p2.getX());
        double m3 = (p1.getY() - p3.getY()) / (p1.getX() - p3.getX());
        
        if (p1.equals(p2) || p2.equals(p3) || p1.equals(p3))
            throw new IllegalArgumentException("Some points coincide.");
        if (m1 == m2 && m2 == m3)
            throw new IllegalArgumentException("The points lie on the same line.");
        else if ((p1.getX() == p2.getX() && p2.getX() == p3.getX()) || (p1.getY() == p2.getY() && p2.getY() == p3.getY()))
            throw new IllegalArgumentException("The points lie on the same line.");

    }

    public Triangle() {
    }

    public double getPerimeter(){
        return IPoint.round(p1.getDistance(p2) + p1.getDistance(p3) + p2.getDistance(p3));
    }

    public boolean equals(Object o){

        if (this == o)
            return true;
        if (!(o instanceof Triangle))
            return false;

        Triangle t = (Triangle) o;
        
        return (p1.equals(t.p1) && p2.equals(t.p2) && p3.equals(t.p3))
            || (p1.equals(t.p2) && p2.equals(t.p3) && p3.equals(t.p1))
            || (p1.equals(t.p3) && p2.equals(t.p1) && p3.equals(t.p2));
    }

    @Override
    public IPoint getA() {
        return p1;
    }

    @Override
    public IPoint getB() {
       return p2;
    }

    @Override
    public IPoint getC() {
        return p3;
    }
}
