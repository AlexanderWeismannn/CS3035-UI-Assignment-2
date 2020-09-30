package part1;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;

public class StyleOptions extends VBox {
    //declares the text field to be changed and the 3 checkboxes
    private Label changeText;
    private CheckBox fontCheckBox, colorCheckBox, underlineCheckBox;




    public StyleOptions(){
        //sets the Text to be "Assignment 2, Part 1" and the font and size
        changeText = new Label("Assignment 2, Part 1");
        changeText.setFont(new Font("Verdana", 36));

        //initializes the checkbox with the name "font" and has it go to processCheckBoxAction when clicked
        fontCheckBox = new CheckBox("font");
        fontCheckBox.setOnAction(this::processCheckBoxAction);


        //initializes the checkbox with the name "color" and has it go to processCheckBoxAction when clicked
        colorCheckBox = new CheckBox("color");
        colorCheckBox.setOnAction(this::processCheckBoxAction);


        //initializes the checkbox with the name "underline" and has it go to processCheckBoxAction when clicked
        underlineCheckBox = new CheckBox("underline");
        underlineCheckBox.setOnAction(this::processCheckBoxAction);




        //initializes the HBox container that will house the 3 checkboxes like so: | -> | -> | and centers the box
        HBox options = new HBox(20,fontCheckBox,colorCheckBox,underlineCheckBox);
        options.setAlignment(Pos.CENTER);

        //spacing between the HBox children and adding the text and HBox to the VBox
        setSpacing(20);
        getChildren().addAll(changeText,options);


    }



    public void processCheckBoxAction(ActionEvent e){

        changeText.setFont(new Font("Verdana", 36));
        changeText.setTextFill(Color.BLACK);
        changeText.setUnderline(false);

        if(fontCheckBox.isSelected()){
            changeText.setFont(new Font("Times New Roman", 36));
        }

        if(colorCheckBox.isSelected()){
            changeText.setTextFill(Color.RED);
        }

        if(underlineCheckBox.isSelected()){
            changeText.setUnderline(true);
        }

    }

}
