package aa201718;

public class CharacterA implements Dueler{

	private int hp;
	private String[] taunts = {"Alexa, set a 'one minutes to live' timer for Tim.","I'm going steel-toed-boot Amazon Prime delivered to your face."};
	private int tauntCount = 0;
	private boolean loaded;
	
	public CharacterA() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName(){
		return "Jeff Bezos";
	}
	
	public void taunt(){
		System.out.println(taunts[tauntCount]);
		tauntCount++;
	}
	
	public void setStartingHP(int hp){
		this.hp = hp;
	}

	public int getHP(){
		return this.hp;
	}
	
	public boolean determineIfOpponentIsFair(Dueler d, int hp){
		return d.getHP() == hp;
	}

	
	public int getAction(Object caller){
		if (caller instanceof Duel){
			if(loaded == true && Math.random() < .5){
				loaded = false;
				return Duel.SHOOTING;
			}else{
				if(!loaded && Math.random() < .6){
					loaded = true;
					return Duel.LOADING;
					
				}else{
					return Duel.GUARDING;
				}
			}
		}else{
			return Duel.YEAH_RIGHT;
		}
	}

	public void hit(Object caller) {
		if (caller instanceof Duel){
			this.hp -= 10;
		}
	}
	
	
}
