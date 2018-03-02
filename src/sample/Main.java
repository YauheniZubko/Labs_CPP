package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

import javafx.scene.Scene;

/**
 * Main class
 *
 * @author ZubDestroy
 * @version 1.0
 */
public class Main extends Application {
    /**
     * @param primaryStage Main stage
     * @throws Exception is smth wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("LABA 1");
        primaryStage.setResizable(false);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 200, 150);
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5, 5, 5, 5));//рамка
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(70);
        gridPane.getColumnConstraints().add(column);

        TextField textField = new TextField();
        gridPane.add(textField, 0, 0);

        Label lb=new Label("БГУИР - стиль жизни");
        gridPane.add(lb,0,3);

        Label biggerNumLabel = new Label();
        gridPane.add(biggerNumLabel, 1, 1);

        Button biggerNumButton = new Button("Генерировать больше");
        
        biggerNumButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Random rnd = new Random();
                int number;
                try
                {
                    number=Integer.parseInt(textField.getText());
                }
                catch(NumberFormatException e){return;}
                if(number==0)
                {
                    biggerNumLabel.setText(String.valueOf(rnd.nextInt(150)-100));
                }else
                if(number<0)
                {
                    biggerNumLabel.setText(String.valueOf(rnd.nextInt(-number)+number));
                }
                else
                biggerNumLabel.setText(String.valueOf(rnd.nextInt(Integer.parseInt(textField.getText()))
                        + Integer.parseInt(textField.getText())));
            }
        });
        gridPane.add(biggerNumButton, 0, 1);

        Label smallerNumLabel = new Label();
        gridPane.add(smallerNumLabel, 1, 2);

        Button smallerNumButton = new Button("Генерировать меньше");
        smallerNumButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Random rnd = new Random();
                int number;
                try
                {
                    number=Integer.parseInt(textField.getText());

                }
                catch(NumberFormatException e){return;}
                if(number==0)
                {
                    smallerNumLabel.setText(String.valueOf(rnd.nextInt(150)-100));
                }else
                if(number<0)
                    smallerNumLabel.setText(String.valueOf(rnd.nextInt(-number)+number));
                else
                    smallerNumLabel.setText(String.valueOf(rnd.nextInt(number)));


            }
        });
        gridPane.add(smallerNumButton, 0, 2);

        root.setCenter(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Init mathods
     *
     * @param args cmdline arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
