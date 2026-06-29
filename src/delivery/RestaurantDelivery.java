package delivery;

public abstract class RestaurantDelivery implements DeliveryStrategy {
    protected String name;
    protected int pricePerKm;

    public RestaurantDelivery(String name, int pricePerKm) {
        this.name = name;
        this.pricePerKm = pricePerKm;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateCost(double distance) {
        return (int) (distance * pricePerKm);
    }
}
