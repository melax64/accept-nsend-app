package delivery;

public abstract class FactoryDelivery implements DeliveryStrategy {

    protected String name;
    protected int pricePerKg;

    public FactoryDelivery(String name, int pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateCost(double weight) {
        return (int) (weight * pricePerKg);
    }

}