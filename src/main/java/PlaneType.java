public enum PlaneType {
    BOEING747("Boeing 747", 50),
    BOEING737("Boeing 737", 55),
    VERYSMALLPLANE("Very Small Plane", 2),
    SUPERPLANEMANYSEATS("Very Large Plane", 500);

    private final String planeName;
    private final int capacity;

    PlaneType(String planeName, int capacity) {
        this.capacity = capacity;
        this.planeName = planeName;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getPlaneName() {
        return planeName;
    }
}
