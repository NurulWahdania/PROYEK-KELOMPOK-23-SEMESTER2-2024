package shopsense_app;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import shopsense_app.scene.Home;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        stage.setTitle("ShopSense");
        Image imageIcon = new Image(getClass().getClassLoader().getResourceAsStream("image/Logo.jpg"));
        stage.getIcons().add(imageIcon);

        Home form = new Home(stage);
        form.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}