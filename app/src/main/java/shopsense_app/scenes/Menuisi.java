package shopsense_app.scenes;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import shopsense_app.fungsiMenu.Hasil;
import shopsense_app.fungsiMenu.Barang;
import shopsense_app.fungsiMenu.Karyawan;
import shopsense_app.fungsiMenu.Keuangan;
import shopsense_app.fungsiMenu.Tranksaksi;
public class Menuisi {
    Stage stage;
    public Menuisi(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Label nmToko = new Label(FormPane.namaToko);
        // nmToko.getStyleClass().add("tf-name1");
        Label menu1 = new Label("MENU");
        menu1.getStyleClass().add("judul");

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
        Button home = new Button("Home");
        home.getStyleClass().add("home");
        home.setOnAction(e -> {
            FormPane pane = new FormPane(stage);
            pane.show();
        });
        HBox home2 = new HBox(home);
        home2.setAlignment(Pos.BOTTOM_RIGHT);
        VBox fungsi = new VBox(keuangan, barang, karyawan, tranksaksi, hasil, home2);
        fungsi.setSpacing(40);
        fungsi.setAlignment(Pos.CENTER);
        fungsi.setPrefHeight(200);
        HBox menu2 = new HBox(menu1);
        menu2.setAlignment(Pos.CENTER);


        VBox vbox = new VBox(menu2, fungsi);
        vbox.getStyleClass().add("background2");
        vbox.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(80);
        vbox.setPadding(new Insets(10,10,10,10));

        StackPane pane = new StackPane(vbox, nmToko);
        StackPane.setMargin(nmToko, new Insets(-540, 0, 0, -720));

        // pane.setPadding(new Insets(40));

        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene); 
    }

}
