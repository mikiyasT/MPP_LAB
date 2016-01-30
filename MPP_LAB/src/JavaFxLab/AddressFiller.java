package JavaFxLab;


import java.awt.event.ActionListener;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddressFiller extends Application implements EventHandler{

	
	Button btnSubmit = null;
	Label lName = null;
	Label lStreet = null;
	Label lCity = null;
	Label lState = null;
	Label lZip = null;
	
	TextField txtZip = null;
	TextField txtName = null;
	TextField txtCity = null;
	TextField txtState = null;
	
	@Override
	public void start(Stage stage) throws Exception {
		FlowPane fp = new FlowPane();
		fp.setHgap(10);
		fp.setVgap(10);
		fp.setAlignment(Pos.CENTER);
		VBox nameBox = new VBox();
		lName = new Label("Name");
		txtName = new TextField();
		nameBox.getChildren().add(lName);
		nameBox.getChildren().add(txtName);
		
		VBox streetBox = new VBox();
		lStreet = new Label("Street");
		TextField txtStreet = new TextField();
		streetBox.getChildren().add(lStreet);
		streetBox.getChildren().add(txtStreet);
		
		VBox cityBox = new VBox();
		lCity = new Label("Street");
		txtCity = new TextField();
		cityBox.getChildren().add(lCity);
		cityBox.getChildren().add(txtCity);
		
		VBox stateBox = new VBox();
		lState = new Label("State");
		txtState = new TextField();
		stateBox.getChildren().add(lState);
		stateBox.getChildren().add(txtState);
		
		VBox zipBox = new VBox();
		lZip = new Label("State");
		txtZip = new TextField();
		zipBox.getChildren().add(lZip);
		zipBox.getChildren().add(txtZip);
		
		
		fp.getChildren().add(nameBox);
		fp.getChildren().add(streetBox);
		fp.getChildren().add(cityBox);
		fp.getChildren().add(stateBox);
		fp.getChildren().add(zipBox);
		
		btnSubmit = new Button("Submit");
		btnSubmit.setOnAction(this);
		
		fp.getChildren().add(btnSubmit);
		stage.setTitle("Address Form");
		
		Scene scene = new Scene(fp,400,300);
		stage.setScene(scene);
		stage.show();	
		
	}

	@Override
	public void handle(Event evt) {
		if(evt.getSource() == btnSubmit){
			System.out.println(txtZip.getText() + " " + txtName.getText() + " " + txtCity.getText() + " "
					+ txtState.getText());
		}
		
	}
	public static void main(String args[]){
		launch(args);
	}
	

}
