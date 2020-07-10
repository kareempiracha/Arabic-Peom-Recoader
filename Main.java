package application;
	
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.collections.*; 
import javafx.stage.Stage; 
import javafx.scene.text.Text.*; 
import javafx.scene.paint.*; 
import javafx.scene.text.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Main extends Application { 
	String input, type;
	int type_int;
	client obj; 
	@Override
	public void start(Stage primaryStage) {
		try {

			primaryStage.setTitle("Q Dictionary "); 
	        String search_type[] = { "1", "2" }; 
	        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(search_type)); 
	        TextField b = new TextField(); 
	        TableView table = new TableView();
	        Button btn = new Button();
	        Pane pane = new Pane(); 	
	        Label label = new Label();
	        btn.setText("Find");
	        btn.setLayoutX(20);
	        btn.setLayoutY(350);
	        btn.setPrefWidth(260);
	        label.setLayoutX(20);
	        label.setLayoutY(380);
	        label.setPrefWidth(260);
	        label.setAlignment(Pos.CENTER);
	        combo_box.setLayoutX(229);
	        combo_box.setLayoutY(20);
	        b.setLayoutX(20);
	        b.setLayoutY(20);
	        b.setPrefWidth(200);
	        
	        table.setPrefHeight(270);
	        table.setPrefWidth(260);
	        
	        TableColumn firstNameCol = new TableColumn("Word");
	        TableColumn lastNameCol = new TableColumn("Root");
	        TableColumn emailCol = new TableColumn("Found");
	        
	        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
	       
	        final VBox vbox = new VBox();
	        emailCol.setPrefWidth(100);
	        vbox.setPadding(new Insets(60, 0, 0, 20));
	        vbox.getChildren().addAll(table);
	        pane.getChildren().addAll(btn);
	        pane.getChildren().addAll(vbox);
	        pane.getChildren().add(combo_box);
	        pane.getChildren().add(b);
	        pane.getChildren().add(label);
	        
	        primaryStage.setScene(new Scene(pane, 303, 430));
	        primaryStage.show();
	        
	        
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	type = combo_box.getValue().toString();
	            	type_int = Integer.parseInt(type); 
	            	input = b.getText();		
	                label.setText("Data Send to Server");
	                try {
						obj.client_caller(input, type_int);
						if (obj.results.equals(input))
						{
							System.out.println("yes");
						}
					} catch (RemoteException | MalformedURLException | NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                

	            }
	        });
	        
	        
	        
	        
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
