package addon;

import java.util.ArrayList;
import java.util.List;
import menu.Menu;

public class ChiliOil extends DimsumDecorator {

    public ChiliOil(Menu menu) {
        super(menu);
    }

    @Override
    public String getName() {
        return menu.getName();
    }

    @Override
    public int getPrice() {
        return menu.getPrice() + 2000;
    }

    @Override
    public List<String> getAddons() {
        List<String> addons = new ArrayList<>(menu.getAddons());
        addons.add("Chili Oil");
        return addons;
    }
}