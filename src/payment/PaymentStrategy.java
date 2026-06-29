package payment;

public interface PaymentStrategy {
    String getName();
    double getAdminFee(double subtotal);
    double calculateTotal(double subtotal);

}