package kr.sist.joba.user.controller;


import java.io.*;
import java.net.*;
import java.util.*;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

//import java.io.*;
//import java.net.*;
//import java.util.*;
//
//import javafx.event.*;
//import javafx.fxml.*;
//import javafx.scene.*;
//import javafx.scene.control.*;
//import javafx.stage.*;

public class OrderHistoryController implements Initializable {

	@FXML
	Button toBackHome;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toBackHome.setOnAction(event -> backHome(event));
		
	}

	public void backHome(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/Home.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) toBackHome.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	} //backStartAction
	
	
	
}
