package kr.sist.joba.store.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.DTO;
import data.WorkDiv;
import kr.sist.joba.store.dao.StoreVO;

public class StoreDAO implements WorkDiv {

	private List<StoreVO> addressBook = new ArrayList<StoreVO>();
	private final String ADD_FILE = "src/data/Store.csv";

	public StoreDAO() {
		addressBook = readFile01(ADD_FILE);
	}

	public List<StoreVO> readFile01(String filePath) {
		List<StoreVO> addressData = new ArrayList<StoreVO>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				// 홍길동,jamesol@paran.com,16321203,010-1234-5678
				String[] dataArray = line.split(",");
				StoreVO vo = new StoreVO(dataArray[0], dataArray[1], dataArray[2]);
				addressData.add(vo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return addressData;
	}//--readFile02
	
	static ArrayList<StoreVO> readFile02(String path) {
		ArrayList<StoreVO> list = new ArrayList<StoreVO>();
		try {
			Scanner scanner = new Scanner(new File(path));
			while (scanner.hasNextLine()) {
				String input = scanner.nextLine();
	            //System.out.println(input);
	            String[] inArray = input.split(",");
	            StoreVO dto = new StoreVO(inArray[0], inArray[1], inArray[2]);
	            list.add(dto);
	        } //while
		} catch (FileNotFoundException e) {
			e.printStackTrace();
	    }
	      return list;
	} //--readFile02

	@Override
	public int do_save(DTO dto) {
		return 0;
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
	
	public String readStoreCellPhone(String ab) {
		String xb = null;
		for (int i = 0; i < addressBook.size(); i++) {
			StoreVO vo = addressBook.get(i);
			if (vo.getStoreName().equals(ab)) {
				xb = vo.getStoreCellPhone();
			}
		}
		return xb;
	}
}
