package kr.sist.joba.user.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import kr.sist.joba.user.dao.UserDAO;
import kr.sist.joba.user.dao.UserVO;

public class SignUpController implements Initializable {
	@FXML
	Button btnBackLogin, btnsignUp, btnCheck;
	@FXML
	TextField userId, userName, userArea, userAddress, userCellPhone;
	@FXML
	PasswordField userPw, userPw2;
	@FXML
	Label signUpMessage;
	
	boolean checkedOne = true;

	private List<UserVO> UserInfo = new ArrayList<UserVO>();
	private final String ADD_FILE = "D:\\Java_20191031\\01_Java\\workspace\\JOB_A\\src\\data\\User.csv";
	UserDAO dao = new UserDAO();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnBackLogin.setOnAction(event -> backLoginAction(event));
		btnsignUp.setOnAction(event -> signUpAction(event));
		btnCheck.setOnAction(event -> btnCheckAction(event));
	}

	public void backLoginAction(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/user/view/Login.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnBackLogin.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // backLoginAction
		
	//ID 중복 확인
	public boolean btnCheckAction(ActionEvent event) {
		boolean check = true;
			if(userId.getText().isEmpty()){
				signUpMessage.setText("ID를 입력해 주세요");
			} else if(dao.idCheck(userId.getText()) == true) {
				signUpMessage.setText("중복된 ID입니다");
				check = true;
			} else if(dao.idCheck(userId.getText()) == false) {
				signUpMessage.setText("사용 가능한 ID입니다");
				check = false;
				checkedOne = false;
			}
		return check;
	} //btnCheckAction

	public void signUpAction(ActionEvent event) {
		char[] chID = userId.getText().toCharArray();
		char[] chPW = userPw.getText().toCharArray();
		String cellPhone = userCellPhone.getText();
				
		//주소 데이터 내에서 시, 구 사이에 스페이스 바가 들어갔는지
		try {
			// 전체 공란 확인
			if (spaceCheck() == false) {
				signUpMessage.setText("공란을 입력해 주세요");
			// PW userPw == userPw2 확인
			} else if(!(userPw.getText().equals(userPw2.getText()))) { 
				signUpMessage.setText("Password가 일치하지 않습니다");
			//아이디 최소 3자~10자
			} else if(!(3<=chID.length && chID.length<=10)) {
				signUpMessage.setText("ID는 최소 3자, 최대 10자입니다");
			//비밀번호 최소 4자~10자	
			} else if(!(4<=chPW.length && chPW.length<=10)) {
				signUpMessage.setText("Password는 최소 4자, 최대 10자입니다");
			//핸드폰 번호 모두 숫자, 최소 10자~11자
			} else if(!(10<=cellPhone.length() && cellPhone.length()<=11)) {
				signUpMessage.setText("휴대폰 번호는 최소 10자입니다");
			} else if(CellPhoneCheck() == false) {
				signUpMessage.setText("휴대폰 번호는 모두 숫자로 입력해 주세요");
			//아이디 중복 체크 검사 확인
			} else if(btnCheckAction(event) == true && checkedOne == true) {
				signUpMessage.setText("ID 중복 체크를 해주세요");
			} else {
				Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/user/view/Login.fxml"));
				Scene scene = new Scene(second);
				Stage primaryStage = (Stage) btnBackLogin.getScene().getWindow();
				primaryStage.setScene(scene);
				//abc,123,이지은,1,1,jamesol01@paran.com,010-1111-1111,서울시 서초구,반포 자이 아파트 103동 502호,1000,20191205,jam
				String[] inputData = {userId.getText(), userPw.getText(), userName.getText(), "1", "1", "0", userCellPhone.getText(), userArea.getText(), userAddress.getText(), "0", "0", "0"};
		        UserVO vo = new UserVO(inputData[0],inputData[1],inputData[2],inputData[3],inputData[4],inputData[5],inputData[6], inputData[7], inputData[8], inputData[9], inputData[10], inputData[11]);
				dao.do_save(vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // signUpAction

	/**공란 확인*/
	public boolean spaceCheck() {
		boolean check = true;
		// userId, userPw, userPw2, userName, userArea, userAddress, userCellPhone
		if (userId.getText().isEmpty() || userPw.getText().isEmpty() || userPw2.getText().isEmpty()
		|| userName.getText().isEmpty() || userArea.getText().isEmpty() 
		|| userAddress.getText().isEmpty() || userCellPhone.getText().isEmpty()) {
			check = false;
		}
		return check;
	}
	
	/**휴대폰 번호가 모두 숫자인지 확인*/
	public boolean CellPhoneCheck() {
		boolean isNumber = true;
		String cellPhone = userCellPhone.getText();
		char cellPhoneCh = ' ';
		for(int i=0; i<cellPhone.length(); i++) {
			//숫자인지 비교
			cellPhoneCh = cellPhone.charAt(i);
			if(!('0'<=cellPhoneCh && cellPhoneCh<='9')) {
				isNumber = false;
				break;
			}
		}
		return isNumber;
	}

}