import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {

	public static List<List<String>> processExcel(String path) throws UnsupportedEncodingException, FileNotFoundException{
		List<List<String>> ret = new ArrayList<List<String>>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));;
        try{
            String line = "";
            while((line = br.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<String>();
                String array[] = line.split(",");
                //배열에서 리스트 반환
                tmpList = Arrays.asList(array);
                System.out.println(tmpList);
                ret.add(tmpList);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return ret;
	}

	public static ArrayList<String> parseArrayList(List<List<String>> list)
	{
		ArrayList<String> finallist = new ArrayList<>();
		for(int i=0; i<list.size(); ++i)
			finallist.add(list.get(i).get(1)+"");
		return finallist;
	}

	public static void main(String[] args) throws AWTException, UnsupportedEncodingException, FileNotFoundException {
		// TODO Auto-generated method stub
		List<List<String>> list = processExcel("C:\\Users\\rlaxo\\OneDrive\\바탕 화면\\test.csv");
		ArrayList<String> finallist = parseArrayList(list);
		for(int i=0; i<finallist.size(); ++i)
			System.out.println(list.get(i));

		/*
		for(int i=0; i<list.size(); i++) {
			List<String> line = list.get(i);
			System.out.println(line);
		}
		*/



		Robot robot = new Robot();
		int i = 10;
		int y = 1000, x = 1500;
		robot.mouseMove(x, y);

		/*while(i != 0)
		{
			--i;
			robot.mouseMove(x, y);
			y-=100;
			x-=100;
		}*/

	}

}
