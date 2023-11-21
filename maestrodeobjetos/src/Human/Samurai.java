package Human;

public class Samurai extends Human{
	public static int samurais = 0;
	public Samurai(String name){
		this.name = "Samurai";
		this.health =  200;
		samurais++;
		
	}
	public static int howMany() {
		return samurais;
	}
	

		
    public void deathBlow(Human Human) {
		this.health = this.health/2;
		Human.setHealth(Human.getHealth()-Human.getHealth());
		System.out.println("Samurai asesino a " +Human.getName()+" y la vida de Samurai es la mitad");
	}
		
	public void meditate() {
		this.health += this.health/2;
		System.out.println("Samurai se cura la mitad de su vida");
	}
	
	
	public static int getSamurais() {
		return samurais;
	}

	public static void setSamurais(int samurais) {
		Samurai.samurais = samurais;
	}
	//public void howMany(int samurais) {
	  //  samurais++;
	    //System.out.println(""+samurais);
	//}
	
}
