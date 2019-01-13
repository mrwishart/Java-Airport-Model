import java.util.ArrayList;

public class Flight {

    private Plane plane;
    private int flightNumber;
    private AirportType destination;
    private ArrayList<Passenger> ticketsSold;
    private Boolean sellingTickets;

    public Flight(int flightNumber, AirportType destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.ticketsSold = new ArrayList<>();
        this.sellingTickets = true;

    }

    public Plane getPlane() {
        return plane;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public AirportType getDestination() {
        return destination;
    }

    public ArrayList<Passenger> getTicketsSold() {
        return ticketsSold;
    }

    public void sellTicket(Passenger passenger){
        if (!this.sellingTickets) {return;}

        if (this.plane == null){
            ticketsSold.add(passenger);
        } else {
            plane.addPassenger(passenger);
        }
    }

    public void assignPlane(Plane plane){
        this.plane = plane;
        addTicketHoldersToPlane(this.plane);
        clearTicketsSold();

    }

    public void addTicketHoldersToPlane(Plane plane){
        for (Passenger passenger: this.ticketsSold) {
            plane.addPassenger(passenger);
        }
    }

    public void stopSelling(){
        sellingTickets = false;
    }

    public void clearTicketsSold(){
        this.ticketsSold.clear();
    }

    public int noOfPassengers(){
        if (this.plane == null){
            return ticketsSold.size();
        } else {
            return plane.getPassengers().size();
        }
    }
}
