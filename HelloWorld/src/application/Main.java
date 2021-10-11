package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
    private Text curSize;
    private Text maxSize;
    private int max;
    
    public void start(Stage primaryStage) {
        
        curSize = new Text();
        maxSize = new Text();
        
        
        
        curSize.setText("Current number of students: 0");
        maxSize.setText("Maximum number of students: 0");
        
        LinkedQueue<String>queue = new LinkedQueue<>();
        ListView<String>list = new ListView<>(queue);
        
        TextField input = new TextField();
        
        Button add = new Button();
        Button remove = new Button();
        
        add.setText("Add Student");
        remove.setText("Remove Student");
        
        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                queue.add(input.getText());
                input.setText("");
                input.requestFocus();
                
                setSize(queue.size());
                
                
            }
        });
        
        remove.setOnAction(event ->{
            Stage privelige = new Stage();
            
            GridPane gp = new GridPane();
            gp.setPadding(new Insets(11, 11, 11, 11));
            gp.setVgap(5.5);
            gp.setHgap(5.5);
            
            Text confirmText = new Text();
            confirmText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            confirmText.setText("Confirmation");
            
            gp.add(confirmText, 0, 0);
            
            Label passText = new Label();
            passText.setText("Password: ");
            
            TextField passField = new TextField();
            
            gp.add(passText, 0, 1);
            gp.add(passField, 1, 1);
            
            Button submit = new Button();
            submit.setText("Submit");
            
            submit.setOnAction((ActionEvent sub) ->{
                if(passField.getText().equals("CS1321R0X")) {
                    queue.remove(input.getText());
                    input.setText("");
                    input.requestFocus();
                    
                    setSize(queue.size());
                    privelige.close();
                }
            });
            
            HBox org = new HBox();
            org.setAlignment(Pos.TOP_RIGHT);
            org.getChildren().add(submit);
            
            gp.add(org, 1, 2);
            
            Scene confirmation = new Scene(gp);
            
            privelige.setTitle("Privelige Check");
            privelige.setScene(confirmation);
            privelige.show();
            
        });
        
        HBox bottomBar = new HBox();
        bottomBar.getChildren().addAll(input, add, remove);
        
        VBox allComp = new VBox();
        allComp.getChildren().addAll(curSize, maxSize, list, bottomBar);
        
        
        Scene s = new Scene(allComp);
        
        primaryStage.setScene(s);
        primaryStage.setTitle("CS 1321 Office Hours Queue");
        primaryStage.show();        
        
    }
    
    
    private void setSize(int queueSize) {
        curSize.setText("Current number of students: " + queueSize);
        if(queueSize>max) {
            max = queueSize;
            maxSize.setText("Maximum number of students: " + 
                    queueSize);
        }
    }
    
}