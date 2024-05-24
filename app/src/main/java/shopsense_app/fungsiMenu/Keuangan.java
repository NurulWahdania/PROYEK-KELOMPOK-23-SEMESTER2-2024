package shopsense_app.fungsiMenu;

import org.checkerframework.checker.units.qual.g;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shopsense_app.scenes.Menuisi;

public class Keuangan {
    Stage stage;

    public Keuangan(Stage stage){
        this.stage = stage;
    }

    public void show() {
        Label keuangan = new Label("Laporan Keuangan");
        keuangan.getStyleClass().add("judul");
        keuangan.setStyle("-fx-font-size: 50px");

        Label pemasukan = new Label("Pemasukan  Rp:");
        pemasukan.getStyleClass().add("keuangan");
        Button bPemasukan = new Button();
        bPemasukan.getStyleClass().add("buton3");
        // VBox vpemasukan = new VBox(pemasukan, bPemasukan);
        // vpemasukan.setAlignment(Pos.CENTER);
    
        Label pengeluaran = new Label("Pengeluaran  Rp:");
        pengeluaran.getStyleClass().add("keuangan");
        Button bPengeluaran = new Button();
        bPengeluaran.getStyleClass().add("buton3");
        // VBox vPengwluaran = new VBox(pengeluaran, bPengeluaran);
        // vPengwluaran.setAlignment(Pos.CENTER);
    
        Label laba = new Label("Laba    Rp:");
        laba.getStyleClass().add("keuangan");
        Button bLaba = new Button();
        bLaba.getStyleClass().add("buton3");
        // VBox vlaba = new VBox(laba, bLaba);
        // vlaba.setAlignment(Pos.CENTER);

        Button home = new Button("Home");
        home.getStyleClass().add("home");
        home.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });

        VBox isi = new VBox(home);
        isi.setAlignment(Pos.BOTTOM_RIGHT);
        
        HBox hjudul = new HBox(keuangan);
        hjudul.setAlignment(Pos.CENTER);
        hjudul.setLayoutX(200);
        hjudul.setLayoutY(200);

        VBox label = new VBox(pemasukan, pengeluaran,laba);
        label.setSpacing(40);
        label.setAlignment(Pos.CENTER_LEFT);

        VBox butten = new VBox(bPemasukan, bPengeluaran, bLaba);
        butten.setSpacing(40);
        butten.setAlignment(Pos.CENTER_RIGHT);

        HBox hbox = new HBox(label, butten);
        hbox.setAlignment(Pos.CENTER);

        VBox gabung = new VBox(hbox, hjudul, isi);
        gabung.setSpacing(20);
        gabung.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        gabung.setAlignment(Pos.CENTER);
        gabung.getStyleClass().add("background2");

        Scene scene = new Scene(gabung, 1368,700);
        stage.setScene(scene);




    }



}
