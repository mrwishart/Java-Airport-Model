import java.util.ArrayList;

public class Hanger {

    private int hangerNumber, capacity;
    private ArrayList<Plane> planes;

    public Hanger(int hangerNumber, int capacity) {
        this.hangerNumber = hangerNumber;
        this.capacity = capacity;
        this.planes = new ArrayList<>();
    }

    public int getHangerNumber() {
        return hangerNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int spacesAvailable() {
        return capacity - planes.size();
    }

    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public void addPlane(Plane plane) {
        if (spacesAvailable() == 0){
           return;
        }

        int hangerIndex;

        if (planes.isEmpty()){
            hangerIndex = 0;
        } else {
            hangerIndex = findPlaceInHanger(plane);
        }

        planes.add(hangerIndex, plane);
    }

    private int findPlaceInHanger(Plane plane) {

        for (int i = 0; i < planes.size(); i++) {

            if (planes.get(i).getCapacity() > plane.getCapacity()){
                return i;
            }
        }

        return planes.size();
    }
}
