// ini tuh abstract class nya dari unit (restoran dan pabrik)
package unit;

public abstract class Unit {
    protected String name;

    public Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // jenis pengolahannya (kukus / goreng kalo dari restoran, dan frozen kalo dari pabrik)
    public abstract String getPreparationType();
}
