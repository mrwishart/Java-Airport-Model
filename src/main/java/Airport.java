import java.lang.reflect.Array;
import java.util.ArrayList;

public class Airport {

    private AirportType airportCode;
    private ArrayList<Hanger> hangers;
    private ArrayList<Flight> flights;

    public Airport(AirportType airportCode) {
        this.airportCode = airportCode;
        this.hangers = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public AirportType getAirportCode() {
        return airportCode;
    }

    public ArrayList<Hanger> getHangers() {
        return hangers;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void addHanger(int capacity){
        Hanger hanger = new Hanger(capacity);
        hangers.add(hanger);
    }

    public void addPlaneToHanger(PlaneType type, AirlineType airline){
        Plane plane = new Plane(type, airline);
        Hanger nextEmptyHanger = findNextHangerSpace();
        if (nextEmptyHanger != null) {nextEmptyHanger.addPlane(plane);}
    }

    public Hanger findNextHangerSpace() {
        for (Hanger hanger: this.hangers) {
            if (hanger.spacesAvailable() > 0) {return hanger;}
        }

        return null;
    }

    public void createFlight(int number, AirportType destination){
        if (destination == this.airportCode) {return;}

        Flight flight = new Flight(number, destination);
        this.flights.add(flight);
    }

    public Flight findFlightByNumber(int flightNumber){
        for (Flight flight: this.flights) {
            if (flightNumber == flight.getFlightNumber()){ return flight;}
        }

        return null;
    }

    public void sellFlightTicketByNumber(int flightNumber, Passenger passenger){
        Flight flight = findFlightByNumber(flightNumber);
        if (flight==null) {return;}

        flight.sellTicket(passenger);
    }

    public void assignPlaneToFlight(int flightNumber){
        Flight flight = findFlightByNumber(flightNumber);
        if (flight==null) {return;}

        Plane plane = findBestPlane(flight.noOfPassengers());
        flight.assignPlane(plane);
    }

    public Plane findBestPlane(int numberOfPassengers) {
        Hanger hangerContainingPlane = null;

        int bestPlaneIndex = -1;
        int bestRemainingSeats = 999999;

        for (Hanger hanger: this.hangers) {
            int planeIndex = 0;

            for (Plane plane: hanger.getPlanes()) {
                int remainingSeats = plane.getCapacity() - numberOfPassengers;

                if (remainingSeats >= 0 && remainingSeats < bestRemainingSeats){
                    hangerContainingPlane = hanger;
                    bestPlaneIndex = planeIndex;
                }

                planeIndex++;
            }
        }

        if (hangerContainingPlane == null) {return null;}

        return hangerContainingPlane.getPlanes().remove(bestPlaneIndex);
    }

}
