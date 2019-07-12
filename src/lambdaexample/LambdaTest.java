package lambdaexample;

import java.util.ArrayList;

public class LambdaTest {

	public static void main(String[] args) {
		
		// Example 1
		SysPrint print = (int value) -> System.out.println("Value: " + value);
		
		print.print(500);
		
		// Example 2
		Operation  add = (int x, int y) -> x + y;
		
		int result = add.operate(2, 3);
		
		// OR Send the Operation as a callback
//		LambdaTest obj = new LambdaTest();
//		int result = obj.operate(2, 3, add);
		
		// OR Old ways
//		int result = obj.operate(2, 3, new Operation() {
//			
//			@Override
//			public int operate(int a, int b) {
//				return a + b;
//			}
//		});
		System.out.println("Result: " + result);
		
		// Example 3
		ArrayList<Integer> arrValues = new ArrayList<Integer>();
		arrValues.add(1);
		arrValues.add(2);
		arrValues.add(3);
		arrValues.add(4);
		arrValues.add(5);
		arrValues.add(6);
		arrValues.add(7);
		arrValues.add(8);
		arrValues.add(9);
		
		System.out.println("Print all elements: ");
		arrValues.forEach(n -> System.out.print(n + " "));
		
		System.out.println("\nPrint odd elements only: ");
		arrValues.forEach(n -> {if(n %2 != 0) System.out.print(n + " "); });

		// Example 4
		Operation multiply = (int x, int y) -> x * y;
		
		int addition = add.operate(5, 7);
		int multiplication = multiply.operate(5, 7);
		
		PrintVal printVal = (String input, int value) -> System.out.println(input + value);
		printVal.print("Addition: ", addition);
		printVal.print("Multiplication: ", multiplication);
		
	}
	
	private int operate(int x, int y, Operation operation) {
		return operation.operate(x, y);
	}

	interface Operation {
		int operate(int a, int b);
	}
	
	interface SysPrint {
		void print(int val);
//		void get(int val); // An Interface can have only one abstract method in-order to use it for Lambda expression.
	}
	
	interface PrintVal {
		void print(String input, int value);
	}
}
