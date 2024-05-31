package shopsense_app.scene;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import shopsense_app.Data.TranksaksiControler;
import shopsense_app.From.FromBarang;
import shopsense_app.From.ListPaneBarang;
import shopsense_app.fungsiMenu.TransaksiClass;

public class LaporanToko  {
    TableView<shopsense_app.fungsiMenu.TransaksiClass> tableView;
    private SimpleStringProperty penghasilan;
    private TableView<shopsense_app.scene.Karyawan> tableView1;
    private Karyawan karyawanDAO = new Karyawan();
    private TranksaksiControler transaksiDAO = new TranksaksiControler();
    private Label totalItem;
    private Label totalkaryawan;
    Stage stage;

    public LaporanToko(String penghasilan){
        this.penghasilan = new SimpleStringProperty(penghasilan);
    }

    public LaporanToko(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        ListPaneBarang listPane = new ListPaneBarang();
        FromBarang fromPane3 = new FromBarang(listPane);

        Pane formPaneContainer = new Pane(fromPane3.getFormPane());
        formPaneContainer.setPadding(new Insets(40));

        tableView1 = new TableView<>();
        TableColumn<Karyawan, String> namaKarColum = new TableColumn<>("NAMA");
        namaKarColum.setCellValueFactory(new PropertyValueFactory<>("nama"));
        TableColumn<Karyawan, Integer> idKarColum = new TableColumn<>("ID KARYAWAN");
        idKarColum.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Karyawan, String> posisiColum = new TableColumn<>("POSISI KARYAWAN");
        posisiColum.setCellValueFactory(new PropertyValueFactory<>("posisi"));
        TableColumn<Karyawan, String> tmColum = new TableColumn<>("TANGGAL MASUK");
        tmColum.setCellValueFactory(new PropertyValueFactory<>("tanggal"));

        ObservableList<Karyawan> data = FXCollections.observableArrayList();
        tableView1.setItems(data);
        tableView1.getColumns().add(namaKarColum);
        tableView1.getColumns().add(idKarColum);
        tableView1.getColumns().add(posisiColum);
        tableView1.getColumns().add(tmColum);
        ObservableList<Karyawan> data2 = karyawanDAO.selectAll();
        System.out.println("Karyawan list size" + data2.size());
        tableView1.setItems(data2);

        tableView1.setMinWidth(300);
        tableView1.setMaxHeight(300);

        tableView = new TableView<>();
        TableColumn<TransaksiClass, String> hargaColum = new TableColumn<>("Total");
        hargaColum.setCellValueFactory(new PropertyValueFactory<>("harga"));
        TableColumn<TransaksiClass, String> waktuColum = new TableColumn<>("Waktu Transaksi");
        waktuColum.setCellValueFactory(new PropertyValueFactory<>("waktu"));
        ObservableList<TransaksiClass> dataTransaksi = FXCollections.observableArrayList();
        tableView.setItems(dataTransaksi);
        tableView.getColumns().add(hargaColum);
        tableView.getColumns().add(waktuColum);
        ObservableList<TransaksiClass> data3 = transaksiDAO.selectAll();
        System.out.println(data2.size());
        tableView.setItems(data3);

        tableView.setMinWidth(300);
        tableView.setMaxHeight(300);
        
        Label uang = new Label("Laporan Toko");
        uang.getStyleClass().add("judul2");

        Label pemasukan = new Label("Jumlah Pemasukan");
        pemasukan.getStyleClass().add("keuangan");
        pemasukan.setAlignment(Pos.CENTER);

        Label data1 = new Label("Data karyawan:\t");
        data1.getStyleClass().add("keuangan");
        data1.setAlignment(Pos.CENTER);

        HBox hjudul = new HBox(uang);
        hjudul.setAlignment(Pos.CENTER);
        // hjudul.setPadding(new Insets(-20,0,0,0));

        HBox label = new HBox(100, pemasukan, data1);
        label.setAlignment(Pos.CENTER);

        totalItem = new Label();
        totalItem.getStyleClass().add("keuangan");
        totalItem.setAlignment(Pos.CENTER);
        itemTotal(data3);

        totalkaryawan = new Label();
        totalkaryawan.getStyleClass().add("keuangan");
        totalkaryawan.setAlignment(Pos.CENTER);
        jumlahKaryawan(data2);

        HBox totalBox = new HBox(100, totalItem, totalkaryawan);

        VBox gabung = new VBox(30, hjudul, label, totalBox);
        gabung.setPadding(new Insets(-420, 10, 10, 40));
        gabung.setAlignment(Pos.CENTER);

        Label menu1 = new Label("SHOP SENSE");
        menu1.getStyleClass().add("judulhom");
        menu1.setPadding(new Insets(0,0,0,15));

        Button keuangan = new Button("Laporan Toko");
        keuangan.getStyleClass().add("buton2");
        keuangan.setOnAction(e -> {
            LaporanToko keuan = new LaporanToko(stage);
            keuan.show();
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
        Button hasil = new Button("Histori");
        hasil.getStyleClass().add("buton2");
        hasil.setOnAction(e -> {
            Hasil cetak = new Hasil(stage);
            cetak.show();
        });

        Button home = new Button("Home");
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
        rewc.setPadding(new Insets(20, 0, 0, 230));

        VBox fungsi = new VBox(home,keuangan, barang, karyawan, tranksaksi, hasil);
        fungsi.setSpacing(40);
        HBox menu2 = new HBox(menu1);

        VBox vbox = new VBox(menu2, fungsi);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        HBox view1 = new HBox(tableView1);
        view1.setPadding(new Insets(20,0,0,90));

        HBox view = new HBox(tableView);
        view.setPadding(new Insets(20,0,0,40));

        HBox tabel = new HBox(50,view, view1);
        tabel.setPadding(new Insets(220,0,0,-1000));
        tabel.setAlignment(Pos.CENTER);

        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        HBox alldata = new HBox(80, vbox, gabung,tabel);
        StackPane pane = new StackPane(rewc, alldata);
        pane.getStyleClass().add("background2");
        pane.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        Scene scene = new Scene(pane,1290, 650);
        stage.setScene(scene);
        stage.show();

    }

    private void itemTotal (ObservableList<TransaksiClass> data) {
        int total = data.size();
        totalItem.setText("Total Tranksaksi = " + total);
    }

    private void jumlahKaryawan (ObservableList<Karyawan> data) {
        int totalkar = data.size();
        totalkaryawan.setText("Jumlah Karyawan =  " + totalkar);
    }

}
