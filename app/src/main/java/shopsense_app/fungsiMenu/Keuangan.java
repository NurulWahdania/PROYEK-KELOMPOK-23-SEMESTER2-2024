package shopsense_app.fungsiMenu;

import org.checkerframework.checker.units.qual.g;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import shopsense_app.scenes.FormPane;
import shopsense_app.scenes.Menuisi;

public class Keuangan {
    Stage stage;

    public Keuangan(Stage stage){
        this.stage = stage;
    }

    public void show() {

        Label nmToko = new Label(FormPane.namaToko);
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
        alll.setPadding(new Insets(10,0,0,20));

        Label keuangan = new Label("Laporan Keuangan");
        keuangan.getStyleClass().add("judul2");

        Label pemasukan = new Label("Pemasukan Rp:\t");
        pemasukan.getStyleClass().add("keuangan");
        Button bPemasukan = new Button();
        bPemasukan.getStyleClass().add("buton3");
    

        Label pengeluaran = new Label("Pengeluaran Rp:\t");
        pengeluaran.getStyleClass().add("keuangan");
        Button bPengeluaran = new Button();
        bPengeluaran.getStyleClass().add("buton3");
    

        Label laba = new Label("Laba Rp:\t");
        laba.getStyleClass().add("keuangan");
        Button bLaba = new Button();
        bLaba.getStyleClass().add("buton3");


        Button ceklaba = new Button("Cek Laba");
        ceklaba.setAlignment(Pos.CENTER);
        ceklaba.getStyleClass().add("home2");
        ceklaba.setMaxSize(200, 0);
        

        Button home = new Button("Menu");
        home.getStyleClass().add("home2");
        home.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });

        VBox home2 = new VBox(home);
        home2.setAlignment(Pos.BOTTOM_RIGHT);
        home2.setPadding(new Insets(-20,0,0,0));

        HBox hjudul = new HBox(keuangan);
        hjudul.setAlignment(Pos.CENTER);


        VBox label = new VBox(pemasukan, pengeluaran,laba);
        label.setSpacing(50);
        label.setAlignment(Pos.CENTER_LEFT);

        VBox butten = new VBox(bPemasukan, bPengeluaran, bLaba);
        butten.setSpacing(40);
        butten.setAlignment(Pos.CENTER_RIGHT);

        HBox hbox = new HBox(label, butten);
        hbox.setAlignment(Pos.CENTER);

        VBox gabung = new VBox( hjudul, hbox,ceklaba, home2);
        gabung.setSpacing(80);
        gabung.setPadding(new Insets(10,10,10,10));
        gabung.setAlignment(Pos.CENTER);

        VBox all = new VBox(alll, gabung);
        all.getStyleClass().add("backgroundK");

        Scene scene = new Scene(all, 800,600);
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setScene(scene);




    }



}
