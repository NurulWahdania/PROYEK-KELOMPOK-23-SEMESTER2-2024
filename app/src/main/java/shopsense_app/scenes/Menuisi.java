package shopsense_app.scenes;

import org.checkerframework.checker.units.qual.h;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shopsense_app.fungsiMenu.Keuangan;

public class Menuisi {
    Stage stage;

    public Menuisi(Stage stage){
        this.stage = stage;
    }

    public void show(){

        // Button button = new Button("Back");
        // button.setTextFill(Color.BLACK);
        // button.setAlignment(Pos.CENTER);
        // button.setPrefWidth(200);
        // button.setOnAction(e -> {
        //     FormPane form = new FormPane(stage);
        //     form.show();
        // });

        // VBox vbox = new VBox(button);
        // vbox.setAlignment(Pos.CENTER);

        // Scene scene = new Scene(vbox, 500, 500);
        // stage.setScene(scene); 

        Label menu1 = new Label("MENU");
        menu1.getStyleClass().add("judul");

        Button keuangan = new Button("Laporan Keuangan");
        keuangan.getStyleClass().add("buton2");
        // keuangan.setPrefWidth(10);
        // keuangan.setPrefHeight(100);
        keuangan.setOnAction(e -> {
            Keuangan uang = new Keuangan(stage);
            uang.show();
        });

        Button barang = new Button("Barang");
        barang.getStyleClass().add("buton2");

        Button karyawan = new Button("Karyawan");
        karyawan.getStyleClass().add("buton2");

        Button tranksaksi = new Button("Transaksi");
        tranksaksi.getStyleClass().add("buton2");

        Button hasil = new Button("Cetak Hasil");
        hasil.getStyleClass().add("buton2");

        Button home = new Button("Home");
        home.getStyleClass().add("home");
        home.setOnAction(e -> {
            FormPane pane = new FormPane(stage);
            pane.show();
        });

        HBox isi = new HBox(home);
        isi.setAlignment(Pos.BOTTOM_RIGHT);

        VBox fungsi = new VBox(keuangan, barang, karyawan, tranksaksi, hasil,isi);
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

        Scene scene = new Scene(vbox, 1368, 700);
        stage.setScene(scene); 




    }
    
}
