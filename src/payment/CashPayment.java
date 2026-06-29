package payment;

public class CashPayment implements PaymentStrategy {

    @Override
    public String getName() {
        return "Cash";
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