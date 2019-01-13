import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane, smallPlane;
    Passenger passenger;

    @Before
    public void setUp(){
        plane = new Plane(PlaneType.BOEING747, AirlineType.BRITISHAIRWAYS);
        smallPlane = new Plane(PlaneType.VERYSMALLPLANE, AirlineType.KLM);
        passenger = new Passenger("John Everyman");
    }


    @Test
    public void getType() {
        assertEquals(PlaneType.BOEING747, plane.getType());
    }

    @Test
    public void getPassengers__PlaneInitiallyEmpty() {
        assertEquals(0, plane.getPassengers().size());
    }

    @Test
    public void getTypeName() {
        assertEquals("Boeing 747", plane.getTypeName());
    }

    @Test
    public void getCapacity() {
        assertEquals(50, plane.getCapacity());
    }

    @Test
    public void remainingSeats__PlaneInitiallyEmpty() {
        assertEquals(50, plane.remainingSeats());
    }

    @Test
    public void canAddPassenger() {
        assertEquals(0, plane.getPassengers().size());
        assertEquals(50, plane.remainingSeats());
        plane.addPassenger(passenger);
        assertEquals(1, plane.getPassengers().size());
        assertEquals(49, plane.remainingSeats());
    }

    @Test
    public void cannotAddAboveCapacity(){
        assertEquals(0, smallPlane.getPassengers().size());
        assertEquals(2, smallPlane.remainingSeats());
        smallPlane.addPassenger(passenger);
        smallPlane.addPassenger(passenger);
        smallPlane.addPassenger(passenger);
        assertEquals(2, smallPlane.getPassengers().size());
        assertEquals(0, smallPlane.remainingSeats());
    }

    @Test
    public void canEmptyPlane(){
        assertEquals(0, plane.getPassengers().size());
        assertEquals(50, plane.remainingSeats());
        plane.addPassenger(passenger);
        plane.addPassenger(passenger);
        assertEquals(2, plane.getPassengers().size());
        assertEquals(48, plane.remainingSeats());
        plane.emptyPlane();
        assertEquals(0, plane.getPassengers().size());
        assertEquals(50, plane.remainingSeats());
    }

    @Test
    public void getAirline() {
        assertEquals(AirlineType.KLM, smallPlane.getAirline());
    }
}
