import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;

    @Before
    public void setUp(){
        flight = new Flight(1,AirportType.EDINBURGH);
    }

    @Test
    public void getFlightNumber() {
        assertEquals(1, flight.getFlightNumber());
    }

    @Test
    public void getDestination() {
        assertEquals(AirportType.EDINBURGH, flight.getDestination());
    }
}
