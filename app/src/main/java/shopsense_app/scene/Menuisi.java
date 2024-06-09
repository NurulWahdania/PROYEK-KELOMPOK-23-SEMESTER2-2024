package shopsense_app.scene;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import java.time.LocalDateTime;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.time.format.DateTimeFormatter;

public class Menuisi {
    Stage stage;
    private Text datet;
    public Menuisi(Stage stage){
        this.stage = stage;
    }

    public void show(){

        datet = new Text();
        updateDateTime();
        HBox waktu = new HBox(datet);
        waktu.setPadding(new Insets(40,0,0,-70));

        Image image = new Image("image/men.png");

        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(610);
        imageView.setFitWidth(1040);

        HBox foto = new HBox(imageView);
        foto.setPadding(new Insets(20,0,0,230));

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
        Button hasil = new Button("Riwayat");
        hasil.getStyleClass().add("buton2");
        hasil.setOnAction(e -> {
            Riwayat cetak = new Riwayat(stage);
            cetak.show();
        });

        Button home = new Button("Beranda");
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
        rewc.setPadding(new Insets(20,0,0,230));

        VBox fungsi = new VBox(home, keuangan, barang, karyawan, tranksaksi, hasil);
        fungsi.setSpacing(40);
        HBox menu2 = new HBox(menu1);
        VBox vbox = new VBox(menu2, fungsi);
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10,10,10,10));

        HBox alldata = new HBox(120, vbox, waktu);

        StackPane pane = new StackPane(foto, alldata);
        pane.getStyleClass().add("background2");
        pane.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        Scene scene = new Scene(pane,1290, 650);
        stage.setScene(scene); 
        stage.show();
    }

    private void updateDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMMM yyyy \nHH:mm:ss");
        datet.setText(now.format(formatter));
        datet.getStyleClass().add("jam");
    }
}
