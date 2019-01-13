import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;
    AirportType airportCode;

    @Before
    public void beforeEach(){
        airportCode = AirportType.EDINBURGH;
        airport = new Airport(airportCode);
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
}
