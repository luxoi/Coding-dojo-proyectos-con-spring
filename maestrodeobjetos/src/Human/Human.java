package Human;

public class Human {
	protected String name = "";
	protected int intelligence = 4;
	protected int stealth = 4;
	protected int health = 50;
	private int strength = 5;

	public Human() {
	}
	public Human(String name, int intelligence, int stealth, int health, int strength) {
		this.name = name;
		this.intelligence = intelligence;
		this.stealth = stealth;
		this.health = health;
		this.strength = strength;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getStealth() {
		return stealth;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void Atack(Human Human) {
		Human.setHealth(Human.getHealth()-strength);
		System.out.println(this.getName()+" attacked "+ Human.getName()+ " and he makes "+this.getStealth()+" of dmg!");
	}
	
	public void displayHealth() {
		System.out.println("La vida de "+this.name+" es de "+this.health);
	}
	

}
