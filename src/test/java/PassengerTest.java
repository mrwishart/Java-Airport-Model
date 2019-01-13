import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void setUp() {
        passenger = new Passenger("Bob");
    }


    @Test
    public void getName() {
        assertEquals("Bob", passenger.getName());
    }
}
