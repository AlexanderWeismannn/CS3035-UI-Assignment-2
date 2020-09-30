package part2;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;


public class MyCheckBox extends Pane {

    //private Label textLabel, fontLabel, colorLabel, underlineLabel;
    private Canvas canvas;
    private SimpleBooleanProperty checked;
    //private Button quitButton;



    public MyCheckBox()
    {
        super();
        checked = new SimpleBooleanProperty();
        canvas = new Canvas(50,50);

        GraphicsContext gc = canvas.getGraphicsContext2D();


        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeRect(25, 18, 20, 20);

        getChildren().add(canvas);

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                if(isSelected()){
                    gc.clearRect(28,20,15,15);
                    setSelected(!isSelected());
                }else{
                    greyCross(gc);
                    setSelected(!isSelected());
                }


            }
        });

    }

    public void greyCross(GraphicsContext gc){
        gc.setStroke(Color.GREY);
        gc.setLineWidth(2);
        gc.strokeLine(28,22,42,34);
        gc.strokeLine(28,34,42,22);

    }

    public BooleanProperty selectedProperty(){
        return checked;
    }

    public boolean isSelected(){
        return checked.getValue();
    }

    public void setSelected(boolean selected){
        checked.setValue(selected);
    }













}
