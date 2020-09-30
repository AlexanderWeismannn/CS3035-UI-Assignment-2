package part2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;




public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //You, complete me! (Thank YOU!)

        //Titles the stage
        primaryStage.setTitle("Assignment 2, Part 2");

        //Initializes the Label that will be changed with the MyCheckBox controllers
        Label textString = new Label("Assignment 2, Part 2");
        textString.setFont(new Font("Verdana", 36));

        //Initialzes the 3 checkboxes and labels to go along with them
        MyCheckBox fontCheckBox = new MyCheckBox();
        MyCheckBox colorCheckBox = new MyCheckBox();
        MyCheckBox underlineCheckBox = new MyCheckBox();
        Label fontLabel = new Label("font");
        Label colorLabel = new Label("color");
        Label underlineLabel = new Label("under");



        //Initializes the quit button
        Button quitButton = new Button("quit");
        quitButton.setOnAction(this::closeButtonAction);

        //Initializes the event listeners for each checkbox and the following methods they should call
        fontCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(fontCheckBox.isSelected()){
                    textString.setFont(new Font("Times New Roman", 36));
                }else{
                    textString.setFont(new Font("Verdana", 36));


                }
            }
        });

        colorCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
               if(colorCheckBox.isSelected()){
                   textString.setTextFill(Color.RED);
               }else{
                   textString.setTextFill(Color.BLACK);

               }
            }
        });

        underlineCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if(underlineCheckBox.isSelected()){
                    textString.setUnderline(true);
                }else{
                    textString.setUnderline(false);

                }
            }
        });



        //creates an HBox to house the check boxes and labels, adds the children, and centers them.
        HBox checkBoxes = new HBox();
        checkBoxes.getChildren().addAll(fontCheckBox,fontLabel,colorCheckBox,colorLabel,underlineCheckBox,underlineLabel);
        checkBoxes.setAlignment(Pos.CENTER);

        //Creates a VBox to house the Label -> HBox -> Button, aligns it and spaces it
        VBox container = new VBox();
        container.getChildren().addAll(textString,checkBoxes, quitButton);
        container.setAlignment(Pos.CENTER);
        container.setSpacing(10);


        //creates the scene sets the stage
        Scene scene = new Scene(container, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void closeButtonAction(ActionEvent e) {
        System.out.println("Goodbye!");
        Platform.exit();
    }






    public static void main(String[] args) {
        launch(args);
    }
}
