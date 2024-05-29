package shopsense_app.scene;

import org.checkerframework.checker.units.qual.g;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LaporanToko {
    Stage stage;

    public LaporanToko(Stage stage){
        this.stage = stage;
    }

    public void show() {

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
        alll.setPadding(new Insets(30,0,0,750));

        Label uang = new Label("Laporan Toko");
        uang.getStyleClass().add("judul2");


        Label pemasukan = new Label("Jumlah Pemasukan");
        pemasukan.getStyleClass().add("keuangan");
        pemasukan.setAlignment(Pos.CENTER);
    
        Label pengeluaran = new Label("Data karyawan:\t");
        pengeluaran.getStyleClass().add("keuangan");
        pengeluaran.setAlignment(Pos.CENTER);

        HBox hjudul = new HBox(uang);
        hjudul.setAlignment(Pos.CENTER);

        HBox label = new HBox(100,pemasukan, pengeluaran);
        label.setAlignment(Pos.CENTER);

        VBox gabung = new VBox(40, hjudul, label);
        gabung.setPadding(new Insets(10,10,10,40));
        gabung.setAlignment(Pos.CENTER);

        VBox all = new VBox(alll, gabung);

        Label menu1 = new Label("MENU");
        menu1.getStyleClass().add("judul");
        menu1.setPadding(new Insets(0,0,0,25));

        Button keuangan = new Button("Laporan Toko");
        keuangan.getStyleClass().add("buton2");
        keuangan.setOnAction(e -> {
            LaporanToko keuang= new LaporanToko(stage);
            keuang.show();
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

        Button home = new Button("Home");
        home.getStyleClass().add("home");
        home.setOnAction(e -> {
            Home menu = new Home(stage);
            menu.show();
        });

        Rectangle with = new Rectangle(1000, 650);
        with.setFill(Color.web("#ffff"));
        with.getStyleClass().add("rectangle");
        with.setArcWidth(30); // Mengatur lebar sudut
        with.setArcHeight(30);

        HBox rewc = new HBox(with);
        rewc.setPadding(new Insets(20,0,0,230));

        // home2.setAlignment(Pos.BOTTOM_RIGHT);
        VBox fungsi = new VBox(keuangan, barang, karyawan, tranksaksi, hasil, home);
        fungsi.setSpacing(40);
        HBox menu2 = new HBox(menu1);

        VBox vbox = new VBox(menu2, fungsi);
        vbox.setPadding(new Insets(10,10,10,10));
        
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10,10,10,10));
        HBox alldata = new HBox(80,vbox, all);
        StackPane pane = new StackPane(rewc, alldata);
        pane.getStyleClass().add("background2");
        pane.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        Scene scene = new Scene(pane);
        stage.setScene(scene); 
        // stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();

    }

}
