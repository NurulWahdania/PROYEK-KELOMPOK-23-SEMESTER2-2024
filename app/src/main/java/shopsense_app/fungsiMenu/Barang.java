package shopsense_app.fungsiMenu;

public class Barang {
    private String nama;
    private String harga;
    private String stok;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public Barang(String nama, String harga, String stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }


}

