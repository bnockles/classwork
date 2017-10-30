package ac201718;

import java.util.Arrays;

public class Person {


	public static final String[] FIRST_START = {"Chr","B","M","T","R","Gr","P","L"};
	public static final String[] FIRST_MIDDLE = {"ana","i","a","o","ala","ola","ara","e","is"};
	public static final String[] FIRST_LAST = {"","m","s","r","n","ian","ara","e"};


	public static final String[] LAST_START = {"Br","R","M","T","R","Gr","P","L"};
	public static final String[] LAST_MIDDLE = {"om","o","an","ola","et","e","is"};
	public static final String[] LAST_LAST = {"ers","son","rian"};


	private Borough home;
	private String firstName;
	private String lastName;
	private Person[] friends;

	public Person(String first, String last, Borough borough) {
		this.firstName = first;
		this.lastName = last;
		this.home = borough;
		friends = new Person[3];
	}

	public void mingle(Person[] peers){
		for(Person p: peers){
			if(p != this){
				p = betterFriend(p, friends[0]);
				if(!ObjectArrayLesson.personInGroup(friends, p)){
					//				System.out.println("Found object of same class "+this.getClass());
					addToFirstPlace(p);
				}

			}
		}
	}

	public void nameFriends(){
		System.out.println("I'm "+firstName+". My friends are "+Arrays.toString(friends));
	}

	public Person betterFriend(Person p, Person q){
		if(q == null){
			return p;
		}if(p == null){
			return q;
		}
		if(q.getBorough() == this.getBorough()){
			return q;
		}else if(p.getBorough() == this.getBorough()){
			return p;
		}
		else{
			//they have nothing in common
			return q;
		}
	}

	public void addToFirstPlace(Person p){
		Person[] group = friends;
		for(int i = group.length - 1; i > 0; i--){
			group[i] = group[i-1];
		}
		group[0] = p;
	}

	public Borough getBorough(){
		return home;
	}

	public String toString(){
		return firstName+" "+ lastName;
	}
}
