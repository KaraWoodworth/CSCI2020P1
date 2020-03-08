package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.util.Random;

public class question1 extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Assignment 1 q1");

        // basic window structure setup
        Pane mpane = new Pane();
        GridPane maingrid = new GridPane();

        //setting up three imageview objects, path set by generateCardPath()
        ImageView card1 = new ImageView( new Image(generateCardPath()) );
        ImageView card2 = new ImageView( new Image(generateCardPath()) );
        ImageView card3 = new ImageView( new Image(generateCardPath()) );

        // configure layout of cards in the main grid
        maingrid.add(card1,0,0);
        maingrid.add(card2,1,0);
        maingrid.add(card3,2,0);
        maingrid.setHgap(6); // gap between cards
        //add grid to Pane
        mpane.getChildren().add(maingrid);

        //3 cards width is 72 x 3 = 216, add 12 for column gap
        primaryStage.setScene(new Scene(mpane, 228, 96));
        primaryStage.show();
    }

    public String generateCardPath(){
        // create random number between 1 and 54, need to add 1 as default behavior is 0 to max
        return "file:Cards/" + Integer.toString((int)(new Random().nextInt(54)+1)) + ".png";
    }
}
