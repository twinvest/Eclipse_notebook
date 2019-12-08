package kr.sist.joba.order.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import data.PathData;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import kr.sist.joba.order.dao.PaymentDataDAO;
import kr.sist.joba.order.dao.ProductDAO;


public class OrderController implements Initializable{
	
	@FXML private Button btnToPayment;
	@FXML private Button btnBackStore;
	@FXML private VBox americano, cafelatte, mocachoco, haezelnut,
						strawberrySmoothe, grapeAde, hotChoco,
						lemoneAde, chocoCake, tiramishu, strawberryCake;

	@FXML public ImageView 	americanoPlus,cafelattePlus,mocachocoPlus,haezelnutPlus,
							strawberrySmoothePlus,grapeAdePlus,hotChocoPlus,
							lemoneAdePlus,chocoCakePlus,tiramishuPlus,strawberryCakePlus,
							americanoMinus,cafelatteMinus,mocachocoMinus,haezelnutMinus,
							strawberrySmootheMinus,grapeAdeMinus,hotChocoMinus,
							lemoneAdeMinus,chocoCakeMinus,tiramishuMinus,strawberryCakeMinus;

	@FXML public Label orderProduct1;
	@FXML public Label productCount1;
	@FXML private Label productPrice1;

	@FXML public Label orderProduct2;
	@FXML public Label productCount2;
	@FXML private Label productPrice2;

	@FXML public Label orderProduct3;
	@FXML public Label productCount3;
	@FXML private Label productPrice3;
	
	@FXML public Label orderProduct4;
	@FXML public Label productCount4;
	@FXML private Label productPrice4;
	
	
	@FXML private Label americanoId,cafelatteId,mocachocoId,haezelnutId,
						strawberrySmootheId,grapeAdeId,hotChocoId,
						lemoneAdeId,chocoCakeId,tiramishuId,strawberryCakeId;
	
	boolean orderChecked1=true;
	boolean orderChecked2=true;
	boolean orderChecked3=true;
	boolean orderChecked4=true;
	boolean fullorderList=true;
	
	@FXML private ImageView orderImg1;
	@FXML private ImageView orderImg2;
	@FXML private ImageView orderImg3;
	@FXML private ImageView orderImg4;

	static List<ProductDAO> addressBook=new ArrayList<ProductDAO>();
	static List<PaymentDataDAO> paymentData=new ArrayList<PaymentDataDAO>();
	static ProductDAO dao=new ProductDAO();
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		//Payment에서 주문내역을 저장하기위해서 PathData값을 처음에 불러옴
		orderInitialize(orderProduct1,productCount1,productPrice1,orderImg1,0);
		orderInitialize(orderProduct2,productCount2,productPrice2,orderImg2,1);
		orderInitialize(orderProduct3,productCount3,productPrice3,orderImg3,2);
		orderInitialize(orderProduct4,productCount4,productPrice4,orderImg4,3);
		
		
		addressBook=readFile("src\\data\\product.csv");
		btnToPayment.setOnAction(e->handleBtnLogin(e));//Payment로 가거라 
		btnBackStore.setOnAction(e->handleBackStore(e));//뒤로가기
		
