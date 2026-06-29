package payment;

public class BankGwePayment implements PaymentStrategy {

    @Override
    public String getName() {
        return "BankGwe";
    }

    @Override
    public double getAdminFee(double subtotal) {
        return subtotal * 0.015;
    }

    @Override
    public double calculateTotal(double subtotal) {
        return subtotal + getAdminFee(subtotal);
    }

}