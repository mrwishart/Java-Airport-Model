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
}
