package pl.aptewicz.unittests.rectangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.assertThat;

public class RectangleTest {

    @Test
    void shouldCreateRectangleWithProvidedSidesLength() {
        // given
        final double a = 15;
        final double b = 16.8;

        // when
        final Rectangle rectangle = new Rectangle(a, b);

        // then
        final double aValue = rectangle.getA();
        final double bValue = rectangle.getB();

        assertThat(aValue).isPositive().isFinite().isEqualTo(a);
        assertThat(bValue).isPositive().isFinite().isEqualTo(b);
    }

    @Test
    void shouldCalculateRectangleField() {
        // given
        final double a = 5;
        final double b = 2;

        // when
        final Rectangle rectangle = new Rectangle(a, b);
        final double field = rectangle.calculateField();

        // then
        assertThat(field).isPositive().isFinite().isEqualTo(10);
    }

    @Test
    void shouldCalculateRectangleFieldForDecimalLengths() {
        // given
        final double a = 5.5;
        final double b = 2.3;

        // when
        final Rectangle rectangle = new Rectangle(a, b);
        final double field = rectangle.calculateField();

        // then
        assertThat(field).isPositive().isFinite().isEqualTo(12.65);
    }

    @Test
    void shouldThrowExceptionWhenCalculateRectangleFieldForNegativeLengths() {
        // given
        final double a = -5.5;
        final double b = -2.3;

        // when
        final Rectangle rectangle = new Rectangle(a, b);
        final Executable call = rectangle::calculateField;

        // then
        Assertions.assertThrows(Exception.class, call);
    }
}
