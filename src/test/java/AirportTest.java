import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;
    AirportType airportCode;
    Hanger hanger, fullHanger, notFullHanger;
    Plane plane;
    Flight flight;
    Passenger passenger;

    @Before
    public void beforeEach(){
        airportCode = AirportType.EDINBURGH;
        airport = new Airport(airportCode);
        hanger = new Hanger(5);
        fullHanger = new Hanger(2);
        notFullHanger = new Hanger(1);
        plane = new Plane(PlaneType.BOEING747, AirlineType.KLM);
        fullHanger.addPlane(plane);
        fullHanger.addPlane(plane);
        flight = new Flight(123, AirportType.GATWICK);
        passenger = new Passenger("Joe Everyflight");
    }


    @Test
    public void getAirportCode() {
        assertEquals(airportCode, airport.getAirportCode());
        assertEquals("EDI", airport.getAirportCode().getCode());
    }

    @Test
    public void airportInitiallyHasNoHangers() {
        assertEquals(0, airport.getHangers().size());
    }

    @Test
    public void getFlights__NoFlightsInitially() {
        assertEquals(0, airport.getFlights().size());
    }

    @Test
    public void canAddHanger() {
        airport.addHanger(1);
        assertEquals(1, airport.getHangers().size());
    }

    @Test
    public void canFindNextHangerWithASpace() {
        airport.addHanger(0);
        airport.addHanger(0);
        airport.addHanger(0);
        airport.addHanger(1);
        assertEquals(1, airport.findNextHangerSpace().getCapacity());
    }

    @Test
    public void canAddPlaneToHanger() {
        airport.addHanger(1);
        airport.addHanger(0);
        airport.addHanger(1);
        assertEquals(0, airport.getHangers().get(0).getPlanes().size());
        assertEquals(0, airport.getHangers().get(1).getPlanes().size());
        assertEquals(0, airport.getHangers().get(2).getPlanes().size());
        airport.addPlaneToHanger(PlaneType.BOEING747, AirlineType.KLM);
        airport.addPlaneToHanger(PlaneType.BOEING747, AirlineType.KLM);
        assertEquals(1, airport.getHangers().get(0).getPlanes().size());
        assertEquals(0, airport.getHangers().get(1).getPlanes().size());
        assertEquals(1, airport.getHangers().get(2).getPlanes().size());
    }


    @Test
    public void canCreateFlight() {
        airport.createFlight(1, AirportType.GATWICK);
        assertEquals(1, airport.getFlights().size());
    }

    @Test
    public void cannotCreateFlightToSameAirport() {
        airport.createFlight(1, AirportType.EDINBURGH);
        assertEquals(0, airport.getFlights().size());
    }

    @Test
    public void canFindFlightByNumber() {
        airport.createFlight(1, AirportType.GATWICK);
        airport.createFlight(2, AirportType.GLASGOW);
        airport.createFlight(3, AirportType.HEATHROW);
        airport.createFlight(4, AirportType.PRESTWICK);
        assertEquals(AirportType.HEATHROW, airport.findFlightByNumber(3).getDestination());
    }

    @Test
    public void sellFlightTicketByNumber() {
        airport.createFlight(1, AirportType.GATWICK);
        airport.createFlight(2, AirportType.GLASGOW);
        airport.createFlight(3, AirportType.HEATHROW);
        airport.createFlight(4, AirportType.PRESTWICK);
        airport.sellFlightTicketByNumber(2, passenger);
        airport.sellFlightTicketByNumber(2, passenger);
        airport.sellFlightTicketByNumber(3, passenger);
        assertEquals(0, airport.findFlightByNumber(1).noOfPassengers());
        assertEquals(2, airport.findFlightByNumber(2).noOfPassengers());
        assertEquals(1, airport.findFlightByNumber(3).noOfPassengers());
        assertEquals(0, airport.findFlightByNumber(4).noOfPassengers());
    }

    @Test
    public void canAssignPlaneToFlight() {
        airport.createFlight(1, AirportType.GATWICK);
        airport.createFlight(2, AirportType.GLASGOW);
        airport.createFlight(3, AirportType.HEATHROW);
        airport.createFlight(4, AirportType.PRESTWICK);
        airport.addHanger(5);
        airport.addHanger(2);
        airport.addPlaneToHanger(PlaneType.VERYSMALLPLANE, AirlineType.BRITISHAIRWAYS);
        airport.addPlaneToHanger(PlaneType.VERYSMALLPLANE, AirlineType.BRITISHAIRWAYS);
        airport.addPlaneToHanger(PlaneType.VERYSMALLPLANE, AirlineType.BRITISHAIRWAYS);
        airport.addPlaneToHanger(PlaneType.VERYSMALLPLANE, AirlineType.BRITISHAIRWAYS);
        airport.addPlaneToHanger(PlaneType.VERYSMALLPLANE, AirlineType.BRITISHAIRWAYS);
        airport.addPlaneToHanger(PlaneType.VERYSMALLPLANE, AirlineType.BRITISHAIRWAYS);
        airport.addPlaneToHanger(PlaneType.BOEING737, AirlineType.BRITISHAIRWAYS);
        airport.sellFlightTicketByNumber(2, passenger);
        airport.sellFlightTicketByNumber(2, passenger);
        airport.sellFlightTicketByNumber(2, passenger);
        airport.sellFlightTicketByNumber(2, passenger);
        assertEquals(5, airport.getHangers().get(0).getPlanes().size());
        assertEquals(2, airport.getHangers().get(1).getPlanes().size());
        airport.assignPlaneToFlight(2);
        assertEquals(PlaneType.BOEING737, airport.findFlightByNumber(2).getPlane().getType());
        assertEquals(5, airport.getHangers().get(0).getPlanes().size());
        assertEquals(1, airport.getHangers().get(1).getPlanes().size());
    }

}
