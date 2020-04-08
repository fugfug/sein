import java.io.*;
import java.util.*;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class TheSein extends Application{
	
	private final Color ROSE_QUARTZ = Color.rgb(247, 202, 201);
	private final Color SERENITY = Color.rgb(145, 168, 208);
	private Button button;
	private Text text;
	private Scene scene;
	private int clickCount = 0;
	  
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox pane = new VBox();
		pane.setStyle("-fx-background-color: null;");
		pane.setAlignment(Pos.CENTER);
		
		text = new Text("");
		text.setFill(SERENITY);
		text.setFont(Font.font(30));
		pane.getChildren().add(text);
		
		button = new Button("P R E S S M E");
		button.setOnAction(this::handleButton);
		pane.getChildren().add(button);
		
		scene = new Scene(pane, 666, 420);
		scene.setFill(ROSE_QUARTZ);
		
		primaryStage.setTitle("S E I N W A V E");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	// reads in quotes from txt file, adds quotes to list, yada yada yada
	private void quotes() {
		ArrayList<String> quotesList = new ArrayList<String>();
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(new FileReader(new File("sein.txt")));
			
			while(fileScan.hasNext()) {
				String quote = fileScan.nextLine();
				quotesList.add(quote);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			if(fileScan!=null)
				fileScan.close();
		}
		button.setText("M O R E");
		Random generator = new Random();
		int randNum = generator.nextInt(quotesList.size());
		text.setText(quotesList.get(randNum));
		
		
	}
		
		
	private void handleButton(ActionEvent event) {
		clickCount++;
		quotes();
		changeColors();
	}
	
	private void changeColors() {
		if(clickCount % 2 == 0) {
			text.setFill(SERENITY);
			scene.setFill(ROSE_QUARTZ);
		} else {
			text.setFill(ROSE_QUARTZ);
			scene.setFill(SERENITY);
		}
	}
	

	
	public static void main(String[] args) {
		launch(args);

	}



}
