package delivery;

public interface DeliveryStrategy {
    String getName();

    // tipe data double untuk jarak dan berat
    int calculateCost(double value);
}
