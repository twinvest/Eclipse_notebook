package kr.sist.joba.main.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyPageController implements Initializable {
	@FXML
	Button btnBack;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnBack.setOnAction(event -> backHomeAction(event));
	}

	private void backHomeAction(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/Home.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnBack.getScene().getWindow();
			primaryStage.setScene(scene);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // backHomeAction
}
