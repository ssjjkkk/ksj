package kr.or.dw.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	
	/*
	 * Stack ==> LIFO(Last In First Out - 후입선출) 방식의 자료 구조
	 * Queue ==> FIFO(First In First Out - 선입선출) 방식의 자료구조
	 */

	public static void main(String[] args) {
		/*
		 * Stack의 명령
		 * 1. 자료 입력 : push(추가할 데이터);
		 * 2. 자료 출력 : pop() ==> 자료를 꺼내온 후에 꺼내온 자료를 Stack에서 지운다.
		 * 			  peek() ==> 삭제 없이 자료를 꺼내온다.
		 */
		
		Stack<String> stack = new Stack<>();
		
		stack.push("홍길동");
		stack.push("성춘향");
		stack.push("이몽룡");
		stack.push("변학도");
		
		System.out.println("현재 스택 값 : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 값 : " + data);
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("현재 스택 값 : " + stack);
		
		String temp = stack.peek();
		System.out.println("peek으로 꺼내온 값 : " + temp);
//		System.out.println("peek으로 꺼내온 값 : " + stack.peek());
		System.out.println("현재 스택 값 : " + stack);
		
		stack.push("성춘향");
		System.out.println("추가한 후 스택 값 : " + stack);
		
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("현재 스택 값 : " + stack);
		
		System.out.println("stack의 isEmpty : " + stack.empty());
		
		stack.push("구준표");
		System.out.println("현재 스택 값 : " + stack);
		System.out.println("성춘향의 위치 : " + stack.search("성춘향"));
		
		/*
		 * Queue의 명령
		 * 1. 자료 입력 : offer(추가할 데이터)
		 * 2. 자료 출력 : poll() ==> 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제한다.
		 * 			  peek() ==> 삭제 없이 자료를 꺼내온다.
		 * 
		 * *** 스택은 Stack 클래스로 구현하여 제공하고 있지만, 큐는 Queue인터페이스로만 정의해
		 * 놓았을 뿐 별도의 클래스를 제공하고 있지 않다. 대신 Queue 인터페이스를 구현한 클래스들이
		 * 있어서 이 들 중의 하나를 선택해서 사용하면 된다.
		 */
		
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("성춘향");
		queue.offer("이몽룡");
		queue.offer("변학도");
		
		System.out.println("현재 queue 값 : " + queue);
		data = queue.poll();
		System.out.println("꺼내온 값 : " + data);
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("현재 queue 값 : " + queue);
		
		queue.offer("성춘향");
//		queue.offer("성춘향");
		System.out.println("현재 queue 값 : " + queue);
		
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("현재 queue 값 : " + queue);
		
		
		temp = queue.peek();
		System.out.println("삭제 없이 꺼내온 값 : " + temp);
		System.out.println("현재 queue 값 : " + queue);
		
		System.out.println("큐에서 삭제하기 : " + queue.remove("성춘향2"));
		System.out.println("현재 queue 값 : " + queue);
		
		
	}

}
