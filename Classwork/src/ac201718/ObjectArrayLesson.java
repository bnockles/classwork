package ac201718;

public class ObjectArrayLesson {

	
	
	public ObjectArrayLesson() {
		Person[] people = new Person[12];
		populate(people);
		for(Person p: people){
			System.out.println(p);
		}
	}

	private void populate(Person[] people) {
		for(int i = 0; i < people.length; i++){
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_LAST);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_LAST);
			Borough b = Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
			if(Math.random() < .6){
				people[i] = new Student(firstName, lastName, b, (int)(Math.random()*13));
			}else{
				people[i] = new Person(firstName, lastName, b);
			}
		}
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		String s = get(a)+get(b)+get(c);
		return s;
	}

	private String get(String[] arr) {
		return arr[(int)(Math.random()*arr.length)];
	}

}
