package shopsense_app.scene;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.control.TableCell;
import shopsense_app.Data.TranksaksiControler;
import shopsense_app.fungsiMenu.TransaksiClass;

public class Riwayat {
    Stage stage;
    private TranksaksiControler transaksiDAO = new TranksaksiControler();
    TableView<shopsense_app.fungsiMenu.TransaksiClass> tableView;
    Label pemasukan;

    public Riwayat(Stage stage){
        this.stage = stage;
    }

    public void show(){
        tableView = new TableView<>();

        TableColumn<TransaksiClass, Void> rowNumCol = new TableColumn<>("NO");
        rowNumCol.setCellFactory(new Callback<TableColumn<TransaksiClass, Void>, TableCell<TransaksiClass, Void>>() {
            @Override
            public TableCell<TransaksiClass, Void> call(TableColumn<TransaksiClass, Void> param) {
                return new TableCell<TransaksiClass, Void>() {
                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(String.valueOf(getIndex() + 1));
                        }
                    }
                };
            }
        });
        rowNumCol.setPrefWidth(50); 

        TableColumn<TransaksiClass, String> namaKaryawanColum = new TableColumn<>("NAMA KARYAWAN");
        namaKaryawanColum.setCellValueFactory(new PropertyValueFactory<>("nama_karyawan"));
        namaKaryawanColum.setPrefWidth(250);

        TableColumn<TransaksiClass, String> hargaColum = new TableColumn<>("Total");
        hargaColum.setCellValueFactory(new PropertyValueFactory<>("harga"));
        hargaColum.setPrefWidth(250);

        TableColumn<TransaksiClass, String> waktuColum = new TableColumn<>("Waktu Transaksi");
        waktuColum.setCellValueFactory(new PropertyValueFactory<>("waktu"));
        waktuColum.setPrefWidth(283);

        ObservableList<TransaksiClass> data = FXCollections.observableArrayList();
        tableView.setItems(data);
        tableView.getColumns().add(rowNumCol);
        tableView.getColumns().add(namaKaryawanColum);
        tableView.getColumns().add(hargaColum);
        tableView.getColumns().add(waktuColum);

        ObservableList<TransaksiClass> data2 = transaksiDAO.selectAll();
        tableView.setItems(data2);

        tableView.setMinWidth(800);
        tableView.setMaxHeight(400);

        Label label = new Label("Riwayat");
        label.getStyleClass().add("judul4");
        label.setPadding(new Insets(40, 0, 0, 20));

        Label menu1 = new Label("SHOP SENSE");
        menu1.getStyleClass().add("judulhom");
        menu1.setPadding(new Insets(0, 0, 0, 15));

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
        rewc.setPadding(new Insets(20, 0, 0, 230));

        VBox fungsi = new VBox(home, keuangan, barang, karyawan, tranksaksi, hasil);
        fungsi.setSpacing(40);

        HBox menu2 = new HBox(menu1);
        VBox vbox = new VBox(menu2, fungsi);

        HBox view = new HBox(tableView);
        view.setPadding(new Insets(140, 0, 0, -20));

        pemasukan = new Label();
        pemasukan.getStyleClass().add("keuangan");
        pemasukan.setPadding(new Insets(5,0,0,0));
        totalPemasukan(data2);

        HBox peHBox = new HBox(pemasukan);
        peHBox.setPadding(new Insets(10,0,0,20));

        VBox content = new VBox(label, view, peHBox);
        HBox gabung = new HBox(vbox, label, content);

        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        StackPane pane = new StackPane(rewc, gabung);
        pane.getStyleClass().add("background2");
        pane.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        Scene scene = new Scene(pane, 1290, 650);
        stage.setScene(scene);
        stage.show();
    }

    private void totalPemasukan (ObservableList<TransaksiClass> data) {
        double total = 0;
        for (TransaksiClass tranksaksi : data) {
            total += (tranksaksi.getHarga());
        }
        pemasukan.setText("Total Pemasukan: " + total);
    }
}
