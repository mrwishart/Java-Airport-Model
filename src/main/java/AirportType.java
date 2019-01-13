public enum AirportType {
    GLASGOW("GLA"),
    PRESTWICK("PIK"),
    EDINBURGH("EDI"),
    HEATHROW("LHR"),
    GATWICK("LGW");

    private final String code;

    AirportType(String code) {this.code = code;}

    public String getCode() {
        return code;
    }
}
