/**
 * 
 */
package inheritance;

import java.util.ArrayList;

/**
 * @author bnockles
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student());
		students.add(new Student());
		students.add(new ClubMember());
		students.add(new Student());
		students.add(new ClubMember());
		rollCall(students);
	}

	public static void rollCall(ArrayList<Student> students) {
		for(Student s: students){
			s.act();
		}
	}

}
