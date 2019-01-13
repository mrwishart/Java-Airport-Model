import java.util.ArrayList;

public class Plane {

    private PlaneType type;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType type) {
        this.type = type;
        this.passengers = new ArrayList<>();
    }

    public PlaneType getType() {
        return type;
    }

    public ArrayList<Passenger> getPassengers() {
        ArrayList<Passenger> passengersClone = (ArrayList<Passenger>) passengers.clone();
        return passengersClone;
    }

    public String getTypeName(){
        return type.getPlaneName();
    }

    public int getCapacity(){
        return type.getCapacity();
    }

    public int remainingSeats(){
        return getCapacity() - passengers.size();
    }

    public void addPassenger(Passenger passenger){
        if (remainingSeats() > 0){
            passengers.add(passenger);
        }
    }

    public void emptyPlane(){
        passengers.clear();
    }
}
