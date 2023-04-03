package ex1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface IPoint extends Comparable<IPoint> {

  double getX();

  double getY();

  double getDistance(IPoint p);

  static double round(double value) {
    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(2, RoundingMode.UP);
    return bd.doubleValue();
  }
}
