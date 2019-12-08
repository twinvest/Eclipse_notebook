package kr.sist.joba.user.controller;


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

public class NonMemController implements Initializable {

	@FXML
	Button btnNBackStart, btnNSignUp,btnToStoreInfo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnNBackStart.setOnAction(event -> nBackStartAction(event));
		btnNSignUp.setOnAction(event -> nSignUpAction(event));
		btnToStoreInfo.setOnAction(event -> toStoreInfo(event));
	}

	
	public void nBackStartAction(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/Start.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnNBackStart.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	} //nBackStartAction
	
	public void nSignUpAction(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("../view/SignUp.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnNSignUp.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	} //nSignUpAction
	
	public void toStoreInfo(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/Home.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnToStoreInfo.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	} //toStoreInfo
}
