# Tugas Praktikum Pemrograman Lanjut

## Modul 4 – Encapsulation

### Deskripsi

Program ini merupakan implementasi konsep **Encapsulation (Enkapsulasi)** dalam pemrograman Java dengan studi kasus sistem transaksi pada swalayan **Tiny**.  

Sistem ini dirancang untuk mengelola data pelanggan secara aman dengan menerapkan prinsip **information hiding**, dimana atribut tidak dapat diakses langsung dan hanya bisa dioperasikan melalui method tertentu.

---

### Fitur yang Diimplementasikan

1. Sistem **autentikasi menggunakan PIN** untuk setiap transaksi.
2. Fitur **top up saldo** dengan validasi keamanan.
3. Fitur **pembelian barang** dengan perhitungan cashback.
4. Sistem **blokir akun otomatis** setelah 3 kali kesalahan PIN.
5. Penerapan **minimum saldo Rp10.000** setelah transaksi.
6. Perhitungan **cashback berdasarkan jenis pelanggan**:
   - **Silver (38)** → 5% jika pembelian > 1 juta
   - **Gold (56)** → 7% (>1 juta), 2% (≤1 juta)
   - **Platinum (74)** → 10% (>1 juta), 5% (≤1 juta)
7. Implementasi **encapsulation penuh** (atribut private + method akses).

---

### Struktur Program

* **Pelanggan.java** → class utama yang berisi atribut, method transaksi, autentikasi, dan perhitungan cashback.
* **Main.java** → class utama untuk menjalankan program dan simulasi transaksi.

---

### Teknologi

* Bahasa Pemrograman: **Java**
* Konsep:
  * **Encapsulation (Enkapsulasi)**
  * **Information Hiding**
  * **Accessor & Mutator (Getter & Method)**
  * **Object Oriented Programming (OOP)**

---

