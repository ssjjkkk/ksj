package f_oop2;

class Human {
	String name;
	int age;
	void eat() {};
	void sleep() {};
}

class Student extends Human {
	int studentID;
	void goToSchool() {};
}

class Worker extends Human {
	int workerID;
	void goToWork() {};
}

public class Inheritance {
	

	public static void main(String[] args) {
		// Human 객체 생성
		Human h = new Human();
		h.name = "김민경";
		h.age = 24;
		h.eat();
		h.sleep();
		
		// Student 객체 생성
		Student s = new Student();
		s.name = "김민기";
		s.age = 28;
		s.studentID = 128;
		s.eat();
		s.sleep();
		s.goToSchool();
		
		// Worker 객체 생성
		Worker w = new Worker();
		w.name = "김민준";
		w.age = 29;
		w.workerID = 255;
		w.eat();
		w.sleep();
		w.goToWork();
		
		
		
		
		
	}

}
