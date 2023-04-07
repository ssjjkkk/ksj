package e_oop.score;

public class Score {

	public static void main(String[] args) {
		
		Student[] students = new Student[15];
		
		for (int i = 0; i < students.length; i++) {
			Student student = new Student(i);		
			students[i] = student;
//			System.out.println(student.toString());
		}
		
		Student st = new Student();
		students = st.ranking(students);
		st.print(students);
		
	}

}
