package kr.sist.joba.main.controller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class OrderHistoryMain extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
	      FXMLLoader loader = new FXMLLoader(getClass().getResource("historyorder.fxml"));

	      Parent root = loader.load(); 
	      Scene scene = new Scene(root); 

	      primaryStage.setTitle("TEST"); 
	      primaryStage.setScene(scene);
	      primaryStage.setResizable(false); //
	      primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
