import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;

public class C14E1DisplayImages extends Application{
    public static void main(String[] args){
        System.out.println("4 images");
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.add(new ImageView(new Image("uk.png")),0,0);
        pane.add(new ImageView(new Image("canada.png")),1,0);
        pane.add(new ImageView(new Image("china.png")),0,1);
        pane.add(new ImageView(new Image("usa.png")),1,1);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("countries");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
