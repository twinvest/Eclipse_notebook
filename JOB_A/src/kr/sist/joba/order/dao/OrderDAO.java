package kr.sist.joba.order.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.DTO;
import data.WorkDiv;

public class OrderDAO implements WorkDiv {

	private List<OrderVO> addressBook = new ArrayList<OrderVO>();
	private final String ADD_FILE = "src/data/Order.csv";
	
	public OrderDAO() {
		addressBook = readFile(ADD_FILE);
	}
	
	public int saveFile(String path)  {
		File file = new File(path);
		FileWriter      fw = null;
		BufferedWriter  bw = null;
		int flag = 0;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
		//--------------------------------------
			for(int i=0;i<addressBook.size();i++) {
				OrderVO vo = addressBook.get(i);
				StringBuilder sb = new StringBuilder();
				sb.append(vo.getSerialNum()+","+
						  vo.getOrderNum()+","+
						  vo.getUserCellPhone()+","+
						  vo.getOrderCount()+","+
						  vo.getOrderPrice()+","+
						  vo.getProductName()+","+
						  vo.getUserId()+","+
						  vo.getStoreName()+","+
						  vo.getOrderDivision()+","+
						  vo.getOrderPreparing()
				);
				//마지막 라인에 "\n" 제거
				if((i+1) != addressBook.size()) {
					sb.append("\n");
				}
				flag++;
				bw.write(sb.toString());
			}
		//--------------------------------------
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}					
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public List<OrderVO> readFile(String filePath){
		List<OrderVO> addressData = new ArrayList<OrderVO>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = "";
			while( (line=br.readLine()) != null ) {
				//홍길동,jamesol@paran.com,16321203,010-1234-5678
				String[] dataArray = line.split(",");
				OrderVO vo = new OrderVO(dataArray[0],
										 dataArray[1],
										 dataArray[2],
										 dataArray[3],
										 dataArray[4],
										 dataArray[5],
										 dataArray[6],
										 dataArray[7],
										 dataArray[8],
										 dataArray[9]
										 
				);
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
	
	public String saveOrderNum() {
		Date date01 = new Date();
		SimpleDateFormat date = new SimpleDateFormat("YYYYMMdd");
		OrderVO vo = null;
		for(int i=0;i<addressBook.size();i++) {
			vo = addressBook.get(i);
		}
		String ab = date.format(date01);
		String bb = vo.getOrderNum().substring(8,12);
		if(date.format(date01).equals(vo.getOrderNum().substring(0,8))) {
			int cb = Integer.parseInt(bb)+1;
			String db = Integer.toString(cb);
			return ab+db;
		} else {
			return ab+1001;
		}
	}
	
	public String readOrderNumLast() {
		String xb = null;
		for(int i=0;i<addressBook.size();i++) {
			OrderVO vo = addressBook.get(i);
				xb = vo.getOrderNum();
		}
		return xb;
	}
	
	@Override
	public int do_save(DTO dto) {
		OrderVO vo = (OrderVO)dto;
		addressBook.add(vo);
		int flag = saveFile(ADD_FILE);
		return flag;
	}
	
	@Override
	public List<?> do_retrieve(DTO dto) {
		return null;
	}
	
	@Override
	public DTO do_selectOne(DTO dto) {
		return null;
	}
	
	@Override
	public int do_update(DTO dto) {
		return 0;
	}

	@Override
	public int do_delete(DTO dto) {
		return 0;
	}
}
