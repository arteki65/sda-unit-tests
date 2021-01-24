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

        if (distance <=0 || time <= 0) {
            throw new InvalidNumberProvidedException("Distance and Time must be a positive number (grater than zero)! ");
        }
        final double timeInHours = (double) time / 60;
        return distance / timeInHours;
    }
}
