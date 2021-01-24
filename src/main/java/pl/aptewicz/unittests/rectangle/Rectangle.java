package pl.aptewicz.unittests.rectangle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EmptyStackException;

public class Rectangle {
    private final double a;

    private final double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double calculateField() {
        if (a < 0 || b < 0) {
            throw new RuntimeException();
        }
        BigDecimal field = BigDecimal.valueOf(a * b).setScale(2, RoundingMode.HALF_UP);
        return field.doubleValue();
    }
}
