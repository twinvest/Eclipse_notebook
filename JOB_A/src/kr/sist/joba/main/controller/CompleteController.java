package kr.sist.joba.main.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import data.PathData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kr.sist.joba.order.dao.OrderDAO;
import kr.sist.joba.order.dao.ProductDAO;
import kr.sist.joba.store.dao.StoreDAO;

public class CompleteController implements Initializable {
	@FXML
	Button btnHome;
	@FXML
	Text txOrderNum,
		 txStoreName,txStoreCellPhone;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		OrderDAO orderDao = new OrderDAO();
		StoreDAO storeDao = new StoreDAO();
		txOrderNum.setText(orderDao.readOrderNumLast());
		txStoreName.setText(PathData.pStoreName);
		txStoreCellPhone.setText(storeDao.readStoreCellPhone(txStoreName.getText()));
		btnHome.setOnAction(event -> btnHomeAction(event));
	}

	public void btnHomeAction(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/Home.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnHome.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // mainOrderListAction

}