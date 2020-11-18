import java.util.Random;

public class TamaV2 {
	// Attributes list of the tamagotchi

	String name;
	String species;
	String color;
	String gender;
	String feel;
	private int age = 1;
	private int health = 5;
	private int life = 10;
	private int hunger = 0;
	private int tiredness = 0;
	private int cleanliness = 10;
	private int joy = 10;
	private int hangout = 5;
	private int toilet = 0;

	// *#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#

	// Method which shows the attributes of the tamagotchi

	public void showAttributes() {
		System.out.println(" ");
		// drawing(species);
		this.draw(); //
		System.out.println("\t\t*#*#*#**#*#*# Caractristiques de ton Tama *#*#*#**#*#*#");
		System.out.println("\t\t - Le nom de ton Tama est " + getName() + ".");
		// System.out.println("\t\t - Ton Tama est un " + species);
		System.out.println("\t\t - La couleur de ton Tama : " + getColor());
		System.out.println("\t\t - Ton Tama est un/une : " + getGender());
		System.out.println("\t\t - L'âge de ton Tama : " + getAge() + " ans");
		System.out.println("\t\tTon Tama a une espérance de vie de : " + getLife() + "/10");
		// System.out.println("\t\tLa propreté de ton Tama : " + getClealiness() +
		// "/10");
		System.out.println("");

	}

	// *#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#

	// Show the horse drawing

	public void draw() {
		System.out.println("Je suis un tamagotchi");
	}

	// *#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#

	// Method which displays the features of the tamagotchi

	public void showState() {

		System.out.println("");
		System.out.println("\t\tVie : " + getLife() + "/10");
		System.out.println("\t\tBesoin d'aller au petit coin : " + getToilet() + "/10");
		System.out.println("\t\tPropreté : " + getCleanliness() + "/10");
		System.out.println("\t\tSociabilité : " + getHangout() + "/10");
		System.out.println("");
	}

	// *#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#

	// Method for all the actions to do for the Tamagotchi

	// Method for feeding the Tamagotchi

	public void meal() {

		System.out.println("\t\t" + name + " " + "veut manger : ");
		System.out.println("");
		System.out.println("\t\t(1) une salade \n\t\t(2) un gateau \n\t\t(3) une viande");

	}

	public void feed() {
		hunger -= 5;
		if (hunger < 0) {
			hunger = 0;

			int userFeed;
			this.meal();// méthod
//				System.out.println("\t\t" + name + " " + "veut manger : ");
//				System.out.println("");
//				System.out.println("\t\t(1) une salade \n\t\t(2) un gateau \n\t\t(3) une viande");
			userFeed = Clavier.lireInt();

			switch (userFeed) {
			case 1:
				this.setLife(this.getLife() + 3);
				this.setCleanliness(this.getCleanliness() + 2);
				this.setToilet(this.getToilet() + 2);

				break;

			case 2:
				this.setLife(this.getLife() + 2);
				this.setCleanliness(this.getCleanliness() - 1);
				this.setToilet(this.getToilet() + 3);
				break;

			case 3:
				this.setLife(this.getLife() + 3);
				this.setCleanliness(this.getCleanliness() - 2);
				this.setToilet(this.getToilet() + 4);
				break;

			default:
				reask();
				feed();
			}
		}
	}
	// *#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#

	// Method for walking the Tamagotchi
	public void walk() {
		int userChoice;
		System.out.println("\t\t" + name + " " + " a envie de se balader !");
		System.out.println("");
		System.out.println("\t\t(1) Promenade en montagne \n\t\t(2) Aller au restaurant ");
		userChoice = Clavier.lireInt();

		switch (userChoice) {
		case 1:
			this.setHangout(this.getHangout() + 5);
			this.setCleanliness(this.getCleanliness() + 1);
			this.setToilet(this.getToilet() + 3);
			break;

		case 2:
			this.setHangout(this.getHangout() + 4);
			this.setCleanliness(this.getCleanliness() + 2);
			this.setToilet(this.getToilet() + 3);
			break;

		default:
			reask();
			walk();
		}
	}
	// *#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#

	// Method for going to the toilet
	public void toilet() {
		int userToilet;
		System.out.println("");
		System.out.println("\t\t(1)" + name + " " + "veut aller aux toilettes (2)" + name + ""
				+ " ne veut pas aller aux toilettes");
		userToilet = Clavier.lireInt();

		switch (userToilet) {

		case 1:
			this.setToilet(this.getToilet() - 5);
			this.setCleanliness(this.getCleanliness() - 2);
			this.setHangout(this.getHangout() - 1);

			break;

		case 2:
			this.setToilet(0);
			this.setCleanliness(this.getCleanliness() - 2);
			this.setHangout(this.getHangout() - 1);
			break;

		default:
			reask();
			toilet();
		}
	}
	// *#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#

