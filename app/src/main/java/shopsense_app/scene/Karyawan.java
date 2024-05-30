package shopsense_app.scene;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import shopsense_app.Data.DatabaseConnection2;

public class Karyawan {
    String nama;
    int id;
    String posisi;
    String tanggal;
    Stage stage;
    DatePicker datePicker; // Deklarasi DatePicker

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
        // Label nmToko = new Label(Home.namaToko);
        // nmToko.getStyleClass().add("tokok2");
        Line line = new Line();
        line.setStartY(0);
        line.setStartX(20);
        line.setEndY(20);
        line.setEndX(20);
        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        HBox lin2 = new HBox(line);
        HBox alll = new HBox(10, lin2);
        alll.setPadding(new Insets(30, 0, 0, 700));
        alll.setAlignment(Pos.CENTER);

        Label judul = new Label("Karyawan");
        judul.getStyleClass().add("judul2");

        Label nama = new Label("Nama");
        nama.getStyleClass().add("karyawan");
        nama.setPadding(new Insets(0, 0, 0, 20));
        TextField bNama = new TextField();
        bNama.getStyleClass().add("buton4");
        VBox nama1 = new VBox(nama, bNama);

        // Label id = new Label("ID Karyawan");
        // id.getStyleClass().add("karyawan");
        // id.setPadding(new Insets(0, 0, 0, 20));
        // TextField bKaryawan = new TextField();
        // bKaryawan.getStyleClass().add("buton4");
        // TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
        // String newText = change.getControlNewText();
        // if (newText.matches("\\d*")) {
        // return change;
        // }
        // return null;
        // });
        // bKaryawan.setTextFormatter(textFormatter);

        // VBox karyawan1 = new VBox(id, bKaryawan);

        Label posis = new Label("Posisi");
        posis.getStyleClass().add("karyawan");
        posis.setPadding(new Insets(0, 0, 0, 20));
        TextField bPosis = new TextField();
        bPosis.getStyleClass().add("buton4");
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
            // int idKaryawan = Integer.parseInt(bKaryawan.getText().trim());
            String posisiKaryawan = bPosis.getText().trim();
            LocalDate selectedDate = datePicker.getValue();
            String tanggalMasuk = selectedDate != null ? selectedDate.toString() : "";

            addKaryawan(namaKaryawan, posisiKaryawan, tanggalMasuk);
        });

        Button home = new Button("Home");
        home.getStyleClass().add("home");
        home.setOnAction(e -> {
            Home menu = new Home(stage);
            menu.show();
        });

        HBox home2 = new HBox(add);
        home2.setAlignment(Pos.CENTER);
        home2.setPadding(new Insets(40, 0, 0, 0));

        VBox gabung = new VBox(40, nama1, posisi1);
        VBox all1 = new VBox(judul, gabung);
        all1.setSpacing(50);
        HBox all = new HBox(20, all1);
        all.setPadding(new Insets(20));

        VBox gbg = new VBox(20, alll, all, tanggal1, home2); // Menambahkan tanggal1 di sini setelah all

        Label menu1 = new Label("MENU");
        menu1.getStyleClass().add("judul");
        menu1.setPadding(new Insets(0, 0, 0, 25));

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
        Button hasil = new Button("Cetak Hasil");
        hasil.getStyleClass().add("buton2");
        hasil.setOnAction(e -> {
            Hasil cetak = new Hasil(stage);
            cetak.show();
        });

        Rectangle with = new Rectangle(1000, 650);
        with.setFill(Color.web("#ffff"));
        with.getStyleClass().add("rectangle");
        with.setArcWidth(30);
        with.setArcHeight(30);

        HBox rewc = new HBox(with);
        rewc.setPadding(new Insets(20, 0, 0, 230));

        VBox fungsi = new VBox(keuangan, barang, karyawan, tranksaksi, hasil, home);
        fungsi.setSpacing(40);
        HBox menu2 = new HBox(menu1);

        VBox vbox = new VBox(menu2, fungsi);
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        HBox alldata = new HBox(120, vbox, gbg);

        StackPane pane = new StackPane(rewc, alldata);
        pane.getStyleClass().add("background2");
        pane.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public void addKaryawan(String nama, String posisi, String tanggal_masuk) {
        String sql = "INSERT INTO karyawan (nama, 'id karyawan', posisi, 'tanggal masuk') VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection2.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nama);
            // pstmt.setInt(2, id_karyawan);
            pstmt.setString(3, posisi);
            pstmt.setString(4, tanggal_masuk);

            pstmt.executeUpdate();
            System.out.println("Karyawan added successfully!");

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
