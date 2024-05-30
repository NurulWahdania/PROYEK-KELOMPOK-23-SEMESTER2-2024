package shopsense_app.scene;

public class TransaksiClass {
    private int harga;
    private String waktu;
    public TransaksiClass(int harga, String waktu, String nama_karyawan) {
        this.harga = harga;
        this.waktu = waktu;
        this.nama_karyawan = nama_karyawan;
    }

    private String nama_karyawan;

    public TransaksiClass(int harga, String waktu) {
        this.harga = harga;
        this.waktu = waktu;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }


    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }
}
