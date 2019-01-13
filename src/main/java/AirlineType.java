public enum AirlineType {
    BRITISHAIRWAYS("British Airways"),
    THOMSON("Thomson Air"),
    KLM("KLM Royal Dutch Airlines"),
    EUROWINGS("Eurowings GmbH");

    private final String airlineName;

    AirlineType(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineName() {
        return airlineName;
    }
}
