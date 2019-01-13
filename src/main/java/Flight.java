public class Flight {

    private Plane plane;
    private int flightNumber;
    private AirportType destination;

    public Flight(int flightNumber, AirportType destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public AirportType getDestination() {
        return destination;
    }
}
