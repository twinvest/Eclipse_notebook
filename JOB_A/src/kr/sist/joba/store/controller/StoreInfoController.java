package kr.sist.joba.store.controller;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import data.PathData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import kr.sist.joba.store.dao.StoreDAO;
import kr.sist.joba.store.dao.StoreVO;
 
public class StoreInfoController implements Initializable {
	@FXML
	Button btn01, btnBackHome;
	@FXML
	ComboBox<String> comboBox;
	@FXML
	ListView<String> listView;
	
	StoreDAO storeDao = new StoreDAO();

	ObservableList<String> comboList = FXCollections.observableArrayList("마포구", "노원구", "서초구", "강남구");
//	ObservableList<String> comboList = FXCollections.observableArrayList(storeDao.readStoreAreaAll());

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBox.setItems(comboList);
		btn01.setOnAction(event -> btnOrderListAction(event));
		btnBackHome.setOnAction(event -> btnBackHomeAction(event));
	}

	public void comboAction(ActionEvent event) {
		String store = comboBox.getValue();
		if(store.equals("마포구")) {
			ObservableList<String> list01 = FXCollections.observableArrayList("마포점", "홍대점", "마포갈매기점", "삼겹살점");
			listView.setItems(list01);
		} else if(store.equals("노원구")){
			ObservableList<String> list02 = FXCollections.observableArrayList("노원점", "상계점", "중계점", "하계점");
			listView.setItems(list02);
		} else if(store.equals("서초구")){
			ObservableList<String> list03 = FXCollections.observableArrayList("서초점", "서초경찰서점", "서초초초점", "서초장점");
			listView.setItems(list03);
		} else if(store.equals("강남구")){
			ObservableList<String> list04 = FXCollections.observableArrayList("강남점", "갔던점", "갈매기점", "삐약점");
			listView.setItems(list04);
		} else {
			
		}
	}
	
	public void itemSelect() {
		String item = listView.getSelectionModel().getSelectedItem();
		PathData.pStoreName = item;
	}
	
	public void btnBackHomeAction(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/Home.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnBackHome.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void btnOrderListAction(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/order/view/OrderList.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) listView.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
