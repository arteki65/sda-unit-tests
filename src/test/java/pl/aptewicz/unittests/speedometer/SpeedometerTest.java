package pl.aptewicz.unittests.speedometer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.aptewicz.unittests.InvalidNumberProvidedException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SpeedometerTest {


    private static Speedometer speedometer;


    @Test
    void shouldCalculateSpeedWhenUserProvidesPositiveNumbersAsDistanceAndTime() {
        // given
        speedometer = new Speedometer(10,5);

        // when
        final double speed = speedometer.calculateSpeed();

        // then
        final double expectedSpeed = 120.0;
        Assertions.assertThat(speed).isFinite().isPositive().isEqualTo(expectedSpeed);
    }

    @Test
    void shouldThrowExceptionWhenUserProvides0Time() {
        // give
        speedometer = new Speedometer(10,0);

        // when
        final Executable speedCalculation = () -> speedometer.calculateSpeed();

        // then
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvidesNegativeDistance() {
        // give
        speedometer = new Speedometer(-10,5);

        // when
        final Executable speedCalculation = () -> speedometer.calculateSpeed();

        // then
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvidesNegativeTime() {
        // give
        speedometer = new Speedometer(10,-5);

        // when
        final Executable speedCalculation = () -> speedometer.calculateSpeed();

        // then
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvidesNegativeDistanceAndTime() {
        // give
        speedometer = new Speedometer(-10,-5);

        // when
        final Executable speedCalculation = () -> speedometer.calculateSpeed();

        // then
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvidesNegativeDistanceAnd0Time() {
        // give
        speedometer = new Speedometer(-10,0);

        // when
        final Executable speedCalculation = () -> speedometer.calculateSpeed();

        // then
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);
    }

    @Test
    void shouldThrowExceptionWhenUserProvidesMaxDistanceAndTime() {
        // give
        speedometer = new Speedometer(Double.MAX_VALUE, Integer.MAX_VALUE);

        // when
        final Executable speedCalculation = () -> speedometer.calculateSpeed();

        // then
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);
    }
}