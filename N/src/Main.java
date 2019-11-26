import java.util.Scanner;
import java.util.Stack;

public final class Main {
	public static Stack<Integer> stack = new Stack<Integer>();
	
	public static void decompose() {
		while(true) {
			System.out.println(stack.toString());
			int temp = stack.pop();
			if(temp!=1) {
				stack.push(temp-1);
				stack.push(1);
			}else {
				int sum=2;
				for(; !stack.isEmpty() && stack.peek() ==1; stack.pop())
					sum++;
				if(stack.isEmpty()) break;
				int pivot = stack.pop()-1;
				stack.push(pivot);
				while(sum>pivot) {
					stack.push(pivot);
					sum -=pivot;
				}
				stack.push(sum);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("임의의 수 입력 : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		stack.push(n);
		decompose();
	}

}
