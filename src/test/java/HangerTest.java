import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HangerTest {

    Hanger hanger;
    Plane plane, largePlane, smallPlane, mediumPlane;

    @Before
    public void setUp() {
        hanger = new Hanger( 5);
        plane = new Plane(PlaneType.BOEING737, AirlineType.BRITISHAIRWAYS);
        largePlane = new Plane(PlaneType.SUPERPLANEMANYSEATS, AirlineType.BRITISHAIRWAYS);
        smallPlane = new Plane(PlaneType.VERYSMALLPLANE, AirlineType.BRITISHAIRWAYS);
        mediumPlane = new Plane(PlaneType.BOEING747, AirlineType.BRITISHAIRWAYS);
    }

    @Test
    public void getCapacity() {
        assertEquals(5, hanger.getCapacity());
    }

    @Test
    public void getPlanes__HangerInitiallyEmpty() {
        assertEquals(0, hanger.getPlanes().size());
    }

    @Test
    public void spacesAvailable__HangerInitiallEmpty() {
        assertEquals(5, hanger.spacesAvailable());
    }

    @Test
    public void canAddPlane() {
        assertEquals(0, hanger.getPlanes().size());
        assertEquals(5, hanger.spacesAvailable());
        hanger.addPlane(plane);
        assertEquals(1, hanger.getPlanes().size());
        assertEquals(4, hanger.spacesAvailable());
    }

    @Test
    public void cannotAddPlaneAboveCapacity() {
        assertEquals(0, hanger.getPlanes().size());
        assertEquals(5, hanger.spacesAvailable());
        for (int i = 0; i < 7; i++) {
            hanger.addPlane(plane);
        }
        assertEquals(5, hanger.getPlanes().size());
        assertEquals(0, hanger.spacesAvailable());
    }

    @Test
    public void removePlane() {
        hanger.addPlane(mediumPlane);
        hanger.addPlane(largePlane);
        hanger.addPlane(smallPlane);
        hanger.addPlane(mediumPlane);
        assertEquals(largePlane, hanger.removePlane(1));
        assertEquals(mediumPlane, hanger.removePlane(2));
    }
}
