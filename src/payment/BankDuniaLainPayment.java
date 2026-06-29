package payment;

public class BankDuniaLainPayment implements PaymentStrategy {

    @Override
    public String getName() {
        return "Bank Dunia Lain";
    }

    @Override
    public double getAdminFee(double subtotal) {
        return 0.15;
    }

    @Override
    public double calculateTotal(double subtotal) {
        return subtotal + getAdminFee(subtotal);
    }
}