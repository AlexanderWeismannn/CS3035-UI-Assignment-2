package part1;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        //Please complete me.

        //intializes the quit button
        Button quitButton;
        quitButton = new Button("quit");
        quitButton.setOnAction(this::closeButtonAction);

        StyleOptions pane = new StyleOptions();
        pane.getChildren().add(quitButton);
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: white");
        Scene scene = new Scene(pane, 400, 150);


        primaryStage.setTitle("Assignment 2, Part 1");
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
