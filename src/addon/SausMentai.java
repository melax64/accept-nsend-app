package addon;

import java.util.ArrayList;
import java.util.List;
import menu.Menu;

public class SausMentai extends DimsumDecorator {

    public SausMentai(Menu menu) {
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
        addons.add("Saus Mentai");
        return addons;
    }
}