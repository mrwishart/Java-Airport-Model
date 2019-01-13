import java.util.ArrayList;

public class Plane {

    private PlaneType type;
    private ArrayList<Passenger> passengers;
    private AirlineType airline;


    public Plane(PlaneType type, AirlineType airline) {
        this.type = type;
        this.airline = airline;
        this.passengers = new ArrayList<>();
    }

    public PlaneType getType() {
        return type;
    }

    public ArrayList<Passenger> getPassengers() {
       return passengers;
    }

    public AirlineType getAirline() {
        return airline;
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
