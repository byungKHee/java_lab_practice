package practice;

import java.util.Scanner;

public class SimpleCalculator {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String S = scn.next();
		int a = 0, b = 0;
		String order = new String();
		if(S.contains("+")){
			String[] nums = S.split("\\+");
			a = Integer.parseInt(nums[0]);
			b = Integer.parseInt(nums[1]);
			order = "add";
		}
		else if(S.contains("-")) {
			String[] nums = S.split("-");
			a = Integer.parseInt(nums[0]);
			b = Integer.parseInt(nums[1]);
			order = "sub";
		}
		
		try {
			if(order.equals("add")) {
				System.out.println(addNum(a, b));
			}
			else {
				System.out.println(subNum(a, b));
			}
			
		} catch (AddZeroException e) {
			e.printError();
		} catch (SubtractZeroException e) {
			e.printError();
		}catch (OutOfRangeException e) {
			e.printError();
		}finally {
			scn.close();
		}
		
	}
	
	public static int addNum(int a, int b) throws AddZeroException, OutOfRangeException{
		if(a == 0 || b == 0)
			throw new AddZeroException();
		if(isOutRange(a) || isOutRange(b) || isOutRange(a+b))
			throw new OutOfRangeException();
		return a + b;
	}
	
	public static int subNum(int a, int b) throws SubtractZeroException, OutOfRangeException{
		if(a == 0 || b == 0)
			throw new SubtractZeroException();
		if(isOutRange(a) || isOutRange(b) || isOutRange(a-b))
			throw new OutOfRangeException();
		return a - b;
	}
	
	public static boolean isOutRange(int a) {
		if(a < 0 || a > 1000)
			return true;
		return false;
	}

}

class OutOfRangeException extends Exception{
	public void printError() {
		System.out.println("OutOfRangeException");
	}
}

class AddZeroException extends Exception{
	public void printError() {
		System.out.println("AddZeroException");
	}
}

class SubtractZeroException extends Exception{
	public void printError() {
		System.out.println("SubtractZeroException");
	}
}
