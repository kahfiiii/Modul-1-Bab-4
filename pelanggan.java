import java.text.DecimalFormat;

public class pelanggan {
    private String nama;
    private String noPelanggan;
    private long saldo;
    private String pin;
    private int kesempatanLogin = 3;
    private boolean isBlocked = false;

    private DecimalFormat df = new DecimalFormat("#,###"); //merapikan output angka

    public pelanggan(String nama, String noPelanggan, long saldo, String pin) {
        this.nama = nama;
        this.noPelanggan = noPelanggan;
        this.saldo = saldo;
        this.pin = pin;
    }

    public String getNama() {
        return nama;
    }

    public long getSaldo() {
        return saldo;
    }

    // 🔐 Autentikasi PIN
    private boolean autentikasi(String inputPin) {
        if (isBlocked) {
            System.out.println("Akun diblokir!");
            return false;
        }

        if (pin.equals(inputPin)) {
            kesempatanLogin = 3;
            return true;
        } else {
            kesempatanLogin--;
            System.out.println("PIN salah! Sisa percobaan: " + kesempatanLogin);

            if (kesempatanLogin == 0) {
                isBlocked = true;
                System.out.println("Akun diblokir!");
            }
            return false;
        }
    }

    // 💰 Top Up
    public void topUp(long jumlah, String inputPin) {
        if (!autentikasi(inputPin)) return;

        saldo += jumlah;

        System.out.println("\n=== TOP UP BERHASIL ===");
        System.out.println("Jumlah Top Up : Rp" + df.format(jumlah));
        System.out.println("Saldo Sekarang: Rp" + df.format(saldo));
        System.out.println("========================\n");
    }

    // 🛒 Pembelian
    public void beli(long jumlah, String inputPin) {
        if (!autentikasi(inputPin)) return;

        long cashback = hitungCashback(jumlah);
        long totalBayar = jumlah - cashback;

        if ((saldo - totalBayar) < 10000) {
            System.out.println("Transaksi gagal, Saldo minimal Rp10.000 harus tersisa.");
            return;
        }

        saldo -= totalBayar;
        saldo += cashback;

        System.out.println("\n=== STRUK PEMBELIAN ===");
        System.out.println("Nama          : " + nama);
        System.out.println("No Pelanggan  : " + noPelanggan);
        System.out.println("Total Belanja : Rp" + df.format(jumlah));
        System.out.println("Cashback      : Rp" + df.format(cashback));
        System.out.println("Total Bayar   : Rp" + df.format(totalBayar));
        System.out.println("Saldo Akhir   : Rp" + df.format(saldo));
        System.out.println("========================\n");
    }

    // 🎯 Hitung Cashback
    private long hitungCashback(long jumlah) {
        String kode = noPelanggan.substring(0, 2);

        if (kode.equals("38")) { // Silver
            if (jumlah > 1000000) return jumlah * 5 / 100;
            return 0;
        } 
        else if (kode.equals("56")) { // Gold
            if (jumlah > 1000000) return jumlah * 7 / 100;
            return jumlah * 2 / 100;
        } 
        else if (kode.equals("74")) { // Platinum
            if (jumlah > 1000000) return jumlah * 10 / 100;
            return jumlah * 5 / 100;
        }

        return 0;
    }
}