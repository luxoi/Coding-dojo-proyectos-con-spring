package Human;

public class Wizard extends Human{
	public Wizard(String name) {
		super();
		this.name = "Mago";
		this.health = 50;
		this.intelligence = 8;
	}

	public void heal(Human Human) {
		Human.setHealth(Human.getHealth()+intelligence);
		System.out.println(this.getName()+" Healed "+ Human.getName()+ " for "+ this.intelligence);
	}
	
	public void fireBall(Human Human) {
		Human.setHealth(Human.getHealth()-(this.intelligence*3));
		int dmg = this.intelligence*3;
		System.out.println(this.getName()+" attacked "+ Human.getName()+ " and he makes "+ dmg +" of dmg!");
	}
	
}


