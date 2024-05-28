package shopsense_app.scene;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// import javafx.scene.control.TableView;
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
    String nama ;
    int id;
    String posisi;
    String tanggal;
    Stage stage;
    public Karyawan(Stage stage){
        this.stage = stage;
    }
    public Karyawan(String nama, int id, String posisi, String tanggal) {
        this.nama = nama;
        this.id = id;
        this.posisi = posisi;
        this.tanggal = tanggal;
    }

    public void  show(){

       Label nmToko = new Label(Home.namaToko);
        nmToko.getStyleClass().add("tokok2");
        Line line = new Line();
        line.setStartY(0);
        line.setStartX(20);
        line.setEndY(20);
        line.setEndX(20);
        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        HBox lin2 = new HBox(line);
        HBox alll = new HBox(10, lin2, nmToko);
        alll.setPadding(new Insets(30,0,0,700));
        alll.setAlignment(Pos.CENTER);
        // alll.setPadding(new Insets(10,0,0,20));



        Label judul = new Label("Karyawan");
        judul.getStyleClass().add("judul2");

        Label nama = new Label("Nama");
        nama.getStyleClass().add("karyawan");
        nama.setPadding(new Insets(0, 0, 0, 20));
        TextField bNama = new TextField();
        bNama.getStyleClass().add("buton4");
        VBox nama1 = new VBox(nama,bNama);
        
        Label id = new Label("ID Karyawan");
        id.getStyleClass().add("karyawan");
        id.setPadding(new Insets(0, 0, 0, 20));
        TextField bKaryawan = new TextField();
        bKaryawan.getStyleClass().add("buton4");
        TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
                    String newText = change.getControlNewText();
                    if (newText.matches("\\d*")) {
                        return change;
                    }
                    return null;
                });
                bKaryawan.setTextFormatter(textFormatter);

        VBox karyawan1 = new VBox(id, bKaryawan);

        Label posis = new Label("Posis");
        posis.getStyleClass().add("karyawan");
        posis.setPadding(new Insets(0, 0, 0, 20));
        TextField bPosis = new TextField();
        bPosis.getStyleClass().add("buton4");
        VBox posisi1 = new VBox(posis, bPosis);
        Label tanggal = new Label("Tanggal Masuk");
        tanggal.getStyleClass().add("karyawan");
        tanggal.setPadding(new Insets(0, 0, 0, 20));
        TextField bTanggal = new TextField();
        bTanggal.getStyleClass().add("buton4");

        VBox tanggal1 = new VBox(tanggal, bTanggal);

        // Button foto = new Button("FOTO");
        // foto.getStyleClass().add("foto");
        // foto.setMinSize(0, 200);

        Button add = new Button("Add");
        add.getStyleClass().add("home2");
        add.setPrefSize(80, 0);
        add.setOnAction(e -> {
            String namaKaryawan = bNama.getText();
            int idKaryawan = Integer.parseInt(bKaryawan.getText());
            String posisiKaryawan = bPosis.getText();
            String tanggalMasuk = (bTanggal.getText());

            addKaryawan(namaKaryawan, idKaryawan, posisiKaryawan, tanggalMasuk);
        });


        Button home = new Button("Home");
        home.getStyleClass().add("home2");
        home.setOnAction(e -> {
            Home menu = new Home(stage);
            menu.show();
        });
        HBox home2 = new HBox(10, add,home);
        home2.setAlignment(Pos.CENTER);
        home2.setPadding(new Insets(150,0,0,0));

        VBox all2 = new VBox(20, home2);
        all2.setAlignment(Pos.CENTER);
        all2.setPadding(new Insets(10, 0, 0, 100));

        VBox gabung = new VBox(40,nama1, karyawan1, posisi1, tanggal1);
        VBox all1 = new VBox( judul, gabung);
        all1. setSpacing(50);
        HBox all = new HBox(20,all1, all2);
        all.setPadding(new Insets(20));
    
        VBox gbg = new VBox(alll, all);
    
        Label menu1 = new Label("MENU");
        menu1.getStyleClass().add("judul");
        menu1.setPadding(new Insets(0,0,0,25));

        Button keuangan = new Button("Laporan Keuangan");
        keuangan.getStyleClass().add("buton2");
        keuangan.setOnAction(e -> {
            Keuangan uang = new Keuangan(stage);
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
        with.setArcWidth(30); // Mengatur lebar sudut
        with.setArcHeight(30);

        HBox rewc = new HBox(with);
        rewc.setPadding(new Insets(20,0,0,230));

        // HBox home2 = new HBox(home);
        // home2.setAlignment(Pos.BOTTOM_RIGHT);
        VBox fungsi = new VBox(keuangan, barang, karyawan, tranksaksi, hasil);
        fungsi.setSpacing(40);
        HBox menu2 = new HBox(menu1);

        VBox vbox = new VBox(menu2, fungsi);
        
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10,10,10,10));

        HBox alldata = new HBox(120, vbox, gbg);
 
        StackPane pane = new StackPane(rewc, alldata);
        pane.getStyleClass().add("background2");
        pane.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        // StackPane.setMargin(nstore, new Insets(-540, 0, 0, -720));

        // pane.setPadding(new Insets(40));

        Scene scene = new Scene(pane);
        stage.setScene(scene); 
        // stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }
    public void addKaryawan(String nama, int id_karyawan, String posisi, String tanggal_masuk) {
        String sql = "INSERT INTO karyawan (nama, 'id karyawan', posisi, 'tanggal masuk') VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection2.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nama);
            pstmt.setInt(2, id_karyawan);
            pstmt.setString(3, posisi);
            pstmt.setString(4, tanggal_masuk);

            pstmt.executeUpdate();
            System.out.println("Karyawan added successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

