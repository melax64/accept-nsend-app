package unit;

public class Factory extends Unit {
    public Factory() {
        super("Pabrik");
    }

    // return cara pengolahan
    @Override
    public String getPreparationType() {
        return "Frozen";
    }
}
