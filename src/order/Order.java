package order;

import delivery.DeliveryStrategy;
import menu.Menu;
import payment.PaymentStrategy;
import unit.Unit;

public class Order {
    private Unit unit;
    private Menu menu;
    private int quantity;
    private double deliveryValue; // km untuk restoran, kg untuk pabrik
    private DeliveryStrategy delivery;
    private PaymentStrategy payment;

    public Order(Unit unit, Menu menu, int quantity,
                 double deliveryValue,
                 DeliveryStrategy delivery,
                 PaymentStrategy payment) {

        this.unit = unit;
        this.menu = menu;
        this.quantity = quantity;
        this.deliveryValue = deliveryValue;
        this.delivery = delivery;
        this.payment = payment;
    }

    // ==========================
    // Getter
    // ==========================

    public Unit getUnit() {
        return unit;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public DeliveryStrategy getDelivery() {
        return delivery;
    }

    public PaymentStrategy getPayment() {
        return payment;
    }

    // ==========================
    // Perhitungan
    // ==========================

    public double getSubtotal() {
        return menu.getPrice() * quantity;
    }

    public double getDeliveryCost() {
        return delivery.calculateCost(deliveryValue);
    }

    public double getTotalBeforeAdmin() {
        return getSubtotal() + getDeliveryCost();
    }

    public double getAdminFee() {
        return payment.getAdminFee(getTotalBeforeAdmin());
    }

    public double getGrandTotal() {
        return payment.calculateTotal(getTotalBeforeAdmin());
    }

}