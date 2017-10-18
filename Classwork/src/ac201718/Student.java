package ac201718;

public class Student extends Person {

	public static String[] grades = {"Kindergardner","1st grader","2nd grader","3rd grader","4th grader","5th grader","6th grader",
			"7th grader","8th grader","Freshman","Sophomore","Junior","Senior"};
	
	private String grade;
	
	public Student(String first, String last, Borough borough, int gradeLevel) {
		super(first, last, borough);
		grade = grades[gradeLevel];
	}
	
	public String toString(){
		return super.toString() + " I am also a "+grade+".";
	}

}
