package kr.sist.joba.user.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kr.sist.joba.user.dao.UserVO;

public class LoginController implements Initializable {

	@FXML Button btnBackStart, btnSignUp, btnLogin;
	@FXML TextField logID;
	@FXML PasswordField logPW;
	@FXML Label lbMessage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnBackStart.setOnAction(event -> backStartAction(event));
		btnSignUp.setOnAction(event -> signUpAction(event));
		btnLogin.setOnAction(event -> toHomeAction(event));
	}

	public void backStartAction(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/Start.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnBackStart.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	} //backStartAction
	
	public void signUpAction(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("../view/SignUp.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnSignUp.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	} //signUpAction
	
	public void toHomeAction(ActionEvent event) {
		ArrayList<UserVO> list = readFile("src/data/User.csv");
//		System.out.println(logID.getText());
		try {
			for(int i=0; i<list.size(); i++) {
				if(logID.getText().isEmpty() && logPW.getText().isEmpty()) {
					lbMessage.setText("ID와 Password를 입력해 주세요");
				} else if(logID.getText().equals(list.get(i).getUserId()) && logPW.getText().equals(list.get(i).getUserPw())) {
					Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/Home.fxml"));
					Scene scene = new Scene(second);
					Stage primaryStage = (Stage) btnLogin.getScene().getWindow();
					primaryStage.setScene(scene);
				} else {
					lbMessage.setText("ID와 Password가 잘못 되었습니다");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} //toHomeAction
	
	static ArrayList<UserVO> readFile(String path) {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		try {
			Scanner scanner = new Scanner(new File(path));
			while (scanner.hasNextLine()) {
				String input = scanner.nextLine();
				//System.out.println(input);
				String[] inArray = input.split(",");
				UserVO dto = new UserVO(inArray[0], inArray[1], inArray[2], inArray[3], inArray[4], inArray[5], inArray[6], inArray[7], inArray[8], inArray[8], inArray[10], inArray[11]);
				list.add(dto);
			} //while

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
