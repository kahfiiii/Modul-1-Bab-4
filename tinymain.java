public class tinymain {
    public static void main(String[] args) {

        pelanggan p1 = new pelanggan(
            "Kholiq", 
            "5612345678", // gold
            2000000, 
            "1234"
        );

        // top Up
        p1.topUp(500000, "1234");

        // pembelian > 1jt (cashback 7%)
        p1.beli(1500000, "1234");

        // tes salah pin
        p1.beli(100000, "0000");
        p1.beli(100000, "0000");
        p1.beli(100000, "0000"); // akun keblokir
    }
}