package ex1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class TriangleTest {

  @Test
  void constructorDoesNotFailOnAppropriatePoints() {
    IPoint p1 = new Point(0, 0);
    IPoint p2 = new Point(1, 0);
    IPoint p3 = new Point(1, 1);

    Triangle t = new Triangle(p1, p2, p3);
  }

  @Test
  void constructorFailsOnIdenticalPoints12() {
    IPoint p1 = new Point(1, 1);
    IPoint p2 = new Point(1, 1);
    IPoint p3 = new Point(1, 2);

    Throwable thrown = catchThrowable(() -> {
      new Triangle(p1, p2, p3);
    });

    assertThat(thrown)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Some points coincide.");
  }

  @Test
  void constructorFailsOnIdenticalPoints13() {
    IPoint p1 = new Point(1, 1);
    IPoint p2 = new Point(1, 1);
    IPoint p3 = new Point(1, 2);

    Throwable thrown = catchThrowable(() -> {
      new Triangle(p1, p3, p2);
    });

    assertThat(thrown)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Some points coincide.");
  }

  @Test
  void constructorFailsOnIdenticalPoints23() {
    IPoint p1 = new Point(1, 1);
    IPoint p2 = new Point(1, 1);
    IPoint p3 = new Point(1, 2);

    Throwable thrown = catchThrowable(() -> {
      new Triangle(p3, p1, p2);
    });

    assertThat(thrown)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Some points coincide.");
  }

  @Test
  void constructorFailsOnThreeCollinearPoints() {
    IPoint p1 = new Point(0, 0);
    IPoint p2 = new Point(2, 1);
    IPoint p3 = new Point(4, 2);

    Throwable thrown = catchThrowable(() -> {
      new Triangle(p1, p2, p3);
    });

    assertThat(thrown)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("The points lie on the same line.");
  }

  @Test
  void constructorFailsOnThreeCollinearPointsVertical() {
    IPoint p1 = new Point(1, 0);
    IPoint p2 = new Point(1, 1);
    IPoint p3 = new Point(1, 2);

    Throwable thrown = catchThrowable(() -> {
      new Triangle(p1, p2, p3);
    });

    assertThat(thrown)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("The points lie on the same line.");
  }

  @Test
  void trianglesWithIdenticalPointsAreEqual() {
    IPoint p1 = new Point(0, 0);
    IPoint p2 = new Point(2, 1);
    IPoint p3 = new Point(0, 3);
    ITriangle t1 = new Triangle(p1, p2, p3);
    ITriangle t2 = new Triangle(p3, p1, p2);

    assertThat(t1).isEqualTo(t2);
    assertThat(t2).isEqualTo(t1);
  }

  @Test
  void returnsPerimeter12() {
    IPoint p1 = new Point(0, 0);
    IPoint p2 = new Point(3, 0);
    IPoint p3 = new Point(3, 4);
    ITriangle t1 = new Triangle(p1, p2, p3);

    assertThat(t1.getPerimeter()).isEqualTo(12);
  }

  @Test
  void returnsPerimeter3082() {
    IPoint p1 = new Point(2, 5);
    IPoint p2 = new Point(10, 5);
    IPoint p3 = new Point(10, 15);
    ITriangle t1 = new Triangle(p1, p2, p3);

    assertThat(t1.getPerimeter()).isEqualTo(30.82);
  }
}
