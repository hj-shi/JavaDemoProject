package enumerated;

public enum OzWitch {
    WEST("the Sun sunk"),
    NORTH("the direction where The Big Dipper points "),
    EAST("the Sun arise from"),
    SOUTH("where the temperature is above 20 all the year round");
    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch: OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }
}
