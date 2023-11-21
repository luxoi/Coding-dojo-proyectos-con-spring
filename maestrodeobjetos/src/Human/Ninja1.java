package Human;

public class Ninja1 extends Human {
	public Ninja1(String name) {
		this.name = "Ninja";
		this.health = 100;
		this.stealth = 10;
	}
	public void steal(Human Human) {
		Human.setHealth(Human.getHealth()-stealth);
		this.health+=this.stealth;
		System.out.println(this.getName()+" ataccked "+ Human.getName()+ " for "+ this.stealth + " y se curo su vida por el daño que hizo");
	}
	public void runAway() {
		this.health=this.stealth;
		System.out.println("La vida de ninja ahora es "+this.stealth);
	}
}
