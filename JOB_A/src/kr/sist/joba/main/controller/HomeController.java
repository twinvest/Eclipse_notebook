package kr.sist.joba.main.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeController implements Initializable {
	@FXML
	Label lbMyPage, lbOrders;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lbMyPage.setOnMousePressed(event -> myPageAction(event));
		lbOrders.setOnMousePressed(event -> orderAction(event));
	}

	
	private void myPageAction(MouseEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/MyPage.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) lbMyPage.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // myPageAction

	private void orderAction(MouseEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/store/view/StoreInfo.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) lbOrders.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // orderAction
	
}
