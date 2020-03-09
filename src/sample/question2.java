package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
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

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Assignment 1 q2");
        Pane mpane = new Pane();
        // setting up the scene
        GridPane mainGrid = new GridPane(); // this contains input and button
        GridPane inputGrid = new GridPane(); // this contains text and labels

        Label[] labels = new Label[4];
        m_fields = new TextField[4];
        //generic formatting of grid items
        for(int i = 0; i < labels.length; i++) {
            labels[i] = new Label();
            labels[i].setStyle("-fx-font-weight: bold");
            m_fields[i] = new TextField();
            m_fields[i].setAlignment(Pos.BOTTOM_RIGHT);
            m_fields[i].setText("0");
            inputGrid.add(labels[i],0,i);
            inputGrid.add(m_fields[i],1,i);
        }
        //set field specific attributes
        labels[0].setText("Investment Amount");
        labels[1].setText("Years");
        labels[2].setText("Annual Interest Rate");
        labels[3].setText("Future value");
        m_fields[3].setStyle("-fx-control-inner-background: #dedede");

        Button calcButton = new Button("Calculate");
        calcButton.setAlignment(Pos.BOTTOM_RIGHT);
        calcButton.setOnAction(new CalculatePressed());

        inputGrid.setHgap(10);
        mainGrid.setVgap(20);
        mainGrid.setAlignment(Pos.BASELINE_RIGHT);
        mainGrid.setHalignment(calcButton, HPos.RIGHT);
        mainGrid.add(inputGrid,0,0);
        mainGrid.add(calcButton,0,1);

        mpane.getChildren().add(mainGrid);
        primaryStage.setScene(new Scene(mpane, 400, 200));
        primaryStage.show();
    }
    class CalculatePressed implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // m_fields[0] = initial amount
            // m_fields[1] = Years
            // m_fields[2] = Annual Interest Rate
            // m_fields[3] = future value that we are updating
            //future value = InvestmentAmount * (1 + monthlyInterestRate)^years*12
            Double InvestmentAmount = Double.parseDouble(m_fields[0].getText());
            Double years = Double.parseDouble(m_fields[1].getText());
            // divide by 12 to get monthly rate, divide by 100 to convert % to number
            Double monthlyInterestRate = Double.parseDouble(m_fields[2].getText()) / 1200;
            Double incAmount = monthlyInterestRate + 1.0;

            Double futureValue = incAmount;
            // raising to the power achieved with loop x^3 = x * x * x
            // subtract one from max itteration as no interest is recieved on the 0'th month.
            // time must pass to get interest!
            for(int i = 0; i < (years*12) - 1;i++){
                futureValue *= incAmount;
            }
            futureValue = futureValue * InvestmentAmount;
            m_fields[3].setText(String.format("%.2f", futureValue));
        }
    }
}
