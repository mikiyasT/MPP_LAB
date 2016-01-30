package JavaFxLab;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StringUtility extends Application implements EventHandler{

	Button btnCntLetters = null;
	Button btnRemoveDuplicates = null;
	Button btnReverseLettters = null;
	
	Label lInput = null;
	Label lOutput = null;
	
	TextField txtInput = null;
	TextField txtOutput = null;
	
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(100);		
		grid.setPadding(new Insets(25,25,25,25));
		
		btnCntLetters =  new Button("Count Letters");
		btnRemoveDuplicates = new Button("Remove Dupliates");
		btnReverseLettters = new Button("Reverse Letters");
		lInput = new Label("Input");
		lOutput = new Label("Output");
		txtInput = new TextField();
		txtOutput = new TextField();
		VBox inputBox = new VBox(0);
		//VBox outPutBox = new VBox();
		VBox btnBox = new VBox(10);

		btnBox.getChildren().add(btnCntLetters);
		btnBox.getChildren().add(btnRemoveDuplicates);
		btnBox.getChildren().add(btnReverseLettters);
		
		inputBox.getChildren().add(lInput);
		inputBox.getChildren().add(txtInput);
		inputBox.getChildren().add(lOutput);
		inputBox.getChildren().add(txtOutput);
		grid.add(btnBox,0,0);
		grid.add(inputBox,1,0);
		Scene scene = new Scene(grid,300,250);
		stage.setScene(scene);
		stage.show();
		
	}
	public static void main(String args[]){
		launch(args);
	}
	
}
