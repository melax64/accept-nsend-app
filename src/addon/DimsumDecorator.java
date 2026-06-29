package addon;

import java.util.ArrayList;
import java.util.List;
import menu.Menu;

public abstract class DimsumDecorator implements Menu {

    protected Menu menu;

    public DimsumDecorator(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String getName() {
        return menu.getName();
    }

    @Override
    public int getPrice() {
        return menu.getPrice();
    }

    @Override
    public List<String> getAddons() {
        return new ArrayList<>();
    }
}