package pl.aptewicz.unittests.speedometer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class SpeedometerTest {

    private static Speedometer speedometer;

    @Test
    void shouldCalculateSpeedWhenUserProvidesCorrectNumbers() {
        speedometer = new Speedometer(60, 30);

        final double speed = speedometer.calculateSpeed();

        final double expectedSpeed = 120d;

        Assertions.assertThat(speed).isPositive().isFinite().isEqualTo(expectedSpeed);
    }

    @Test
    void shouldThrowExceptionWhenDistanceIsZero() {
        speedometer = new Speedometer(0, 30);

        final Executable speedCalculation = () -> speedometer.calculateSpeed();
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);

    }

    @Test
    void shouldThrowExceptionWhenTimeIsZero() {
        speedometer = new Speedometer(70, 0);

        final Executable speedCalculation = () -> speedometer.calculateSpeed();
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);

    }

    @Test
    void shouldThrowExceptionWhenDistanceAndTimeIsZero() {
        speedometer = new Speedometer(0, 0);

        final Executable speedCalculation = () -> speedometer.calculateSpeed();
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);

    }

    @Test
    void shouldThrowExceptionWhenDistanceIsNegative() {
        speedometer = new Speedometer(-50, 120);

        final Executable speedCalculation = () -> speedometer.calculateSpeed();
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);

    }

    @Test
    void shouldThrowExceptionWhenTimeIsNegative() {
        speedometer = new Speedometer(850, -50);

        final Executable speedCalculation = () -> speedometer.calculateSpeed();
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);
    }

    @Test
    void shouldThrowExceptionWhenDistanceAndTimeAreNegative() {
        speedometer = new Speedometer(-50, -30);

        final Executable speedCalculation = () -> speedometer.calculateSpeed();
        assertThrows(InvalidNumberProvidedException.class, speedCalculation);

    }

}
