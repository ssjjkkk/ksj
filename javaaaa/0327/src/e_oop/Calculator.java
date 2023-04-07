package e_oop;

public class Calculator {
	
	int a;
	// + - * / % 를 연산해주는 5개의 메서드를 만들어주세요.
	// 각각의 메서드는 2개의 파라미터를 받는다. 그 후 결과값 리턴
	
	long A (long a, long b) {
		long result = a + b;
		return result;
	}
	
	long B (long a, long b) {
		long result = a - b;
		return result;
	}
	
	long C (long a, long b) {
		long result = a * b;
		return result;
	}
	
	long D (long a, long b) {
		long result = a / b;
		return result;
	}
	
	long E (long a, long b) {
		long result = a % b;
		return result;
	}
	
	
	
}
