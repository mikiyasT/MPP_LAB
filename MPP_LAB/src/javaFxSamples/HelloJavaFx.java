package javaFxSamples;



import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloJavaFx extends Application implements EventHandler{

	Button btn = null;
	Text actionTarget = null;
	@Override	
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello Java Fx");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		grid.setPadding(new Insets(25,25,25,25));
		
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle,0,0,2,1);
		Label userName = new Label("Usern Name");
		grid.add(userName,0,1);
		TextField userTextField = new TextField();
		grid.add(userTextField, 1,1);
		Label pswd = new Label("Passsword");
		grid.add(pswd,0,2);
		TextField userPswdField = new PasswordField();
		grid.add(userPswdField, 1,2);
		
		btn = new Button("Hell JavaFx");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn,1,3);
		//grid.setGridLinesVisible(true);
		actionTarget = new Text();
		grid.add(actionTarget,1,6);

		//event handing by implementing event hander method.
		//btn.setOnAction(this);
		
		// by lambda expression
		btn.setOnAction(evt->{actionTarget.setFill(Color.FIREBRICK); actionTarget.setText("Sign in button pressed");});
		Scene scene = new Scene(grid,250,200);
		scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
		stage.setScene(scene);
		
		stage.show();
		
	}
	
	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void handle(Event event) {
		if(event.getSource() == btn){
			actionTarget.setFill(Color.FIREBRICK);
			actionTarget.setText("Sign in button pressed");

		}
		
	}

}
