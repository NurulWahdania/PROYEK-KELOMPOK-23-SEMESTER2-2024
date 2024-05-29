package shopsense_app.scene;

import com.google.common.collect.HashBasedTable;
import com.google.common.math.Quantiles.Scale;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Hasil {
    Stage stage;

    public Hasil(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Label nmToko = new Label(Home.namaToko);
        nmToko.getStyleClass().add("tokok");
        Line line = new Line();
        line.setStartY(0);
        line.setStartX(20);
        line.setEndY(20);
        line.setEndX(20);
        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        HBox all = new HBox(10, line, nmToko);
        all.setPadding(new Insets(30,0,0,1100));

        // Image foto = new Image("image/yooh.jpg");
        // ImageView vieFoto = new ImageView(foto);
        // vieFoto.setFitHeight(50);
        // vieFoto.setFitWidth(300);


        Label label = new Label("Histori");
        label.getStyleClass().add("judul4");
        label.setPadding(new Insets(40,0,0,20));

        Label menu1 = new Label("MENU");
        menu1.getStyleClass().add("judul");
        menu1.setPadding(new Insets(0,0,0,25));

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
        Button home = new Button("Home");
        home.getStyleClass().add("home");
        home.setOnAction(e -> {
            Home pane = new Home(stage);
            pane.show();
        });

        Rectangle with = new Rectangle(1000, 650);
        with.setFill(Color.web("#ffff"));
        with.getStyleClass().add("rectangle");
        with.setArcWidth(30); // Mengatur lebar sudut
        with.setArcHeight(30);

        HBox rewc = new HBox(with);
        rewc.setPadding(new Insets(20,0,0,230));

        VBox fungsi = new VBox(keuangan, barang, karyawan, tranksaksi, hasil, home);
        fungsi.setSpacing(40);
        HBox menu2 = new HBox(menu1);

        VBox vbox = new VBox(menu2, fungsi);

        HBox alldata = new HBox(vbox,label);
        
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10,10,10,10));

        StackPane pane = new StackPane(rewc, all,alldata);
        pane.getStyleClass().add("background2");
        pane.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
 

        Scene scene = new Scene(pane);
        stage.setScene(scene); 
        // stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();



    }
    
}
