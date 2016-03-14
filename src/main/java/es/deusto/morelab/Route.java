package es.deusto.morelab;

public class Route
        implements Comparable
{
    private double walkingSeconds;
    private double distanceMeters;
    private String destination;

    public Route()
    {
    }

    public Route(double walkingSeconds, double distanceMeters, String destination)
    {
        this.destination = destination;
        this.walkingSeconds = walkingSeconds;
        this.distanceMeters = distanceMeters;
    }

    public double getWalkingSeconds() {
        return this.walkingSeconds;
    }

    public void setWalkingSeconds(double walkingSeconds) {
        this.walkingSeconds = walkingSeconds;
    }

    public double getDistanceMeters() {
        return this.distanceMeters;
    }

    public void setDistanceMeters(double distanceMeters) {
        this.distanceMeters = distanceMeters;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int compareTo(Object comparerou)
    {
        int comparedist = (int)((Route)comparerou).getDistanceMeters();

        return (int)this.distanceMeters - comparedist;
    }
}
