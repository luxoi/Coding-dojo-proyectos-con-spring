package HumanTest;

import Human.Human;
import Human.Ninja1;
import Human.Samurai;
import Human.Wizard;


public class HumanTest {
	public static void main(String[] args) {
		
		
		Wizard Mago = new Wizard("Mago");
		Ninja1 Ninja = new Ninja1("Ninja");
		
		Samurai Samurai = new Samurai ("Samurai");
		Samurai Samurai2 = new Samurai ("Samurai2");
		Samurai Samurai3 = new Samurai ("Samurai3");
		
		
		Mago.Atack(Ninja);
		Ninja.displayHealth();
		Mago.heal(Samurai);
		Samurai.displayHealth();
		Mago.fireBall(Ninja);
		Ninja.displayHealth();
		Ninja.steal(Mago);
		Ninja.displayHealth();
		Mago.displayHealth();
		Ninja.runAway();
		Samurai.deathBlow(Mago);
		Samurai.displayHealth();
		Mago.displayHealth();
		Samurai.meditate();
		Samurai.displayHealth();
		System.out.println("Hay esta cantidad de samurais: "+Samurai.howMany());
	}
}
