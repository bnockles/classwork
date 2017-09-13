package aa201718;

public class CharacterB implements Dueler{

	private int hp;
	private String[] taunts = {"Hey Siri, what time is it? *buboop* Hey Tim, it's time for a beat down.",
			"I am just so excited about what our team has come up with: introducing iBattleSword."};
	private boolean loaded;
	
	public CharacterB() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName(){
		return "Tim Cook";
	}
	
	
	public void taunt(){
		System.out.println(taunts[(int)(Math.random() * taunts.length)]);
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
			if(loaded == true && Math.random() < .3){
				loaded = false;
				return Duel.SHOOTING;
			}else{
				if(!loaded && Math.random() < .4){
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
