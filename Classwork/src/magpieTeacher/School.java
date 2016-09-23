package magpieTeacher;

import java.util.Scanner;

public class School implements Topic{

	static boolean inSchoolLoop;
	static String response;

	public void talk(Scanner input){
		inSchoolLoop = true;
		while(inSchoolLoop){
			TeacherPrep.print("Isn't school fantastic? What do you like about school?(If you want to stop talking about school, type stop)");
			response = input.nextLine();
			if(response.indexOf("stop") >= 0){
				TeacherPrep.resume(this);
			}else{
				TeacherPrep.print("Yes! That is cool!");
			}
		}
	}
	
}
