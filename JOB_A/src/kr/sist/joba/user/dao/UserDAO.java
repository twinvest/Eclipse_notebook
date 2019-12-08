package kr.sist.joba.user.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.DTO;
import data.WorkDiv;

public class UserDAO implements WorkDiv {
	
	private List<UserVO> UserInfo = new ArrayList<UserVO>();
	private final String ADD_FILE = "src/data/User.csv";
	
	public UserDAO() {
		UserInfo = readFile(ADD_FILE);
	}
	
		
	


	public List<UserVO> readFile(String filePath){
		List<UserVO> UserData = new ArrayList<UserVO>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = "";
			while((line=br.readLine()) != null) {
				//번호, ID, PW, 이름, 주소, 상세주소, 핸드폰 번호, 마일리지
				String[] dataArray = line.split(",");
				UserVO vo = new UserVO(dataArray[0],dataArray[1],dataArray[2],dataArray[3],dataArray[4],dataArray[5],dataArray[6],dataArray[7],dataArray[8],dataArray[9],dataArray[10],dataArray[11]);
				UserData.add(vo);
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
		return UserData;
	}

	public int saveFile(String path)  {
		File file = new File(path);
		FileWriter writer = null;
		BufferedWriter bw = null;

		int cnt = 0;
		try {
			writer = new FileWriter(file);
			bw = new BufferedWriter(writer);
	        
			for(int i=0;i<UserInfo.size();i++) {
				UserVO vo =UserInfo.get(i);
				//쉼표, 개행 추가
				StringBuilder sb=new StringBuilder();
				//abc,123,이지은,1,1,jamesol01@paran.com,010-1111-1111,서울시 서초구,반포 자이 아파트 103동 502호,1000,20191205,jam
				sb.append(vo.getUserId()+","+vo.getUserPw()+","+vo.getUserName()+","+vo.getUserAuthority()+","+vo.getTeamNum()+","+vo.getUserEmail()+","+vo.getUserCellPhone()+","+vo.getUserArea()+","+vo.getUserAddress()+","+vo.getUserPoint()+","+vo.getUserRegistration()+","+vo.getUserRegistId());
				//마지막 라인에 "\n" 제거
				if((i+1)!=UserInfo.size()) {
					sb.append("\n");
				} //if
				cnt++;
				bw.write(sb.toString());
			} //for
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
	
	@Override
	public int do_save(DTO dto) {
		UserVO vo = (UserVO) dto;
		UserInfo.add(vo);
		int saveCnt = saveFile(ADD_FILE);
		return saveCnt;
	}

	@Override
	public int do_update(DTO dto) {
		int cnt = 0;
		return cnt;
	}

	@Override
	public int do_delete(DTO dto) {
		int cnt = 0;
		return cnt;
	}

	@Override
	public DTO do_selectOne(DTO dto) {
		UserVO outVO = null;
		return outVO;
	}

	@Override
	public List<?> do_retrieve(DTO dto) {
		List<UserVO> list = new ArrayList<UserVO>();
		return list;
	}
	
	/**ID 중복 체크 메소드*/
	public boolean idCheck(String inputId) {
		boolean check = true;
		for(int i=0; i<UserInfo.size(); i++) {
			UserVO idVO = UserInfo.get(i);
			if(!(idVO.getUserId().equals(inputId))) {
				check = false;
				break;
			} else {
				check = true;
				break;
			}
		}
		return check;
	}
	
	public String readUserArea(String ab) {
		String xb = null;
		for(int i=0;i<UserInfo.size();i++) {
			UserVO vo = UserInfo.get(i);
			if(vo.getUserName().equals(ab)) {
				xb = vo.getUserArea();
			}
		}
		return xb;
	}
	
	public String readUserAddress(String ab) {
		String xb = null;
		for(int i=0;i<UserInfo.size();i++) {
			UserVO vo = UserInfo.get(i);
			if(vo.getUserName().equals(ab)) {
				xb = vo.getUserAddress();
			}
		}
		return xb;
	}
	
	public String readUserCellPhone(String ab) {
		String xb = null;
		for(int i=0;i<UserInfo.size();i++) {
			UserVO vo = UserInfo.get(i);
			if(vo.getUserName().equals(ab)) {
				xb = vo.getUserCellPhone();
			}
		}
		return xb;
	}
}
