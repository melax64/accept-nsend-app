package payment;

public class QRISPayment implements PaymentStrategy {

    @Override
    public String getName() {
        return "QRIS";
    }

    @Override
    public double getAdminFee(double subtotal) {
        return 0;
    }

    @Override
    public double calculateTotal(double subtotal) {
        return subtotal + getAdminFee(subtotal);
    }
}