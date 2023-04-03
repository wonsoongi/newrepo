package ex1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

  @Test
  void printsCoordinates() {
    Point p = new Point(1, 2);
    assertThat(p.toString()).isEqualTo("(1.0,2.0)");
  }

  @Test
  void isEqualToSelf() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(1, 1);

    boolean test = p1.equals(p2);
    assertThat(test).isTrue();
  }

  @Test
  void isEqualToPointWithSameCoordinates() {
    IPoint p1 = new Point(1, 1);
    IPoint p2 = new Point(1, 1);

    boolean test = p1.equals(p2);
    assertThat(test).isTrue();
  }

  @Test
  void isDifferentFromPointWithDifferentXCoordinate() {
    IPoint p1 = new Point(1, 1);
    IPoint p2 = new Point(2, 1);

    boolean test = p1.equals(p2);
    assertThat(test).isFalse();
  }

  @Test
  void isDifferentFromPointWithDifferentYCoordinate() {
    IPoint p1 = new Point(1, 1);
    IPoint p2 = new Point(1, 2);

    boolean test = p1.equals(p2);
    assertThat(test).isFalse();
  }

  @Test
  void isDifferentFromPointWithDifferentCoordinates() {
    IPoint p1 = new Point(1, 1);
    IPoint p2 = new Point(2, 2);

    boolean test = p1.equals(p2);
    assertThat(test).isFalse();
  }

  @Test
  void isSymmetricTrue() {
    IPoint p1 = new Point(1, 1);
    IPoint p2 = new Point(1, 1);

    boolean test = p1.equals(p2);
    assertThat(test).isTrue();
    test = p2.equals(p1);
    assertThat(test).isTrue();
  }

  @Test
  void equalsIsSymmetricFalse() {
    IPoint p1 = new Point(1, 2);
    IPoint p2 = new Point(2, 1);

    boolean test = p1.equals(p2);
    assertThat(test).isFalse();
    test = p2.equals(p1);
    assertThat(test).isFalse();
  }

  @Test
  void equalsIsTransitive() {
    IPoint p1 = new Point(1, 1);
    IPoint p2 = new Point(1, 1);
    IPoint p3 = new Point(1, 1);

    boolean test = p1.equals(p2);
    assertThat(test).isTrue();

    test = p2.equals(p3);
    assertThat(test).isTrue();

    test = p3.equals(p1);
    assertThat(test).isTrue();
  }

  @Test
  void distanceToSelfIsZero() {
    Point p = new Point(0, 1);
    double d = p.getDistance(p);

    assertThat(d).isEqualTo(0);
  }

  @Test
  @DisplayName("The distance between (3,9) and (3,9) should be 0")
  void distanceToPointWithSameCoordinatesIsZero() {
    Point p1 = new Point(3, 9);
    Point p2 = new Point(3, 9);
    double d = p1.getDistance(p2);

    assertThat(d).isEqualTo(0);
  }

  @Test
  @DisplayName("The distance between (1,1) and (4,5) should be 5")
  void distanceTest() {
    Point first = new Point(1, 1);
    Point second = new Point(4, 5);
    double d = first.getDistance(second);

    assertThat(d).isEqualTo(5);
  }

  @Test
  void getDistanceIsSymmetric() {
    Point p1 = new Point(7, 2);
    Point p2 = new Point(7, 2);
    double d1 = p1.getDistance(p2);
    double d2 = p2.getDistance(p1);

    assertThat(d1).isEqualTo(d2);
  }

  @Test
  @DisplayName("(0,1) should have a lower order than (1,1)")
  void comparisonTestBeforeX() {
    Point p1 = new Point(0, 1);
    Point p2 = new Point(1, 1);
    int comparison = p1.compareTo(p2);
    assertThat(comparison).isLessThan(0);
  }

  @Test
  @DisplayName("(0,1) should have a lower order than (0,2)")
  void comparisonTestBeforeY() {
    Point p1 = new Point(0, 1);
    Point p2 = new Point(0, 2);
    int comparison = p1.compareTo(p2);
    assertThat(comparison).isLessThan(0);
  }

  @Test
  @DisplayName("(0,1) should have the same order than (0,1)")
  void comparisonTestSame() {
    Point first = new Point(0, 1);
    Point second = new Point(0, 1);
    int comparison = first.compareTo(second);
    assertThat(comparison).isEqualTo(0);
  }

  @Test
  @DisplayName("(1,1) should have a higher order than (0,1)")
  void comparisonTestHigher() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(0, 1);
    int comparison = p1.compareTo(p2);
    assertThat(comparison).isGreaterThan(0);
  }

}
