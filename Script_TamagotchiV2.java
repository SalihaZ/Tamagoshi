

public class Script_TamagotchiV2 {

	static TamaV2 myTama;// on se laisse la possibilité de choisir

	public static void main(String[] args) {

		startGame();
		species();
		myTama.setName(name());
		myTama.setColor(color());
		myTama.setGender(gender());
		myTama.showAttributes();
		myTama.showState();
		showCommandList();

	}

	// Beginning of the game

	public static void startGame() {
		System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
		System.out.println(" _                                    _       _     _ \r\n"
				+ "| |                                  | |     | |   (_)\r\n"
				+ "| |_ __ _ _ __ ___   __ _  __ _  ___ | |_ ___| |__  _ \r\n"
				+ "| __/ _` | '_ ` _ \\ / _` |/ _` |/ _ \\| __/ __| '_ \\| |\r\n"
				+ "| || (_| | | | | | | (_| | (_| | (_) | || (__| | | | |\r\n"
				+ " \\__\\__,_|_| |_| |_|\\__,_|\\__, |\\___/ \\__\\___|_| |_|_|\r\n"
				+ "                           __/ |                      \r\n"
				+ "                          |___/        \r\n"
				+ "__                                   __       __   __");
		System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
		System.out.println("");
		System.out.println("Bienvenu au jeu adopte un Tamagotchi");
		System.out.println("");
		System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
	}

	// Method for choosing the tamagotchi type

	public static String species() {
		String species;
		do {
			System.out.println("");
			System.out.println("Quelle espèce veux tu choisir ? " + "\n");
			System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
			System.out.println("");
			System.out.println("Cheval, Chat, Lapin");
			species = Clavier.lireString();

		} while (flagSpecies(species));

		switch (species) {

		case "cheval":
		case "Cheval":
			myTama = new Horse();
			break;

		case "chat":
		case "Chat":
			myTama = new Cat();
			break;

		case "Lapin":
		case "lapin":
			myTama = new Rabbit();
			break;

		default:
			myTama = new TamaV2();
			break;
		}
		return species;
	}

	// Method which checks if the user's species entry is valid
	private static boolean flagSpecies(String species) {
		boolean fSpecies = true;
		if (species.equals("Cheval") || species.equals("Chat") || species.equals("Lapin") || species.equals("lapin")
				|| species.equals("cheval") || species.equals("chat")) {
			fSpecies = false;
		} else {
			System.out.println("");
			System.out.println("Choisis une espèce parmi les trois propositions !");
		}
		return fSpecies;
	}

	// Method for choosing a name for the tamagotchi

	public static String name() {
		System.out.println("");
		System.out.println("Choisis un prénom pour ton Tamagotchi :");
		String name = Clavier.lireString();
		System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
		System.out.println("");
		return name;
	}

	// Method for choosing a color for the tamagotchi
	public static String color() {
		String color;
		do {
			System.out.println("");
			System.out.println(" Quelle couleur veux-tu pour ton Tamagotchi ? ");
			System.out.println("\t\t -Blanc \n\t\t -Marron \n\t\t -Noir");
			color = Clavier.lireString();
			System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
		} while (flagColor(color));
		return color;
	}

	// Method which checks if the user's color entry is valid

	private static boolean flagColor(String color) {
		boolean fColor = true;
		if (color.equals("blanc") || color.equals("noir") || color.equals("marron") || color.equals("Banc")
				|| color.equals("Noir") || color.equals("Marron")) {
			fColor = false;
		} else {
			System.out.println("");
			System.out.println("Choisis une couleur valide parmi les trois propositions !");
		}
		return fColor;
	}

	// Method for choosing a gender for the tamagotchi
	public static String gender() {
		String gender;
		do {
			System.out.println("");
			System.out.println("Veux-tu un mâle ou une femelle? :");
			System.out.println("");
			System.out.println("\t\t -Un mâle  \n\t\t -Une femelle ");
			gender = Clavier.lireString();
			System.out.println("*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#*");
			System.out.println("");
		} while (flagGender(gender));
		return gender;
	}

	// Method which checks if the user's gender entry is valid

	private static boolean flagGender(String gender) {
		boolean fGender = true;
		if (gender.equals("Mâle") || gender.equals("Femelle") || gender.equals("mâle") || gender.equals("femelle")
				|| gender.equals("male") || gender.equals("mâle")) {
			fGender = false;
		} else {
			System.out.println("");
			System.out.println("Oups je crois qu'il y a une petite erreur de frappe. Choisis le sexe de ton Tama");
		}
		return fGender;
	}

	// Show the menu of all the actions to do
	private static void showCommandList() {
		int commands;

		System.out.println("\t\t*#*#*#*#*#*Que souhaites-tu faire?*#*#*#*#*#*#*");
		System.out.println("\t\t1. ---'Caractéristiques de ton Tamagotchi'---#*");
		System.out.println("\t\t2. ---------'Etat de ton Tamagotchi'---------#*");
		System.out.println("\t\t3. --------'Nourrir ton Tamagotchi'----------#*");
		System.out.println("\t\t4. ---------'Balader ton Tamagotchi'---------#*");
		System.out.println("\t\t5. ----------'Laver ton Tamagotchi'----------#*");
		System.out.println("\t\t6. ----------'L'emmener aux toilettes'-------#*");
		System.out.println("\t\t7. ---------'Coucher ton Tamagotchi'---------#*");
		System.out.println("\t\t8. ----------------'Quitter'-----------------#*");
		System.out.println("\t\t*#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*#**#*#*");
		commands = Clavier.lireInt();

		switch (commands) {
		case 1:
			myTama.showAttributes();
			showCommandList();
			break;
		case 2:
			myTama.showState();
			showCommandList();
			break;
		case 3:
			myTama.feed();
			showCommandList();
			break;
		case 4:
			myTama.walk();
			showCommandList();
			break;
		case 5:
			myTama.wash();
			showCommandList();
			break;
		case 6:
			myTama.toilet();
			showCommandList();
			break;
		case 7:
			myTama.sleep();
			showCommandList();
			break;

		case 8:
			System.out.println("Au revoir, Merci d'avoir jouer!");
			System.exit(0);
			break;

		default:
			System.out.println("Commande inconnue! Tappe 'Aide' pour voir la liste des commandes.");
			showCommandList();
			break;
		}

	}

}
