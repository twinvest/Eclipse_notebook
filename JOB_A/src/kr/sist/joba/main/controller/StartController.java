package kr.sist.joba.main.controller;


import java.io.*;
import java.net.*;
import java.util.*;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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

public class StartController implements Initializable {

	@FXML
	Label lbLogin, lbNonMember, lbSignUp;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbLogin.setOnMousePressed(event -> lbLoginAction(event));
		lbNonMember.setOnMousePressed(event -> lbNonMemAction(event));
		lbSignUp.setOnMousePressed(event -> lbSignUpAction(event));
	}

	private void lbLoginAction(MouseEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/user/view/Login.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) lbLogin.getScene().getWindow();
			primaryStage.setScene(scene);
			} catch (IOException e) {
			e.printStackTrace();
		}	
	} //lbLoginAction
	
	private void lbNonMemAction(MouseEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/user/view/NonMember.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) lbNonMember.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	} //lbNonMemAction
	
	private void lbSignUpAction(MouseEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/user/view/SignUp.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) lbSignUp.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	} //lbNonMemAction
	
}
