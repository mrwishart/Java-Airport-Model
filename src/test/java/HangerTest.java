import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HangerTest {

    Hanger hanger;
    Plane plane, largePlane, smallPlane, mediumPlane;

    @Before
    public void setUp() {
        hanger = new Hanger(1, 5);
        plane = new Plane(PlaneType.BOEING737);
        largePlane = new Plane(PlaneType.SUPERPLANEMANYSEATS);
        smallPlane = new Plane(PlaneType.VERYSMALLPLANE);
        mediumPlane = new Plane(PlaneType.BOEING747);
    }


    @Test
    public void getHangerNumber() {
        assertEquals(1, hanger.getHangerNumber());
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
    public void addPlanesInOrder() {
        assertEquals(0, hanger.getPlanes().size());
        assertEquals(5, hanger.spacesAvailable());
        hanger.addPlane(mediumPlane);
        hanger.addPlane(largePlane);
        hanger.addPlane(smallPlane);
        hanger.addPlane(mediumPlane);
        assertEquals(4, hanger.getPlanes().size());
        assertEquals(1, hanger.spacesAvailable());
        assertEquals(smallPlane, hanger.getPlanes().get(0));
        assertEquals(mediumPlane, hanger.getPlanes().get(1));
        assertEquals(largePlane, hanger.getPlanes().get(3));
    }
}
