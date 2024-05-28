package shopsense_app.scenes;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import shopsense_app.fungsiMenu.BarangController;
import shopsense_app.fungsiMenu.DataProvider;
import shopsense_app.scene.Barang;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;

public class FromBarang {

    VBox content;
    TextField tf_nama, tf_harga, tf_stok;
    Button add, update, delete, submit, cancel;
    BarangController barangController = new BarangController();

    ListPaneBarang listPane;
    TableView<shopsense_app.scene.Barang> tableView;

    public FromBarang(ListPaneBarang listPane) {
        this.listPane = listPane;
    }

    public VBox getFormPane() {

        add = new Button("Add");
        add.setMaxHeight(40);
        add.setMinWidth(200);
        add.setStyle("-fx-background-color: #02c37e; -fx-text-fill: black; -fx-background-radius: 10");
        add.setOnAction(e -> {
            setActive(1);
            setForm(1);
            setSubmit(1);
        });
        update = new Button("Update");
        update.setMaxHeight(40);
        update.setMinWidth(200);
        update.setStyle("-fx-background-color: #02c37e; -fx-text-fill: black; -fx-background-radius: 10");
        update.setOnAction(e -> {
            setActive(2);
            setForm(2);
            setSubmit(2);
        });
        delete = new Button("Delete");
        delete.setMaxHeight(40);
        delete.setMinWidth(200);
        delete.setStyle("-fx-background-color: #02c37e; -fx-text-fill: black; -fx-background-radius: 10");
        delete.setOnAction(e -> {
            setActive(3);
            setForm(3);
            setSubmit(3);
        });
        content = new VBox();
        content.setSpacing(10);

        submit = new Button();
        submit.setPrefSize(200, 25);
        submit.setStyle("-fx-background-color: #0faf0f; -fx-text-fill: #ffffff;  -fx-background-radius: 10");
        submit.setMinWidth(150);

        cancel = new Button("Cancel");
        cancel.setPrefSize(200, 25);
        cancel.setStyle("-fx-background-color: #0faf0f; -fx-text-fill: #ffffff;  -fx-background-radius: 10");
        cancel.setMinWidth(120);

        setActive(1);
        setForm(1);
        setSubmit(1);

        tableView = new TableView<>();
        TableColumn<Barang, String> namaColum = new TableColumn<>("NAMA BARANG");
        namaColum.setCellValueFactory(new PropertyValueFactory<>("nama"));
        namaColum.setPrefWidth(170);

        TableColumn<Barang, String> hargaColum = new TableColumn<>("HARGA BARANG");
        hargaColum.setCellValueFactory(new PropertyValueFactory<>("harga"));
        namaColum.setPrefWidth(160);

        TableColumn<Barang, String> stokColum = new TableColumn<>("STOK BARANG");
        stokColum.setCellValueFactory(new PropertyValueFactory<>("stok"));
        stokColum.setPrefWidth(115);

        VBox tab = new VBox(10, add, update, delete, submit);
        tab.setAlignment(Pos.TOP_CENTER);
        tab.maxWidth(160);

        tableView.getColumns().add(namaColum);
        tableView.getColumns().add(hargaColum);
        tableView.getColumns().add(stokColum);
        tableView.setMinWidth(400);

        Label barang = new Label("Barang");
        barang.setStyle(
                "-fx-font-size: 40px; -fx-text-fill: #02c37e; -fx-text-align: center; -fx-font-family: Arial; -fx-weight: bold;");
        ScrollPane scrollPane = new ScrollPane(tableView);
        scrollPane.setMaxHeight(400);
        scrollPane.setMinWidth(400);
        VBox vbox = new VBox(20, content, scrollPane);
        vbox.setMaxHeight(400);
        vbox.setMaxWidth(400);
        vbox.setMinHeight(400);
        vbox.setMinWidth(400);
        vbox.setAlignment(Pos.TOP_CENTER);
        HBox res = new HBox(40, vbox, tab);
        res.setPadding(new Insets(20));
        res.setMaxHeight(600);
        res.setAlignment(Pos.CENTER);

        VBox last = new VBox(40, barang, res);
        last.setAlignment(Pos.CENTER);

        loadData();

        return last;
    }
    public void loadData() {
        ObservableList<Barang> barang = barangController.selectAll();
        System.out.println(String.valueOf(barang.size()));
        tableView.setItems(barang);
    }
    void setActive(int button) {
        add.setStyle("-fx-background-color: #BFF6C3; -fx-text-fill: #ffffff;  -fx-background-radius: 10");
        update.setStyle("-fx-background-color: #BFF6C3; -fx-text-fill: #ffffff; -fx-background-radius: 10");
        delete.setStyle("-fx-background-color: #BFF6C3; -fx-text-fill: #ffffff; -fx-background-radius: 10");
        switch (button) {
            case 1 -> add.setStyle("-fx-background-color: #00ffff; -fx-text-fill: #000000; -fx-background-radius: 0");
            case 2 ->
                update.setStyle("-fx-background-color: #00ffff; -fx-text-fill: #000000; -fx-background-radius: 0");
            case 3 ->
                delete.setStyle("-fx-background-color: #00ffff; -fx-text-fill: #000000; -fx-background-radius: 0");
        }
    }
    void setForm(int type) {
        switch (type) {
            case 1 -> {
                content.getChildren().clear();
                Label lb_nama = new Label("Nama Barang");
                lb_nama.setPrefSize(100, 20);
                tf_nama = new TextField();
                tf_nama.setPrefSize(200, 20);
                tf_nama.setStyle("-fx-background-color: #02c37e;-fx-background-radius: 10px;");
                tf_nama.setMinWidth(300);
                HBox nama = new HBox(lb_nama, tf_nama);
                Label lb_harga = new Label("Harga Barang");
                lb_harga.setPrefSize(100, 20);
                tf_harga = new TextField();
                tf_harga.setPrefSize(200, 20);
                tf_harga.setMinWidth(300);
                TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
                    String newText = change.getControlNewText();
                    if (newText.matches("\\d*")) {
                        return change;
                    }
                    return null;
                });
                tf_harga.setTextFormatter(textFormatter);
                tf_harga.setStyle("-fx-background-color: #02c37e;-fx-background-radius: 10px;");
                HBox harga = new HBox(lb_harga, tf_harga);
                Label lb_stok = new Label("Stok Barang");
                lb_stok.setPrefSize(100, 20);
                tf_stok = new TextField();
                tf_stok.setPrefSize(200, 20);
                TextFormatter<String> textFormatter1 = new TextFormatter<>(change -> {
                    String newText = change.getControlNewText();
                    if (newText.matches("\\d*")) {
                        return change;
                    }
                    return null;
                });
                tf_stok.setTextFormatter(textFormatter1);
                tf_stok.setStyle("-fx-background-color: #02c37e;-fx-background-radius: 10px;");
                tf_stok.setMinWidth(300);
                HBox stok = new HBox(lb_stok, tf_stok);
                content.getChildren().addAll(nama, harga, stok);
            }
            case 2 -> {
                content.getChildren().clear();
                Label lb_nama = new Label("Nama Barang");
                lb_nama.setPrefSize(100, 20);
                tf_nama = new TextField();
                tf_nama.setPrefSize(200, 20);
                tf_nama.setMinWidth(300);
                tf_nama.setStyle("-fx-background-color: #02c37e;-fx-background-radius: 10px;");
                HBox nama = new HBox(lb_nama, tf_nama);
                Label lb_harga = new Label("Harga Barang");
                lb_harga.setPrefSize(100, 20);
                tf_harga = new TextField();
                tf_harga.setPrefSize(200, 20);
                tf_harga.setStyle("-fx-background-color: #02c37e;-fx-background-radius: 10px;");
                tf_harga.setMinWidth(300);
                HBox harga = new HBox(lb_harga, tf_harga);
                Label lb_stok = new Label("Stok Barang");
                lb_stok.setPrefSize(100, 20);
                tf_stok = new TextField();
                tf_stok.setPrefSize(200, 20);
                tf_stok.setMinWidth(300);
                tf_stok.setStyle("-fx-background-color: #02c37e;-fx-background-radius: 10px;");
                HBox stok = new HBox(lb_stok, tf_stok);
                content.getChildren().addAll(nama, harga, stok);
            }
            case 3 -> {
                content.getChildren().clear();
                Label lb_nama = new Label("Nama Barang");
                lb_nama.setPrefSize(100, 20);
                tf_nama = new TextField();
                tf_nama.setPrefSize(200, 20);
                tf_nama.setMinWidth(300);
                tf_nama.setStyle("-fx-background-color: #02c37e;-fx-background-radius: 10px;");
                HBox nama = new HBox(lb_nama, tf_nama);
                content.getChildren().addAll(nama);
            }
        }
    }
    void setSubmit(int type) {
        switch (type) {
            case 1 -> {
                submit.setText("Add Data");
                submit.setOnAction(e -> {
                    String nama = ((TextField) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getText().trim();
                    String harga = ((TextField) ((HBox) content.getChildren().get(1)).getChildren().get(1)).getText().trim();
                    String stok = ((TextField) ((HBox) content.getChildren().get(2)).getChildren().get(1)).getText().trim();
                    barangController.insert(nama, harga, stok);
                    if (!nama.isEmpty() || !harga.isEmpty() || !stok.isEmpty()) {
                        Barang barang = new Barang(nama, harga, stok);
                        DataProvider dataProvider = new DataProvider();
                        dataProvider.addBarang(barang);
                        tf_nama.clear();
                        tf_harga.clear();
                        tf_stok.clear();
                    }
                    tf_nama.setText("");
                    tf_harga.setText("");
                    tf_stok.setText("");
                    loadData();
                });
            }
            case 2 -> {
                submit.setText("Update Data");
                submit.setOnAction(e -> {
                    String nama = ((TextField) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getText().trim();
                    String harga = ((TextField) ((HBox) content.getChildren().get(1)).getChildren().get(1)).getText().trim();
                    String stok = ((TextField) ((HBox) content.getChildren().get(2)).getChildren().get(1)).getText().trim();
                    barangController.update(nama, harga, stok);
                    if (!nama.isEmpty() || !harga.isEmpty() || !stok.isEmpty()) {
                        Barang barang = new Barang(nama, harga, stok);
                        DataProvider dataProvider = new DataProvider();
                        dataProvider.addBarang(barang);
                        tf_nama.clear();
                        tf_harga.clear();
                        tf_stok.clear();
                    }
                    tf_nama.setText("");
                    tf_harga.setText("");
                    tf_stok.setText("");
                    loadData();
                });
            }
            case 3 -> {
                submit.setText("Delete Data");
                submit.setOnAction(e -> {
                    String nama = ((TextField) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getText().trim();
                    Stage stage = new Stage();
                    Button yes = new Button("Yes");
                    yes.setOnAction(e1 -> {
                        barangController.delete(nama);
                        loadData();
                        stage.close();
                    });
                    Button no = new Button("No");
                    no.setOnAction(e1 -> stage.close());
                    VBox vBox = new VBox(new Label("Are you sure want to delete this data?"), yes, no);
                    vBox.setSpacing(10);
                    vBox.setStyle("-fx-padding: 20px");
                    vBox.setPrefSize(200, 100);
                    Scene scene = new Scene(vBox);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    tf_nama.setText("");
                });
            }
        }
    }
}