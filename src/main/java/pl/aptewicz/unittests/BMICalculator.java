package pl.aptewicz.unittests;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BMICalculator {
    private double weight;

    private double height;

    public double calculateBMI() {
        if (weight <= 0 || height <= 0 || weight == Double.MAX_VALUE || height == Double.MAX_VALUE) {
            throw new InvalidNumberProvidedException(
                    "Weight and height must be positive number which is lower than " + Double.MAX_VALUE);
        }
        final BigDecimal weight = BigDecimal.valueOf(this.weight);
        final BigDecimal height = BigDecimal.valueOf(this.height);
        final BigDecimal heightPower = height.pow(2);
        return weight.divide(heightPower, 2, RoundingMode.HALF_UP).doubleValue();
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
