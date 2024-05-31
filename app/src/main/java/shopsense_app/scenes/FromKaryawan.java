// package shopsense_app.scenes;

// import javafx.collections.ObservableList;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableView;
// import javafx.scene.control.TextField;
// import javafx.scene.control.TextFormatter;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;
// import shopsense_app.fungsiMenu.BarangController;
// import shopsense_app.fungsiMenu.DataProvider;
// import shopsense_app.scene.Barang;

// public class FromKaryawan {
//     VBox content;
//     TextField tf_id, tf_harga, tf_stok;
//     Button delete, submit, cancel;
//     BarangController barangController = new BarangController();

//     ListPaneBarang listPane;
//     TableView<shopsense_app.scene.karyawan> tableView;
//     Karyawan kar;

//     public FromKaryawan(Karyawan kar) {
//         this.kar = kar;
//     }

//     public VBox getFormPane() {
//         delete = new Button("Delete");
//         delete.setMaxHeight(40);
//         delete.setMinWidth(200);
//         delete.setStyle("-fx-background-color: #02c37e; -fx-text-fill: black; -fx-background-radius: 10");
//         delete.setOnAction(e -> {
//             setActive(3);
//             setForm(3);
//             setSubmit(3);
//         });
//         content = new VBox();
//         content.setSpacing(10);

//         submit = new Button();
//         submit.setPrefSize(200, 25);
//         submit.setStyle("-fx-background-color: #0faf0f; -fx-text-fill: #ffffff;  -fx-background-radius: 10");
//         submit.setMinWidth(150);

//         cancel = new Button("Cancel");
//         cancel.setPrefSize(200, 25);
//         cancel.setStyle("-fx-background-color: #0faf0f; -fx-text-fill: #ffffff;  -fx-background-radius: 10");
//         cancel.setMinWidth(120);

//         setActive(1);
//         setForm(1);
//         setSubmit(1);

//         tableView = new TableView<>();
//         TableColumn<Barang, String> namaColum = new TableColumn<>("NAMA BARANG");
//         namaColum.setCellValueFactory(new PropertyValueFactory<>("nama"));
//         namaColum.setPrefWidth(170);

//         TableColumn<Barang, String> hargaColum = new TableColumn<>("HARGA BARANG");
//         hargaColum.setCellValueFactory(new PropertyValueFactory<>("harga"));
//         namaColum.setPrefWidth(160);

//         TableColumn<Barang, String> stokColum = new TableColumn<>("STOK BARANG");
//         stokColum.setCellValueFactory(new PropertyValueFactory<>("stok"));
//         stokColum.setPrefWidth(115);

//         VBox tab = new VBox(10, delete, submit);
//         tab.setAlignment(Pos.TOP_CENTER);
//         tab.maxWidth(160);

//         tableView.getColumns().add(namaColum);
//         tableView.getColumns().add(hargaColum);
//         tableView.getColumns().add(stokColum);
//         tableView.setMinWidth(400);

//         Label barang = new Label("Barang");
//         barang.setStyle(
//                 "-fx-font-size: 40px; -fx-text-fill: #02c37e; -fx-text-align: center; -fx-font-family: Arial; -fx-weight: bold;");
//         ScrollPane scrollPane = new ScrollPane(tableView);
//         scrollPane.setMaxHeight(400);
//         scrollPane.setMinWidth(400);
//         VBox vbox = new VBox(20, content, scrollPane);
//         vbox.setMaxHeight(400);
//         vbox.setMaxWidth(400);
//         vbox.setMinHeight(400);
//         vbox.setMinWidth(400);
//         vbox.setAlignment(Pos.TOP_CENTER);
//         HBox res = new HBox(40, vbox, tab);
//         res.setPadding(new Insets(20));
//         res.setMaxHeight(600);
//         res.setAlignment(Pos.CENTER);

//         VBox last = new VBox(40, barang, res);
//         last.setAlignment(Pos.CENTER);

//         loadData();

//         return last;
//     }
//     public void loadData() {
//         ObservableList<Barang> barang = barangController.selectAll();
//         System.out.println(String.valueOf(barang.size()));
//         tableView.setItems(barang);
//     }
//     void setActive(int button) {
//         delete.setStyle("-fx-background-color: #BFF6C3; -fx-text-fill: #ffffff; -fx-background-radius: 10");
//         delete.setStyle("-fx-background-color: #00ffff; -fx-text-fill: #000000; -fx-background-radius: 0");
//         }
    
//     void setForm(int type) {
//                 content.getChildren().clear();
//                 Label id_karyawan = new Label("Id");
//                 id_karyawan.setPrefSize(100, 20);
//                 tf_id = new TextField();
//                 tf_id.setPrefSize(200, 20);
//                 tf_id.setMinWidth(300);
//                 tf_id.setStyle("-fx-background-color: #02c37e;-fx-background-radius: 10px;");
//                 HBox nama = new HBox(id_karyawan, tf_id);
//                 content.getChildren().addAll(nama);
            
//     }
    
//     void setSubmit(int type) {
//                 submit.setText("Delete Data");
//                 submit.setOnAction(e -> {
//                     String nama = ((TextField) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getText().trim();
//                     Stage stage = new Stage();
//                     Button yes = new Button("Yes");
//                     yes.setOnAction(e1 -> {
//                         barangController.delete(nama);
//                         loadData();
//                         stage.close();
//                     });
//                     Button no = new Button("No");
//                     no.setOnAction(e1 -> stage.close());
//                     VBox vBox = new VBox(new Label("Are you sure want to delete this data?"), yes, no);
//                     vBox.setSpacing(10);
//                     vBox.setStyle("-fx-padding: 20px");
//                     vBox.setPrefSize(200, 100);
//                     Scene scene = new Scene(vBox);
//                     stage.setScene(scene);
//                     stage.setResizable(false);
//                     stage.show();
//                     tf_nama.setText("");
//                 });
            
//          }
//     }


    