	// Method for washing the Tamogotchi
	public void wash() {
		int userWash;
		System.out.println("\t\t*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
		System.out.println("");
		System.out.println("\t\tC'est le moment de laver" + " " + name);
		System.out.println("");
		System.out.println("\t\t(1) lui prendre un bain \n\t\t(2) lui faire sa toilette quotidienne ");
		System.out.println("");
		System.out.println("\t\t*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
		userWash = Clavier.lireInt();

		switch (userWash) {
		case 1:
			this.setCleanliness(this.getCleanliness() + 4);
			this.setHangout(this.getHangout() - 1);
			break;

		case 2:
			this.setCleanliness(this.getCleanliness() + 2);
			this.setHangout(this.getHangout() - 1);

			break;

		default:
			reask();
			wash();
		}
	}
	// *#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#

	// Method to sleep the Tamagotchi
	public void sleep() {
		int userSleep;
		System.out.println("\t\t*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
		System.out.println("");
		System.out.println("\t\tC'est l'heure de coucher" + " " + name);
		System.out.println("");
		System.out.println("\t\t(1) Faire un petit dodo \n\t\t(2) Faire un grand dodo");
		System.out.println("");
		System.out.println("\t\t*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
		userSleep = Clavier.lireInt();

		switch (userSleep) {
		case 1:

			this.setCleanliness(this.getCleanliness() - 2);
			this.setHangout(this.getHangout() - 2);
			this.setToilet(this.getToilet() + 2);
			break;

		case 2:

			this.setCleanliness(this.getCleanliness() - 3);
			this.setHangout(this.getHangout() - 2);
			this.setToilet(this.getToilet() + 3);
			break;

		default:
			reask();
			sleep();
		}
	}
	// *#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#

	// Method for asking again if the user make a mistake
	public void reask() {
		System.out.println("Je n'ai pas compris ce que tu veux faire!");
		System.out.println("");
		System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
	}

	// Method for the accessors and mutators of the tamagotchi attributes

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;

	}

	public void setSpecies(String species) {
		this.species = species;

	}

	public String getSpecies() {
		return this.species;

	}

	public void setColor(String color) {
		this.color = color;

	}

	public String getColor() {

		return color;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setFeel(String feel) {
		this.feel = feel;

	}

	public String getFeel() {
		return this.feel;

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setLife(int life) {
		this.life = life;

		Random randomL = new Random();
		int randomLHorse = randomL.nextInt(3) * 10;
		int randomLCat = randomL.nextInt(6) + 10;
		int randomLRabit = randomL.nextInt(2) + 2;

		if (species.equals("Cheval")) {
			this.life = randomLHorse;
		}
		if (species.equals("Chat")) {
			this.life = randomLCat;
		}
		if (species.equals("Lapin")) {
			this.life = randomLRabit;
		}

		if (this.getLife() > 10) { // lock the life to 10 points maximum
			this.life = 10;
		}

		if (this.getLife() <= 0) { // lock the life to 0 points minimal
			this.life = 0;
		}
	}

	public int getLife() {
		return life;
	}

	public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
		if (this.getCleanliness() > 10) { // 10 is the maximum for Hygiene
			this.cleanliness = 10;
		}

		if (this.getCleanliness() < 0) { // 0 is the minimum for Hygiene
			this.cleanliness = 0;
			System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
			System.out.println("");
			System.out.println("\t\t" + name + " " + "a besoin d'être lavé !");
			System.out.println("");
			this.setLife(this.getLife() - 4); // if cleanliness is 0, tama looses 4 points of life
		}
	}

	public int getCleanliness() {
		return cleanliness;
	}

	public int getHangout() {
		return hangout;
	}

	public void setHangout(int hangout) {
		this.hangout = hangout;
		if (this.getHangout() > 10) { // 10 max for hanging out
			this.hangout = 10;
		}

		if (this.getHangout() < 0) { // 0 min for hanging out
			this.hangout = 0;
			System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
			System.out.println("");
			System.out.println("\t" + name + " " + "a envie de se balader !");
			System.out.println("\t Il veut voir des amis !");
			System.out.println("");
			this.life = (this.getLife() - 2);
		}

	}

	public int getToilet() {
		return hangout;
	}

	public void setToilet(int toilet) {
		this.toilet = toilet;
		this.toilet = 10;
		System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
		System.out.println("");
		System.out.println(name + " " + "dois aller aux toilettes tous les matins et après manger");
		System.out.println("");
		System.out.println("");

		this.toilet = 0;
	}

	/*
	 * These are some actions that could be added for a new version Tamagotchi V.3.
	 */

	// Express its mood expl.
	public void mood() {
		joy += 5;
		if (joy > 10) {
			joy = 10;
		}
	}

	// health : if he smokes his health decreases and his hunger increases
	public void fume() {
		health -= 3;
		hunger += 2;
		if (health < 0) {
			health = 0;
		}
		if (hunger > 10) {
			hunger = 10;
		}
	}

	// Method for practicing sport : sport increases health
	public void sport() {
		health += 3;
		hunger += 2;
		tiredness += 2;
		if (health > 10) {
			health = 10;
		}
		if (hunger > 10) {
			hunger = 10;
		}
		if (tiredness > 10) {
			tiredness = 10;
		}
	}

	// Express its state expl. tiredness or hunger
	public String getState() {
		if (tiredness == 10) {
			return "endormi";
		} else if (tiredness >= 8) {
			return "est très fatigué";
		} else if (hunger >= 7) {
			return "a faim";
		} else if (cleanliness < 3) {
			return "sale";
		} else if (joy >= 7) {
			return "saute de joy";
		} else if (joy <= 4) {
			return "ok";
		} else {
			return "triste";
		}

	}

	public void CountTime() {
		hunger++;
		cleanliness--;
		if (tiredness == 10) {
			tiredness = 0;
		} else {
			tiredness++;
		}
		if (hunger >= 7) {
			joy--;
		}
		if (cleanliness < 3) {
			joy--;
		}
		if (hunger > 10) {
			hunger = 10;
		}
		if (cleanliness < 0) {
			cleanliness = 0;
		}
		if (joy < 0) {
			joy = 0;
		}
	}

}
