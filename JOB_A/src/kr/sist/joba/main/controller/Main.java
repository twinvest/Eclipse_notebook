package kr.sist.joba.main.controller;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Start.fxml"));
		Parent root = loader.load(); 
		Scene scene = new Scene(root); 
	

		primaryStage.setTitle("프로그램"); 
		primaryStage.setScene(scene);
		primaryStage.setResizable(false); //화면 크기 true 고정, false 유동
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

