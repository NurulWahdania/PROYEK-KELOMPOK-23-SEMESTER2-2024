package shopsense_app.fungsiMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
<<<<<<< HEAD
// import javafx.scene.control.TableView;
=======
import javafx.scene.control.TableView;
>>>>>>> a29ef94c755ff97e566de0a44b2786b7fd4813c1
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shopsense_app.Data.DatabaseConnection2;
// import shopsense_app.fungsi1.DataProvider;
// import shopsense_app.fungsi1.KaryawanController;
import shopsense_app.scenes.Menuisi;

public class Karyawan {
    String nama ;
    int id;
    String posisi;
    int tanggal;
    Stage stage;

    public Karyawan(Stage stage){
        this.stage = stage;
    }

    public Karyawan(String nama, int id, String posisi, int tanggal) {
        this.nama = nama;
        this.id = id;
        this.posisi = posisi;
        this.tanggal = tanggal;
    }

    public void  show(){



        Label judul = new Label("Karyawan");
        judul.getStyleClass().add("judul2");

        Label nama = new Label("Nama");
        nama.getStyleClass().add("karyawan");
        nama.setPadding(new Insets(0, 0, 0, 20));
        TextField bNama = new TextField();
        bNama.getStyleClass().add("buton4");

        VBox nama1 = new VBox(nama,bNama);
        

        Label karyawan = new Label("ID Karyawan");
        karyawan.getStyleClass().add("karyawan");
        karyawan.setPadding(new Insets(0, 0, 0, 20));
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

        VBox karyawan1 = new VBox(karyawan, bKaryawan);

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
            int tanggalMasuk = Integer.parseInt(bTanggal.getText());
        
            addKaryawan(namaKaryawan, idKaryawan, posisiKaryawan, tanggalMasuk);
        });

        Button home = new Button("Home");
        home.getStyleClass().add("home2");
        home.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });


        HBox home2 = new HBox(10, add,home);
        home2.setAlignment(Pos.CENTER);
        
        VBox all2 = new VBox(20, home2);
        all2.setAlignment(Pos.CENTER);
        all2.setPadding(new Insets(10, 0, 0, 100));

        VBox gabung = new VBox(40,nama1, karyawan1, posisi1, tanggal1);

        VBox all1 = new VBox( judul, gabung);
        all1. setSpacing(50);

        HBox all = new HBox(20,all1, all2);
        all.setPadding(new Insets(20));
        all.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        Scene scene = new Scene(all, 800,600);
        stage.setScene(scene);
    }

    public void addKaryawan(String nama, int id_karyawan, String posisi, int tanggal_masuk) {
        String sql = "INSERT INTO karyawan (nama, id_karyawan, posisi, tanggal_masuk) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection2.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nama);
            pstmt.setInt(2, id_karyawan);
            pstmt.setString(3, posisi);
            pstmt.setInt(4, tanggal_masuk);

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

    public int getTanggal() {
        return tanggal;
    }

    public void setTanggal(int tanggal) {
        this.tanggal = tanggal;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}