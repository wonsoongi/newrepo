package ex1;

public class EquilateralTriangle extends Triangle{
    
    public EquilateralTriangle(IPoint p1, IPoint p2, IPoint p3){
        super(p1, p2, p3);
        if (p1.getDistance(p2) != p2.getDistance(p3) || p1.getDistance(p2) != p1.getDistance(p3))
            throw new IllegalArgumentException("Not an equilateral triangle.");
    }

    @Override
    public double getPerimeter(){
        return p1.getDistance(p2) * 3;
    }
}