		//마지막 OrderList가 false값이 아닐때만 Plus버튼 작동 
		if(fullorderList) {
		countUpImage(americano,americanoId);
		countUpImage(cafelatte,cafelatteId);
		countUpImage(mocachoco,mocachocoId);
		countUpImage(haezelnut,haezelnutId);
		countUpImage(strawberrySmoothe,strawberrySmootheId);
		countUpImage(grapeAde,grapeAdeId);
		countUpImage(hotChoco,hotChocoId);
		countUpImage(lemoneAde,lemoneAdeId);
		countUpImage(chocoCake,chocoCakeId);
		countUpImage(tiramishu,tiramishuId);
		countUpImage(strawberryCake,strawberryCakeId);
		}else {
			try {
				
				Parent popUp;
				popUp = FXMLLoader.load(getClass().getResource("/kr/sist/joba/user/view/Payment.fxml"));
				Scene scene = new Scene(popUp);
				Stage primaryStage = (Stage) btnToPayment.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
	}

	private void orderInitialize(Label orderProductName, Label productCount, Label productPrice, ImageView orderImg,int index) {
		orderProductName.setText(PathData.pProductName[index]);
		productCount.setText(PathData.pProductCount[index]+"");
		productPrice.setText(PathData.pProductPrice[index]+"");
		Image image = new Image(PathData.pOrderImg[index]);
		orderImg.setImage(image);
	}

	private void countUpImage(VBox plusImageView, Label productLabel) {
		plusImageView.setOnMousePressed(new EventHandler() {
			@Override
			public void handle(Event event) {
				orderListCheck(productLabel);
			}
		});
	}

	private void handleBtnLogin(ActionEvent event) {
		try {
			
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/user/view/Payment.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnToPayment.getScene().getWindow();
			primaryStage.setScene(scene);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void handleBackStore(ActionEvent event) {
		try 
		{	
			Parent second = FXMLLoader.load(getClass().getResource("/kr/sist/joba/store/view/StoreInfo.fxml"));
			Scene scene = new Scene(second);
			Stage primaryStage = (Stage) btnBackStore.getScene().getWindow();
			primaryStage.setScene(scene);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//PathData에 order항목을 하나씩 저장하는 메소드
	 void orderListSetting(Label name,Label count,Label price,ImageView img,String productName, int index )  {
		 PathData.pProductName[index]=productName;
		 name.setText(PathData.pProductName[index]);
		
		for(int i=0; i<addressBook.size(); i++) {
			if(addressBook.get(i).getProductName().equals(productName)){
				PathData.pProductCount[index]=PathData.pProductCount[index]+1;
				count.setText((PathData.pProductCount[index]) +"");
				
				price.setText(addressBook.get(i).getProductPrice()*PathData.pProductCount[index]+"원");
				PathData.pProductPrice[index]=addressBook.get(i).getProductPrice()*PathData.pProductCount[index];
				Image image = new Image(addressBook.get(i).getImgName());
				PathData.pOrderImg[index]=addressBook.get(i).getImgName();
				img.setImage(image);
			}	
		}
	}
	 
	 
	 public List<ProductDAO> readFile(String filePath){
			List<ProductDAO> addressData=new ArrayList<ProductDAO>();
			BufferedReader br=null;
			try {
				FileReader fr=new FileReader(filePath);
				br=new BufferedReader(fr);
				String line = "";
				while( (line=br.readLine())!=null ) {
					//홍길동,jamesol@paran.com,16321203,010-1234-5678
					String[] dataArray = line.split(",");
					ProductDAO vo=new ProductDAO(dataArray[0],Integer.parseInt(dataArray[1]),dataArray[2]);
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
	 
	 public List<PaymentDataDAO> readPaymentFile(String filePath){
			List<PaymentDataDAO> addressData=new ArrayList<PaymentDataDAO>();
			BufferedReader br=null;
			try {
				FileReader fr=new FileReader(filePath);
				br=new BufferedReader(fr);
				String line = "";
				while( (line=br.readLine())!=null ) {
					//홍길동,jamesol@paran.com,16321203,010-1234-5678
					String[] dataArray = line.split(",");
					PaymentDataDAO vo=new PaymentDataDAO(dataArray[0],Integer.parseInt(dataArray[1]));
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
	 
	 private void orderListCheck(Label vboxProductName) {

			if(orderProduct1.getText().equals(vboxProductName.getText())||orderChecked1) {
				orderListSetting(orderProduct1, productCount1, productPrice1,orderImg1,vboxProductName.getText(),0);
				orderChecked1=false;
				
			}else if(orderProduct2.getText().equals(vboxProductName.getText())||orderChecked2) {
				orderListSetting(orderProduct2, productCount2, productPrice2,orderImg2,vboxProductName.getText(),1);
				orderChecked2=false;
				
			}else if(orderProduct3.getText().equals(vboxProductName.getText())||orderChecked3) {
				orderListSetting(orderProduct3, productCount3, productPrice3,orderImg3,vboxProductName.getText(),2);
				orderChecked3=false;
				
			}else if(orderProduct3.getText().equals(vboxProductName.getText())||orderChecked3){
				orderListSetting(orderProduct4, productCount4, productPrice4,orderImg4,vboxProductName.getText(),3);
				orderChecked4=false;	
			}
		}

		
	 
	 public int saveFile(String path, String productName, int productCount)  {
			int cnt = 0;
			FileWriter writer =null;
			BufferedWriter  bw=null;
			File file=new File(path);
			
			try {
				writer = new FileWriter(file);
				bw     = new BufferedWriter(writer);
				
				//--------------------------------------
				for(int i=0;i<4;i++) {
					
					StringBuilder sb=new StringBuilder();
					
					sb.append(productName+","+productCount);
					
					//마지막 라인에 "\n" 제거
					if((i+1)!=4) {
						sb.append("\n");
					}
					
					cnt++;
					bw.write(sb.toString());
					
				}
			//--------------------------------------
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					
					if(null !=bw) {
						bw.close();
					}					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return cnt;
		}
	}
	


