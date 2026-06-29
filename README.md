# Accept'nSend App

Accept'nSend adalah aplikasi simulasi pemesanan dimsum berbasis Java yang dikembangkan sebagai Final Project mata kuliah **Praktikum Design Pattern**. Aplikasi ini menerapkan beberapa konsep Object-Oriented Programming (OOP), Design Pattern, dan prinsip SOLID untuk menghasilkan kode yang lebih terstruktur, mudah dikembangkan, dan mudah dipelihara.

## Features

* Memilih unit pemesanan (Restaurant atau Factory)
* Memilih menu dimsum

  * Dimsum Ayam
  * Dimsum Udang
  * Dimsum Ayam-Udang
* Menambahkan add-on

  * Saus Mentai
  * Chili Oil
  * Kecap Asin + Minyak Wijen
* Memilih jenis penyajian

  * Restaurant: Goreng atau Kukus
  * Factory: Frozen
* Memilih metode delivery
* Memilih metode pembayaran
* Menghitung subtotal, biaya delivery, biaya admin, dan total pembayaran

## Design Pattern

Project ini menerapkan dua Design Pattern utama:

### Decorator Pattern

Digunakan untuk menambahkan add-on pada menu tanpa mengubah objek menu asli.

**Component**

* Menu

**Concrete Component**

* DimsumAyam
* DimsumUdang
* DimsumAyamUdang

**Decorator**

* DimsumDecorator

**Concrete Decorator**

* MentaiDecorator
* ChiliOilDecorator
* KecapAsinMinyakWijenDecorator

---

### Strategy Pattern

Digunakan pada proses perhitungan biaya delivery dan pembayaran.

#### Delivery Strategy

* BikeDelivery
* ElectricMotorDelivery
* ElectricBoxCarDelivery
* SameIslandDelivery
* DifferentIslandDelivery
* OtherWorldDelivery

#### Payment Strategy

* CashPayment
* QRISPayment
* BankGwePayment
* BankDuniaLainPayment

## Project Structure

```text
src/
│
├── addon/
├── common/
├── delivery/
├── menu/
├── order/
├── payment/
├── unit/
│
└── Main.java
```

## Technologies

* Java
* Visual Studio Code
* Git
* GitHub

## How to Run

1. Clone repository

```bash
git clone https://github.com/<username>/accept-nsend-app.git
```

2. Masuk ke folder project

```bash
cd accept-nsend-app
```

3. Compile

```bash
javac -d bin src/**/*.java
```

4. Jalankan program

```bash
java -cp bin Main
```

## SOLID Principles

Project ini menerapkan prinsip-prinsip SOLID sebagai berikut:

* **Single Responsibility Principle (SRP)** — Setiap class memiliki satu tanggung jawab utama.
* **Open/Closed Principle (OCP)** — Penambahan metode delivery atau pembayaran dapat dilakukan tanpa mengubah kode yang sudah ada.
* **Liskov Substitution Principle (LSP)** — Seluruh implementasi Strategy dapat saling menggantikan.
* **Interface Segregation Principle (ISP)** — Interface dibuat sesuai kebutuhan masing-masing komponen.
* **Dependency Inversion Principle (DIP)** — Class `Order` bergantung pada abstraksi (`Menu`, `DeliveryStrategy`, dan `PaymentStrategy`), bukan implementasi konkret.

## Team

Final Project Praktikum Design Pattern

Kelompok:

* Muhammad Fathurrahman
* Maila Aziza
* Faqriyadi Andika

---

© 2026 Accept'nSend Project
