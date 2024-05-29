package shopsense_app.scene;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import shopsense_app.scenes.FromBarang;
import shopsense_app.scenes.ListPaneBarang;
import javafx.beans.property.SimpleStringProperty;

public class Barang {
    private SimpleStringProperty nama;
    private SimpleStringProperty harga;
    private SimpleStringProperty stok;
    Stage stage;
    public Barang(String nama, String harga, String stok, Stage stage) {
        this.nama = new SimpleStringProperty(nama);
        this.harga = new SimpleStringProperty(harga);
        this.stok = new SimpleStringProperty(stok);
        this.stage = stage;
    }
    public Barang(String nama, String harga, String stok) {
        this.nama = new SimpleStringProperty(nama);
        this.harga = new SimpleStringProperty(harga);
        this.stok = new SimpleStringProperty(stok);
    }
    public Barang(Stage stage) {
        this.stage = stage;
    }
    public String getNama() {
        return nama.get();
    }
    public void setNama(String nama) {
        this.nama.set(nama);
    }
    public String getHarga() {
        return harga.get();
    }
    public void setHarga(String harga) {
        this.harga.set(harga);
    }
    public String getStok() {
        return stok.get();
    }
    public void setStok(String stok) {
        this.stok.set(stok);
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

        ListPaneBarang listPane = new ListPaneBarang();
        FromBarang fromPane2 = new FromBarang(listPane);

        Pane formPaneContainer = new Pane(fromPane2.getFormPane());
        formPaneContainer.setPadding(new Insets(40));

        VBox vBox = new VBox(10); 
        vBox.getChildren().addAll(formPaneContainer);

        VBox.setVgrow(formPaneContainer, Priority.ALWAYS);
        vBox.setAlignment(Pos.TOP_CENTER);

        HBox all2 = new HBox(10,lin2, nmToko );
        all2.setPadding(new Insets(30,0,0,650));

        VBox box = new VBox(all2,vBox);

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
        with.setArcWidth(30); 
        with.setArcHeight(30);

        HBox rewc = new HBox(with);
        rewc.setPadding(new Insets(20,0,0,230));

        HBox home2 = new HBox(home);

        VBox fungsi = new VBox(keuangan, barang, karyawan, tranksaksi, hasil, home2);
        fungsi.setSpacing(40);
      

        VBox vbox = new VBox(menu1, fungsi);
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10,10,10,10));


        HBox box2 =new HBox(200,vbox, box);

        StackPane pane = new StackPane(rewc, box2);
        pane.getStyleClass().add("background2");
        pane.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        Scene scene = new Scene(pane);
        stage.setScene(scene); 
        // stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }
}