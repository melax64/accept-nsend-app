import addon.*;
import delivery.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import menu.*;
import order.Order;
import payment.*;
import unit.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
        // ===========================
        // UNIT
        // ===========================

        System.out.println("===== ACCEPT'NSEND =====");
        System.out.println("Pilih Unit");
        System.out.println("1. Restoran");
        System.out.println("2. Pabrik");
        System.out.print("Pilihan : ");

        int unitChoice = input.nextInt();

        Unit unit;

        if (unitChoice == 1)
            unit = new Restaurant();
        else
            unit = new Factory();

        // ===========================
        // MENU
        // ===========================

        System.out.println("\nPilih Menu");
        System.out.println("1. Dimsum Ayam");
        System.out.println("2. Dimsum Udang");
        System.out.println("3. Dimsum Ayam-Udang");
        System.out.print("Pilihan : ");

        int menuChoice = input.nextInt();

        Menu menu;

        switch (menuChoice) {

            case 1:
                menu = new DimsumAyam();
                break;

            case 2:
                menu = new DimsumUdang();
                break;

            case 3:
                menu = new DimsumAyamUdang();
                break;

            default:
                System.out.println("Menu tidak tersedia. Program dihentikan.");
                return;
        }

        System.out.print("\nJumlah Item : ");
        int quantity = input.nextInt();

        if (quantity <= 0) {
            System.out.println("Jumlah item harus lebih dari 0. Program dihentikan.");
            return;
        }

        int addonCount = 0;
        for (int i = 0; i < 3; i++) {

            System.out.println("\nPilih Add-on");
            System.out.println("1. Saus Mentai");
            System.out.println("2. Chili Oil");
            System.out.println("3. Kecap Asin + Minyak Wijen");
            System.out.println("0. Selesai");

            int addon = input.nextInt();

            if (addon == 0)
                break;

            switch (addon) {

                case 1:
                    if (++addonCount > 3) {
                        System.out.println("Maksimum 3 add-on. Program dihentikan.");
                        return;
                    }
                    menu = new SausMentai(menu);
                    break;

                case 2:
                    if (++addonCount > 3) {
                        System.out.println("Maksimum 3 add-on. Program dihentikan.");
                        return;
                    }
                    menu = new ChiliOil(menu);
                    break;

                case 3:
                    if (++addonCount > 3) {
                        System.out.println("Maksimum 3 add-on. Program dihentikan.");
                        return;
                    }
                    menu = new KecapAsinMinyakWijen(menu);
                    break;

                default:
                    System.out.println("Pilihan add-on tidak valid, coba lagi.");
                    i--; // ulang iterasi tanpa menghitung ke dalam batas 3
                    break;
            }
        }    

        DeliveryStrategy delivery;
        double value;

        if (unit instanceof Restaurant) {

            System.out.println("\nDelivery");
            System.out.println("1. Sepeda");
            System.out.println("2. Motor Listrik");
            System.out.println("3. Mobil Box Listrik");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    delivery = new BikeDelivery();
                    break;
                case 2:
                    delivery = new ElectricMotorDelivery();
                    break;
                default:
                    delivery = new ElectricBoxCarDelivery();
            }

            System.out.print("Jarak (km) : ");
            value = input.nextDouble();

        } else {

            System.out.println("\nDelivery");
            System.out.println("1. Pulau yang Sama");
            System.out.println("2. Beda Pulau");
            System.out.println("3. Dunia Lain");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    delivery = new SameIslandDelivery();
                    break;
                case 2:
                    delivery = new DifferentIslandDelivery();
                    break;
                default:
                    delivery = new OtherWorldDelivery();
            }

            System.out.print("Berat (kg) : ");
            value = input.nextDouble();

        }

        System.out.println("\nMetode Pembayaran");
        System.out.println("1. Cash");
        System.out.println("2. QRIS");
        System.out.println("3. BankGwe");
        System.out.println("4. BankDuniaLain");

        int paymentChoice = input.nextInt();

        PaymentStrategy payment;

        switch (paymentChoice) {

            case 1:
                payment = new CashPayment();
                break;

            case 2:
                payment = new QRISPayment();
                break;

            case 3:
                payment = new BankGwePayment();
                break;

            case 4:
                payment = new BankDuniaLainPayment();
                break;
            default:
                System.out.println("Metode pembayaran tidak tersedia. Program dihentikan.");
                return;
        }

        Order order = new Order(
            unit,
            menu,
            quantity,
            value,
            delivery,
            payment
        );

        // Cetak struk
        System.out.println("\n===== STRUK PESANAN =====");
        System.out.println("Unit: " + order.getUnit().getName());
        System.out.println("Menu: " + order.getMenu().getName());
        java.util.List<String> addons = order.getMenu().getAddons();
        if (addons != null && !addons.isEmpty())
            System.out.println("Add-ons: " + String.join(", ", addons));
        else
            System.out.println("Add-ons: -");
        System.out.println("Jumlah: " + order.getQuantity());
        System.out.println("Subtotal: " + order.getSubtotal());
        System.out.println("Delivery (" + order.getDelivery().getName() + "): " + order.getDeliveryCost());
        System.out.println("Metode Pembayaran: " + order.getPayment().getName());
        System.out.println("Biaya Admin: " + order.getAdminFee());
        System.out.println("Grand Total: " + order.getGrandTotal());

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Program dihentikan.");
        } finally {
            input.close();
        }
    }
}