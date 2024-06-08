package shopsense_app.scene;

import javafx.stage.Stage;
import java.sql.ResultSet;
import javafx.scene.Scene;
import java.sql.Connection;
import javafx.geometry.Pos;
import java.time.LocalDate;
import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import java.sql.PreparedStatement;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shopsense_app.Data.DatabaseConnection2;

public class Karyawan extends KaryawanAbstrak {
    public Karyawan(Stage stage) {
        this.stage = stage;
    }

    public Karyawan(){

    }

    public Karyawan(String nama, int id, String posisi, String tanggal) {
        this.nama = nama;
        this.id = id;
        this.posisi = posisi;
        this.tanggal = tanggal;
    }

    public void show() {
        Label judul = new Label("Karyawan");
        judul.getStyleClass().add("judul2");

        Label nama = new Label("Nama");
        nama.getStyleClass().add("karyawan");
        nama.setPadding(new Insets(0, 0, 0, 20));
        TextField bNama = new TextField();
        bNama.getStyleClass().add("buton4");
        VBox nama1 = new VBox(nama, bNama);

        Label posis = new Label("Posisi");
        posis.getStyleClass().add("karyawan");
        posis.setPadding(new Insets(0, 0, 0, 20));
        TextField bPosis = new TextField();
        bPosis.getStyleClass().add("buton4");
        // ComboBox<Karyawan> posisiBox = new ComboBox<Karyawan>();
        VBox posisi1 = new VBox(posis, bPosis);

        Label tanggal = new Label("Tanggal Masuk");
        tanggal.getStyleClass().add("karyawan");
        tanggal.setPadding(new Insets(0, 0, 0, 20));
        datePicker = new DatePicker();
        datePicker.setId("datepick");
        VBox tanggal1 = new VBox(tanggal, datePicker);
        tanggal1.setPadding(new Insets(10, 0, 0, 20));

        Button add = new Button("Add");
        add.getStyleClass().add("home2");
        add.setPrefSize(80, 0);
        add.setOnAction(e -> {
            String namaKaryawan = bNama.getText().trim();
            String posisiKaryawan = bPosis.getText().trim();
            LocalDate selectedDate = datePicker.getValue();
            String tanggalMasuk = selectedDate != null ? selectedDate.toString() : "";
            
            addKaryawan(namaKaryawan, posisiKaryawan, tanggalMasuk);
            bNama.clear();
            bPosis.clear();
            datePicker.setValue(null);
        });

        Label idKaryawan = new Label("Pilih Id");
        idKaryawan.getStyleClass().add("textid2");
        ComboBox<Karyawan> idBox = new ComboBox<>();
        idBox.getStyleClass().add("textid");
        idBox.setCellFactory(param -> new ListCell<Karyawan>(){
        //    @Override
            public void updateItem (Karyawan item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getId() +" - " + item.getNama());
                }
            }
        });
        idBox.setButtonCell(new ListCell<Karyawan>(){

            public void updateItem(Karyawan item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getId() +" - " + item.getNama());
                }
            }
        });

        idBox.setOnMouseClicked((MouseEvent event)-> {
            ObservableList<Karyawan> karyawanList = selectAll();
            idBox.setItems(karyawanList);
        });

        Button delet  = new Button("Delete");
        delet.getStyleClass().add("textid3");
        delet.setPrefSize(80, 0);
        delet.setOnAction(e -> {
            Karyawan pilihId = idBox.getValue();
            if (pilihId != null) {
                int idkaryawan = pilihId.getId();
                deleteKaryawan(idkaryawan);
                idBox.setValue(null);
            }
        });

        HBox deleteBox = new HBox(delet);
        deleteBox.setAlignment(Pos.CENTER);
        deleteBox.setAlignment(Pos.CENTER);

        VBox hapus = new VBox(5,idBox, deleteBox);
        hapus.setPadding(new Insets(250, 0, 0, 40));

        HBox adBox = new HBox(add);
        adBox.setAlignment(Pos.CENTER);
        adBox.setPadding(new Insets(20, 0, 0,0));
        HBox yo = new HBox(hapus);

        VBox gabung = new VBox(40, nama1, posisi1);
        VBox all1 = new VBox(judul, gabung);
        all1.setSpacing(50);
        HBox all = new HBox(20, all1);
        all.setPadding(new Insets(20));

        VBox gbb = new VBox(20, all,tanggal1,adBox); 
        HBox gbg = new HBox(gbb, yo);
        gbg.setPadding(new Insets(0,0,0,100));

        Label menu1 = new Label("SHOP SENSE");
        menu1.getStyleClass().add("judulhom");
        menu1.setPadding(new Insets(0,0,0,15));

        Button keuangan = new Button("Laporan Toko");
        keuangan.getStyleClass().add("buton2");
        keuangan.setOnAction(e -> {
            LaporanToko uang = new LaporanToko(stage);
            uang.show();
        });
        Button barang = new Button("Barang");
        barang.getStyleClass().add("buton2");
        barang.setOnAction(e -> {
            Barang brg = new Barang(stage);
            brg.show();
        });
        Button karyawan = new Button("Karyawan");
        karyawan.getStyleClass().add("buton2");
        karyawan.setOnAction(e -> {
            Karyawan kar = new Karyawan(stage);
            kar.show();
        });
        Button tranksaksi = new Button("Transaksi");
        tranksaksi.getStyleClass().add("buton2");
        tranksaksi.setOnAction(e -> {
            Tranksaksi kasir = new Tranksaksi(stage);
            kasir.show();
        });
        Button hasil = new Button("Histori");
        hasil.getStyleClass().add("buton2");
        hasil.setOnAction(e -> {
            Hasil cetak = new Hasil(stage);
            cetak.show();
        });

        Button home = new Button("Home");
        home.getStyleClass().add("buton2");
        home.setOnAction(e -> {
            Menuisi pane = new Menuisi(stage);
            pane.show();
        });

        Rectangle with = new Rectangle(1040, 610);
        with.setFill(Color.web("#ffff"));
        with.getStyleClass().add("rectangle");
        with.setArcWidth(30);
        with.setArcHeight(30);

        HBox rewc = new HBox(with);
        rewc.setPadding(new Insets(20, 0, 0, 230));

        VBox fungsi = new VBox(home,keuangan, barang, karyawan, tranksaksi, hasil);
        fungsi.setSpacing(40);
        HBox menu2 = new HBox(menu1);

        VBox vbox = new VBox(menu2, fungsi);
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        HBox alldata = new HBox(80, vbox, gbg);

        StackPane pane = new StackPane(rewc, alldata);
        pane.getStyleClass().add("background2");
        pane.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        Scene scene = new Scene(pane,1290, 650);
        stage.setScene(scene);
        stage.show();
    }

    public void addKaryawan(String nama, String posisi, String tanggal_masuk) {
        String sql = "INSERT INTO karyawan (nama, 'id karyawan', posisi, 'tanggal masuk') VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection2.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nama);
            pstmt.setString(3, posisi);
            pstmt.setString(4, tanggal_masuk);

            pstmt.executeUpdate();
            System.out.println("Karyawan added successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteKaryawan(int id) {
        String sql = "DELETE FROM karyawan WHERE \"id karyawan\" = ?";

        try (Connection conn = DatabaseConnection2.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Karyawan deleted successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ObservableList<Karyawan> selectAll() {
        String sql = "SELECT nama, \"id karyawan\", posisi, \"tanggal masuk\" FROM karyawan";
        ObservableList<Karyawan> data = FXCollections.observableArrayList();
        try (Connection conn = DatabaseConnection2.connect();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Karyawan karyawan = new Karyawan(
                    rs.getString("nama"),
                    rs.getInt("id karyawan"),
                    rs.getString("posisi"),
                    rs.getString("tanggal masuk")
                );
                data.add(karyawan);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
