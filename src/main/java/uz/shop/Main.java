package uz.shop;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import uz.shop.config.AppConfig;
import uz.shop.config.PersistenceConfig;

public class Main extends Application {

    public static AnnotationConfigApplicationContext ctx;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Login.fxml"));
        primaryStage.setTitle("Shop Magazine");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(PersistenceConfig.class);
        ctx.register(AppConfig.class);
        ctx.refresh();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
