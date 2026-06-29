package menu;

import java.util.ArrayList;
import java.util.List;

public abstract class Dimsum implements Menu {
    protected String name;
    protected int price;

    public Dimsum(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public List<String> getAddons() {
        return new ArrayList<>();
    }
}
