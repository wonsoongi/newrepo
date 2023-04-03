package ex1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class EquilateralTriangleTest {
  
  @Test
  void constructorFailsOnThreeDifferentSides() {
    IPoint p1 = new Point(0, 0);
    IPoint p2 = new Point(1, 1);
    IPoint p3 = new Point(0, 4);

    Throwable thrown = catchThrowable(() -> {
      new EquilateralTriangle(p1, p2, p3);
    });

    assertThat(thrown)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Not an equilateral triangle.");
  }

  @Test
  void constructorFailsOnTwoDifferentSides() {
    IPoint p1 = new Point(0,0);
    IPoint p2 = new Point(4,0);
    IPoint p3 = new Point(2,3);

    Throwable thrown = catchThrowable(() -> {
      new EquilateralTriangle(p1, p2, p3);
    });

    assertThat(thrown)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Not an equilateral triangle.");
  }

  @Test
  void constructorDoesNotFailOnEqualSides() {
    IPoint p1 = new Point(0,0);
    IPoint p2 = new Point(4,0);
    IPoint p3 = new Point(2,3.464);

    EquilateralTriangle t = new EquilateralTriangle(p1, p2, p3);
  }

  @Test
  void ReturnsPerimeter3() {
    IPoint p1 = new Point(0, 0);
    IPoint p2 = new Point(1, 0);
    IPoint p3 = new Point(0.5, 0.866);
    ITriangle t1 = new EquilateralTriangle(p1, p2, p3);

    assertThat(t1.getPerimeter()).isEqualTo(3);
  }
  
}
