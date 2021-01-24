package pl.aptewicz.unittests.speedometer;

public class Speedometer {
    private final double distance;

    private final int time;

    public Speedometer(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    /**
     * calculate speed in km/h based on distance and time
     * @return speed
     */
    public double calculateSpeed() {
        final double timeInHours = (double) time / 60;
        return distance / timeInHours;
    }
}
