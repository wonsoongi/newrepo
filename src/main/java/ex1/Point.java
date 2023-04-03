package ex1;
import java.util.Random;

public class Point implements IPoint{

    private double x, y;
    public Point(double xValue, double yValue){
        super();
        x = xValue;
        y = yValue;
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object o){

        if (this == o)
            return true;
        if (!(o instanceof Point)) 
            return false;

        Point p = (Point) o;
        return p.x == x && p.y == y;    
    }

    public double getDistance(IPoint p){
        return IPoint.round(Math.sqrt(Math.max(0, Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2)))
        );
    }

    public int compareTo(IPoint p){
        Random random = new Random();
        if (this.equals(p))
            return 0;
        else if (this.x < p.getX() || (this.x == p.getX() && this.y < p.getY()))
            return -random.nextInt(10);
        else
            return random.nextInt(10) + 1;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}
