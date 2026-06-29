package unit;

public class Restaurant extends Unit {
    public Restaurant() {
        super("Restoran");
    }

    // return cara pengolahan
    @Override
    public String getPreparationType() {
        return "Kukus / Goreng";
    }
}
