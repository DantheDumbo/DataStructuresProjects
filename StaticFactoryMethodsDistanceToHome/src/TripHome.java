public class TripHome {
    private double distance;
    private int time;

    private TripHome(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }
    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "TripHome{" +
                "distance=" + distance +
                ", time=" + time +
                '}';
    }
}
