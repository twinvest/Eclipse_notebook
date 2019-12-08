package kr.sist.joba.orderhistory.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import kr.sist.joba.orderhistory.dao.OrderDAO;

public class HistoryOrderController implements Initializable {

	@FXML
	Label storeLabel;
	@FXML
	ComboBox<String> comboBox;
	@FXML
	ListView<String> listView;

	ObservableList<String> comboList = FXCollections.observableArrayList("1월", "2월", "3월", "4월","5월","6월","7월","8월","9월","10월","11월","12월");
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		ArrayList<OrderDAO> list = readFile("src\\data\\orderhistory.csv");
		comboBox.setItems(comboList);
		storeLabel.setText(comboBox.getValue());
//		System.out.println(list.get(0).getOrderNum());
	}
		
//	public void itemSelect() {
//		String item = listView.getSelectionModel().getSelectedItem();
//	}
	
	
	public void comboAction(ActionEvent event) {
		ArrayList<OrderDAO> list = readFile("src\\data\\orderhistory.csv");
		String store = storeLabel.getText();
		storeLabel.setText(comboBox.getValue());
		
		
		listView.getItems().clear();
		for(int i=0; i<list.size();i++) {
			
			if(methodTest(list.get(i).getOrderNum(),comboBox.getValue())) {
				
				ObservableList<String> list01 = FXCollections.observableArrayList(list.get(i).toString());
				//listView.setItems(list01);
				listView.getItems().addAll(list01);
				
				}
				
			
			
			
		}
		
		
		
		
//		if(store.equals("1월")) {
//			ObservableList<String> list01 = FXCollections.observableArrayList(list.get(0).toString(),list.get(0).toString(),list.get(2).toString(),list.get(3).toString(),list.get(4).toString(),list.get(5).toString(),list.get(6).toString(),list.get(7).toString(),list.get(8).toString(),list.get(9).toString(),list.get(10).toString(),list.get(11).toString());
//			listView.setItems(list01);			
//		} else if(store.equals("2월")){
//			ObservableList<String> list02 = FXCollections.observableArrayList(list.get(12).toString(),list.get(13).toString(),list.get(14).toString(),list.get(15).toString(),list.get(16).toString(),list.get(17).toString(),list.get(18).toString(),list.get(19).toString(),list.get(20).toString(),list.get(21).toString(),list.get(22).toString(),list.get(23).toString());
//			listView.setItems(list02);
//		} else if(store.equals("3월")){
//			ObservableList<String> list03 = FXCollections.observableArrayList(list.get(24).toString(),list.get(25).toString(),list.get(26).toString(),list.get(27).toString(),list.get(28).toString(),list.get(29).toString(),list.get(30).toString(),list.get(31).toString(),list.get(32).toString(),list.get(33).toString(),list.get(34).toString(),list.get(35).toString());
//			listView.setItems(list03);
//		} else if(store.equals("4월")){
//			ObservableList<String> list04 = FXCollections.observableArrayList(list.get(36).toString(),list.get(37).toString(),list.get(38).toString(),list.get(39).toString(),list.get(40).toString(),list.get(41).toString(),list.get(42).toString(),list.get(43).toString(),list.get(44).toString(),list.get(45).toString(),list.get(46).toString(),list.get(47).toString());
//			listView.setItems(list04);
//		} else if(store.equals("5월")){
//			ObservableList<String> list05 = FXCollections.observableArrayList(list.get(48).toString(),list.get(49).toString(),list.get(50).toString(),list.get(51).toString(),list.get(52).toString(),list.get(53).toString(),list.get(54).toString(),list.get(55).toString(),list.get(56).toString(),list.get(57).toString(),list.get(58).toString(),list.get(59).toString());
//			listView.setItems(list05);
//		}else if(store.equals("6월")){
//			ObservableList<String> list06 = FXCollections.observableArrayList(list.get(60).toString(),list.get(61).toString(),list.get(62).toString(),list.get(63).toString(),list.get(64).toString(),list.get(65).toString(),list.get(66).toString(),list.get(67).toString(),list.get(68).toString(),list.get(69).toString(),list.get(70).toString(),list.get(71).toString());
//			listView.setItems(list06);
//		}else if(store.equals("7월")){
//			ObservableList<String> list07 = FXCollections.observableArrayList(list.get(72).toString(),list.get(1).toString(),list.get(2).toString(),list.get(3).toString(),list.get(4).toString(),list.get(6).toString(),list.get(7).toString(),list.get(8).toString(),list.get(9).toString(),list.get(10).toString(),list.get(11).toString(),list.get(6).toString());
//			listView.setItems(list07);
//		}else if(store.equals("8월")){
//			ObservableList<String> list08 = FXCollections.observableArrayList(list.get(84).toString(),list.get(85).toString(),list.get(86).toString(),list.get(87).toString(),list.get(88).toString(),list.get(89).toString(),list.get(90).toString(),list.get(91).toString(),list.get(92).toString(),list.get(93).toString(),list.get(94).toString(),list.get(95).toString());
//			listView.setItems(list08);
//		}else if(store.equals("9")){
//			ObservableList<String> list09 = FXCollections.observableArrayList();
//			listView.setItems(list09);
//		}else if(store.equals("10월")){
//			ObservableList<String> list10 = FXCollections.observableArrayList();
//			listView.setItems(list10);
//		}else if(store.equals("11월")){
//			ObservableList<String> list11 = FXCollections.observableArrayList();
//			listView.setItems(list11);
//		}else if(store.equals("12월")){
//			ObservableList<String> list12 = FXCollections.observableArrayList();
//			listView.setItems(list12);
//		}else {
//			
//		}
		
	}static ArrayList<OrderDAO> readFile(String path) {
		ArrayList<OrderDAO> list = new ArrayList<OrderDAO>();
		try {
			Scanner scanner = new Scanner(new File(path));
			while (scanner.hasNextLine()) {
				String input = scanner.nextLine();
				//System.out.println(input);
				String[] inArray = input.split(",");
				OrderDAO dto = new OrderDAO(Integer.parseInt(inArray[0]),inArray[1], inArray[2], 
					       Integer.parseInt(inArray[3]), Integer.parseInt(inArray[4]),inArray[5]);
				list.add(dto);
			} //while

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
}
	public static boolean methodTest(String test, String test01) {
		
		
		int A = Integer.parseInt(test.substring(4, 6));
		int B = Integer.parseInt(test01.substring(0, test01.lastIndexOf("월")));
		
		
		return A==B;
		
	}
}