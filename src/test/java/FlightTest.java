import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger;

    @Before
    public void setUp(){
        flight = new Flight(1,AirportType.EDINBURGH);
        passenger = new Passenger("John Everyman");
        plane = new Plane(PlaneType.BOEING747, AirlineType.KLM);
    }

    @Test
    public void getFlightNumber() {
        assertEquals(1, flight.getFlightNumber());
    }

    @Test
    public void getDestination() {
        assertEquals(AirportType.EDINBURGH, flight.getDestination());
    }

    @Test
    public void getTicketsSold__InitiallyEmpty() {
        assertEquals(0, flight.getTicketsSold().size());
    }

    @Test
    public void getTicketsSold__SoldTwo() {
        assertEquals(0, flight.getTicketsSold().size());
        flight.sellTicket(passenger);
        flight.sellTicket(passenger);
        assertEquals(2, flight.getTicketsSold().size());
    }

    @Test
    public void canStopSelling() {
        assertEquals(0, flight.getTicketsSold().size());
        flight.stopSelling();
        flight.sellTicket(passenger);
        flight.sellTicket(passenger);
        assertEquals(0, flight.getTicketsSold().size());
    }

    @Test
    public void canClearTicketsSold() {
        assertEquals(0, flight.getTicketsSold().size());
        flight.sellTicket(passenger);
        flight.sellTicket(passenger);
        assertEquals(2, flight.getTicketsSold().size());
        flight.clearTicketsSold();
        assertEquals(0, flight.getTicketsSold().size());
    }

    @Test
    public void canAddTicketHoldersToPlane() {
        assertEquals(0, flight.getTicketsSold().size());
        flight.sellTicket(passenger);
        flight.sellTicket(passenger);
        assertEquals(2, flight.getTicketsSold().size());
        flight.addTicketHoldersToPlane(plane);
        assertEquals(2, flight.getTicketsSold().size());
        assertEquals(2, plane.getPassengers().size());
    }

    @Test
    public void canAssignPlane() {
        assertEquals(0, flight.getTicketsSold().size());
        flight.sellTicket(passenger);
        flight.sellTicket(passenger);
        assertEquals(2, flight.getTicketsSold().size());
        flight.assignPlane(plane);
        assertEquals(0, flight.getTicketsSold().size());
        assertEquals(2, flight.getPlane().getPassengers().size());
    }

    @Test
    public void canSellSeatDirectlyToPlane() {
        assertEquals(0, flight.getTicketsSold().size());
        flight.sellTicket(passenger);
        flight.sellTicket(passenger);
        assertEquals(2, flight.getTicketsSold().size());
        flight.assignPlane(plane);
        assertEquals(0, flight.getTicketsSold().size());
        assertEquals(2, flight.getPlane().getPassengers().size());
        flight.sellTicket(passenger);
        assertEquals(0, flight.getTicketsSold().size());
        assertEquals(3, flight.getPlane().getPassengers().size());
    }

    @Test
    public void canGetOfPassengers() {
        assertEquals(0, flight.noOfPassengers());
        flight.sellTicket(passenger);
        flight.sellTicket(passenger);
        assertEquals(2, flight.noOfPassengers());
        flight.assignPlane(plane);
        assertEquals(2, flight.noOfPassengers());
        flight.sellTicket(passenger);
        assertEquals(3, flight.noOfPassengers());
    }
}
