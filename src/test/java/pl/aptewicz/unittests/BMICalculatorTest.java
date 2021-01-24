package pl.aptewicz.unittests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BMICalculatorTest {

    private static BMICalculator bmiCalculator;

    @BeforeAll
    static void setUp() {
        bmiCalculator = new BMICalculator();
    }

    @Test
    void shouldCalculateBMIWhenUserProvidesPositiveNumbersAsWeightAndHeight() {
        // given
        bmiCalculator.setHeight(1.8);
        bmiCalculator.setWeight(72);

        // when
        final double bmi = bmiCalculator.calculateBMI();

        // then
        final double expectedBmi = 22.22;
        //        assertEquals(expectedBmi, bmi, "wrong BMI");
        Assertions.assertThat(bmi).isFinite().isPositive().isEqualTo(expectedBmi);
    }

    @Test
    void shouldThrowExceptionWhenUserProvides0WeightAnd0Height() {
        // give
        bmiCalculator.setHeight(0);
        bmiCalculator.setWeight(0);

        // when
        final Executable bmiCalculation = () -> bmiCalculator.calculateBMI();

        // then
        assertThrows(InvalidNumberProvidedException.class, bmiCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvides0Weight() {
        // give
        bmiCalculator.setHeight(1.8);
        bmiCalculator.setWeight(0);

        // when
        final Executable bmiCalculation = () -> bmiCalculator.calculateBMI();

        // then
        assertThrows(InvalidNumberProvidedException.class, bmiCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvides0Height() {
        // give
        bmiCalculator.setHeight(0);
        bmiCalculator.setWeight(58);

        // when
        final Executable bmiCalculation = () -> bmiCalculator.calculateBMI();

        // then
        assertThrows(InvalidNumberProvidedException.class, bmiCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvidesNegativeHeight() {
        // give
        bmiCalculator.setHeight(-1.80);
        bmiCalculator.setWeight(58);

        // when
        final Executable bmiCalculation = () -> bmiCalculator.calculateBMI();

        // then
        assertThrows(InvalidNumberProvidedException.class, bmiCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvidesNegativeWeight() {
        // give
        bmiCalculator.setHeight(1.80);
        bmiCalculator.setWeight(-58);

        // when
        final Executable bmiCalculation = () -> bmiCalculator.calculateBMI();

        // then
        assertThrows(InvalidNumberProvidedException.class, bmiCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvidesNegativeWeightAndHeight() {
        // give
        bmiCalculator.setHeight(-1.80);
        bmiCalculator.setWeight(-58);

        // when
        final Executable bmiCalculation = () -> bmiCalculator.calculateBMI();

        // then
        assertThrows(InvalidNumberProvidedException.class, bmiCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvidesNegativeWeightAnd0Height() {
        // give
        bmiCalculator.setHeight(0);
        bmiCalculator.setWeight(-58);

        // when
        final Executable bmiCalculation = () -> bmiCalculator.calculateBMI();

        // then
        assertThrows(InvalidNumberProvidedException.class, bmiCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvidesMaxHeightAndWeight() {
        // give
        bmiCalculator.setHeight(Double.MAX_VALUE);
        bmiCalculator.setWeight(Double.MAX_VALUE);

        // when
        final Executable bmiCalculation = () -> bmiCalculator.calculateBMI();

        // then
        assertThrows(InvalidNumberProvidedException.class, bmiCalculation);
    }
}