package day0515;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class 영과일 {
	static BigDecimal big2 = new BigDecimal("173");
	static BigDecimal ans;
	static boolean flag = false;
	static Set<BigDecimal> visitList = new HashSet<>();
	public static void main(String[] args) {

		if(dfs(new BigDecimal("1"))) {
			System.out.println(ans);
		}else {
			System.out.println("BRAK");
		}

	}

	static boolean dfs(BigDecimal num) {
		visitList.add(num);

		int len = num.toString().length();
		if(len >= 100) {
			return false;
		} else {
			String remain = num.remainder(big2).toString();
			if(remain.equals("0")) {
				flag = true;
				ans = num;
				return true;
			}

			//뒤에 1을 추가하거나
			if(!visitList.contains(num.multiply(new BigDecimal("10")).add(new BigDecimal("1")))) {
				if(dfs(num.multiply(new BigDecimal("10")).add(new BigDecimal("1")))) {
					return true;
				}
			}
			//뒤에 0을 추가한다.
			if(!visitList.contains(new BigDecimal("10"))) {
				if(dfs(num.multiply(new BigDecimal("10")))) {
					return true;
				}
			}
			return false;
		}

	}
}
