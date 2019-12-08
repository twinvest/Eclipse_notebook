package kr.sist.joba.user.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

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
import kr.sist.joba.order.dao.OrderVO;
import kr.sist.joba.order.dao.ProductDAO;
import kr.sist.joba.store.dao.StoreDAO;
import kr.sist.joba.store.dao.StoreVO;
import kr.sist.joba.user.dao.UserDAO;
import kr.sist.joba.user.dao.UserVO;

public class PaymentController implements Initializable {
	@FXML
	Button btnOrderList, btnCardPay, btnPostPay;
	@FXML
	Text txOrderName01, txOrderName02, txOrderName03, txOrderName04,
		 txOrderCount01, txOrderCount02, txOrderCount03, txOrderCount04,
		 txOrderPrice01, txOrderPrice02, txOrderPrice03, txOrderPrice04,
		 txTotalPrice,
		 txNowPoint, txExpectedPoint,
		 txUserName,
		 txUserArea, txUserAddress,
		 txUserCellPhone,
		 txStoreName;
	
	static ProductDAO productDao = new ProductDAO();
	int sum = 0;
//	int[] count = productDao.getProductCount();
//	int[] price = productDao.getProductPrice();
//	String[] name = productDao.getProductName();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<UserVO> list=readFile("src//data/User.csv");
		
		StoreDAO storeDao = new StoreDAO();
		UserDAO userDao = new UserDAO();
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getUserId().equals(PathData.pId)){
				txUserName.setText(list.get(i).getUserName());
				txUserArea.setText(list.get(i).getUserArea());
				txUserAddress.setText(list.get(i).getUserAddress());
				txUserCellPhone.setText(list.get(i).getUserCellPhone());		
			}
		}
		txStoreName.setText(PathData.pStoreName);
		
		
		txOrderName01.setText(PathData.pProductName[0]);
		txOrderName02.setText(PathData.pProductName[1]);
		txOrderName03.setText(PathData.pProductName[2]);
		txOrderName04.setText(PathData.pProductName[3]);
		txOrderCount01.setText(PathData.pProductCount[0]+"개");
		txOrderCount02.setText(PathData.pProductCount[1]+"개");
		txOrderCount03.setText(PathData.pProductCount[2]+"개");
		txOrderCount04.setText(PathData.pProductCount[3]+"개");
		txOrderPrice01.setText(PathData.pProductPrice[0]+"원");
		txOrderPrice02.setText(PathData.pProductPrice[1]+"원");
		txOrderPrice03.setText(PathData.pProductPrice[2]+"원");
		txOrderPrice04.setText(PathData.pProductPrice[3]+"원");
		
		for(int i=0; i<PathData.pProductPrice.length;i++) {
			sum+=PathData.pProductPrice[i];
		}
		txTotalPrice.setText(sum+"원");
		txNowPoint.setText("5000P");
		txExpectedPoint.setText(sum/10+"P");
		btnOrderList.setOnAction(event -> backOrderListAction(event));
		btnCardPay.setOnAction(event -> btnCardPayAction(event));
		btnPostPay.setOnAction(event -> btnPostPayAction(event));
	}
		
	public void backOrderListAction(ActionEvent event) {
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/order/view/OrderList.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnOrderList.getScene().getWindow();
			primaryStage.setScene(scene);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // backOrderListAction

	public void btnCardPayAction(ActionEvent event) {
		OrderDAO orderDao = new OrderDAO();
        String[] inputData = {"2",orderDao.saveOrderNum(),txUserCellPhone.getText(),"2","6000","아메리카노","park",txStoreName.getText(),"카드","준비중"};
        OrderVO vo = new OrderVO(inputData[0],inputData[1],inputData[2],inputData[3],inputData[4],inputData[5],inputData[6],inputData[7],inputData[8],inputData[9]
        );
        orderDao.do_save(vo);
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/Complete.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnCardPay.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // cardPayAction
	
	public void btnPostPayAction(ActionEvent event) {
		OrderDAO orderDao = new OrderDAO();
        String[] inputData = {"2",orderDao.saveOrderNum(),txUserCellPhone.getText(),"2","6000","아메리카노","park",txStoreName.getText(),"후불","준비중"};
        OrderVO vo = new OrderVO(inputData[0],inputData[1],inputData[2],inputData[3],inputData[4],inputData[5],inputData[6],inputData[7],inputData[8],inputData[9]
        );
        orderDao.do_save(vo);
		try {
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/main/view/Complete.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnPostPay.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} //--backOrderListAction
	 public List<UserVO> readFile(String filePath){
			List<UserVO> addressData=new ArrayList<UserVO>();
			BufferedReader br=null;
			try {
				FileReader fr=new FileReader(filePath);
				br=new BufferedReader(fr);
				String line = "";
				while( (line=br.readLine())!=null ) {
					//홍길동,jamesol@paran.com,16321203,010-1234-5678
					String[] dataArray = line.split(",");
					UserVO vo=new UserVO(dataArray[0],dataArray[1],dataArray[2],dataArray[3]
										,dataArray[4],dataArray[5],dataArray[6],dataArray[7]
										,dataArray[8],dataArray[9],dataArray[10],dataArray[11] );
					addressData.add(vo);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(null !=br) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			return addressData;
		}	
	


}
