package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class question2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    // features that require interactivity
    public TextField[] m_fields;
    public TextField m_amount; // initial investment amount
    public TextField m_years; // years to calculate interest
    public TextField m_interest; // annual interest rate
    public TextField m_fval; // future value

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Assignment 1 q2");
        Pane mpane = new Pane();
        // setting up the scene
        GridPane mainGrid = new GridPane();
        GridPane inputGrid = new GridPane();
        m_amount = new TextField();
        m_years = new TextField();
        m_interest = new TextField();
        m_fval = new TextField();

        m_interest.setAlignment(Pos.BOTTOM_RIGHT);
        m_fval.setAlignment(Pos.BOTTOM_RIGHT);

        m_fval.setEditable(false);
        m_fval.setText("0");
        m_fval.setStyle("-fx-control-inner-background: #dedede");
        Label[] labels = new Label[4];
        m_fields = new TextField[4];
        for(int i = 0; i < labels.length; i++) {
            labels[i] = new Label();
            labels[i].setStyle("-fx-font-weight: bold");
            m_fields[i] = new TextField();
            m_fields[i].setAlignment(Pos.BOTTOM_RIGHT);
            m_fields[i].setText("0");
            inputGrid.add(labels[i],0,i);
            inputGrid.add(m_fields[i],1,i);
        }
        labels[0].setText("Investment Amount");
        labels[1].setText("Years");
        labels[2].setText("Annual Interest Rate");
        labels[3].setText("Future value");
        Label label_fval = new Label("Years");




        Button calcButton = new Button();

        inputGrid.setHgap(10);
        mainGrid.setVgap(20);
        mainGrid.setAlignment(Pos.BASELINE_RIGHT);
        mainGrid.add(inputGrid,0,0);
        mainGrid.add(calcButton,0,1);

        mpane.getChildren().add(mainGrid);
        primaryStage.setScene(new Scene(mpane, 400, 200));
        primaryStage.show();
    }
}
