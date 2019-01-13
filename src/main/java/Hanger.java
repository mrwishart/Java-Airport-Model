import java.util.ArrayList;

public class Hanger {

    private int capacity;
    private ArrayList<Plane> planes;

    public Hanger(int capacity) {
        this.capacity = capacity;
        this.planes = new ArrayList<>();
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

        planes.add(plane);
    }

    public Plane removePlane(int index){
        return planes.remove(index);
    }

}
