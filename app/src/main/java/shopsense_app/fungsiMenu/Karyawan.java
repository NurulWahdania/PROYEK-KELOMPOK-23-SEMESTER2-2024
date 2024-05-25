package shopsense_app.fungsiMenu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shopsense_app.scenes.Menuisi;

public class Karyawan {
    Stage stage;

    public Karyawan(Stage stage){
        this.stage = stage;
    }

    public void  show(){
        Label judul = new Label("Karyawan");
        judul.getStyleClass().add("judul2");

        Label nama = new Label("Nama");
        nama.getStyleClass().add("karyawan");
        nama.setPadding(new Insets(0, 0, 0, 20));
        Button bNama = new Button();
        bNama.getStyleClass().add("buton4");

        VBox nama1 = new VBox(nama,bNama);
        

        Label karyawan = new Label("ID Karyawan");
        karyawan.getStyleClass().add("karyawan");
        karyawan.setPadding(new Insets(0, 0, 0, 20));
        Button bKaryawan = new Button();
        bKaryawan.getStyleClass().add("buton4");

        VBox karyawan1 = new VBox(karyawan, bKaryawan);

        Label posis = new Label("Posis");
        posis.getStyleClass().add("karyawan");
        posis.setPadding(new Insets(0, 0, 0, 20));
        Button bPosis = new Button();
        bPosis.getStyleClass().add("buton4");

        VBox posisi1 = new VBox(posis, bPosis);

        Label tanggal = new Label("Tanggal Masuk");
        tanggal.getStyleClass().add("karyawan");
        tanggal.setPadding(new Insets(0, 0, 0, 20));
        Button bTanggal = new Button();
        bTanggal.getStyleClass().add("buton4");

        VBox tanggal1 = new VBox(tanggal, bTanggal);

        Button foto = new Button("FOTO");
        foto.getStyleClass().add("foto");
        foto.setMinSize(0, 200);

        Button add = new Button("Add");
        add.getStyleClass().add("home2");
        add.setPrefSize(80, 0);
        Button home = new Button("Home");
        home.getStyleClass().add("home2");
        home.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });


        HBox home2 = new HBox(10, add,home);
        home2.setAlignment(Pos.CENTER);
        
        VBox all2 = new VBox(20, foto, home2);
        all2.setAlignment(Pos.CENTER);
        all2.setPadding(new Insets(10, 0, 0, 100));

        VBox gabung = new VBox(40,nama1, karyawan1, posisi1, tanggal1);

        VBox all1 = new VBox( judul, gabung);
        all1. setSpacing(50);

        HBox all = new HBox(20,all1, all2);
        all.setPadding(new Insets(20));
        all.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        Scene scene = new Scene(all, 800,600);
        stage.setScene(scene);
    }
}
