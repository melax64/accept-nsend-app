package unit;

public class Restaurant extends Unit {
    public Restaurant() {
        super("Restoran");
    }

    @Override
    public String getPreparationTypes() {
        return "Kukus / Goreng";
    } 
}
