//Grant Dalgo, Homework 4
//a game where the player is given a virtual pet to nurture for as long as possible
import java.util.Scanner;

public class HW4
{		
	static String petName;
	//declare class variables to represent pet attributes
	static int petAge;
	static int petHunger;
	static int petBoredom;
	static int petDirtiness;
	static int hungerIncrease;
	static int boredomIncrease;
	static int dirtinessIncrease;
	static int boredomRate;
	static int hungerRate;
	static int dirtinessRate;

	//final ints for hunger, boredom, and dirtiness thresholds
	final static int STAT_LOW = 3;
	final static int STAT_MEDIUM = 6;
	final static int STAT_HIGH = 9;
	final static int STAT_RUNAWAY = 12;
	//create a boolean variable to represent if the pet has run away and set it to false
	static boolean runAway = false;

	//create a pet to give to the player
	public static void createNewPet()
	{
		System.out.println("Your dragon egg starts shaking and heating up. The egg cracks open and out a baby dragon crawls out. What will you name your new baby dragon?");
		Scanner input = new Scanner(System.in);
		petName = input.nextLine();
		petAge = 0;
		petHunger = 0;
		petBoredom = 0;
		petDirtiness = 0;
		hungerRate = 1;
		boredomRate = 1;
		dirtinessRate = 1;
	}

	public static void petBirthday()
	{
		petAge++;
		System.out.printf("*****%s is now %d days old!*****%n", petName, petAge);
		if(petAge % 2 == 0)
		{	
			hungerRate++;
			System.out.printf("%s is getting bigger! They will get hungrier faster now!%n", petName);
		} 
		else if(petAge % 3 == 0)
		{
			dirtinessRate++;
			System.out.printf("As %s gets bigger, they will get dirtier faster!%n", petName);
		}
		else if(petAge % 5 == 0)
		{
			boredomRate++;
			System.out.printf("%s will need more playtime or they will become harder to handle!%n", petName);
		}
	}

	public static void feedPet()
	{
		petHunger -= hungerRate;
		petDirtiness += dirtinessRate;
		System.out.printf("%s devours the animal carcass, but makes a big mess...%n", petName);
	}

	public static void cleanPet()
	{
		petDirtiness -= dirtinessRate;
		petBoredom += boredomRate;
		System.out.printf("You clean %s, but they did not enjoy it...%n", petName);
	}

	public static void playWithPet()
	{
		petBoredom -= boredomRate;
		petHunger += hungerRate;
		System.out.printf("%s seems happier, but they have worked up an appetite...%n", petName);
	}

	public static void interactWithPet()
	{
		System.out.printf("What will you do with %s?%n1.) feed %s%n2.) clean %s%n3.) play with %s%n", petName, petName, petName, petName);
		Scanner input = new Scanner(System.in);
		int interact = input.nextInt();
		if(interact == 1)
		{
			feedPet();			
		}	
		else if(interact == 2)
		{
			cleanPet();
		}
		else if(interact ==3)
		{
			playWithPet();
		}
	}

	public static String petHungerStatus(int petHunger)
	{
		String hungerStatusMessage = "";
		if(petHunger < STAT_LOW)
		{
			hungerStatusMessage = "Great!";
		}
		else if(petHunger < STAT_MEDIUM)
		{
			hungerStatusMessage = "Not Bad.";
		}
		else if(petHunger < STAT_HIGH)
		{
			hungerStatusMessage = "Could be better.";
		}
		else if(petHunger < STAT_RUNAWAY)
		{
			hungerStatusMessage = "Needs immediate attention.";
		}
		return hungerStatusMessage;
	}

	public static String petDirtinessStatus(int petDirtiness)
	{
		String dirtyStatusMessage = "";
		if(petDirtiness < STAT_LOW)
		{
			dirtyStatusMessage = "Great!";
		}
		else if(petDirtiness < STAT_MEDIUM)
		{
			dirtyStatusMessage = "Not Bad.";
		}
		else if(petDirtiness < STAT_HIGH)
		{
			dirtyStatusMessage = "Could be better.";
		}
		else if(petDirtiness < STAT_RUNAWAY)
		{
			dirtyStatusMessage = "Needs immediate attention.";
		}
		return dirtyStatusMessage;
	}

	public static String petBoredomStatus(int petBoredom)
	{
		String boredomStatusMessage = "";
		if(petBoredom < STAT_LOW)
		{
			boredomStatusMessage = "Great!";
		}
		else if(petBoredom < STAT_MEDIUM)
		{
			boredomStatusMessage = "Not Bad.";
		}
		else if(petBoredom < STAT_HIGH)
		{
			boredomStatusMessage = "Could be better.";
		}
		else if(petBoredom < STAT_RUNAWAY)
		{
			boredomStatusMessage = "Needs immediate attention.";
		}
		return boredomStatusMessage;
	}

	public static void petStatusCheck(int petHunger, int petBoredom, int petDirtiness)
	{	
		String hungerDescription = "Hunger Level: ";
		petHungerStatus(petHunger);
		System.out.println(hungerDescription + petHungerStatus(petHunger));
		String dirtinessDescription = "Dirtiness Level: ";
		petDirtinessStatus(petDirtiness);
		System.out.println(dirtinessDescription + petDirtinessStatus(petDirtiness));
		String boredomDescription = "Boredom Level: ";
		petBoredomStatus(petBoredom);
		System.out.println(boredomDescription + petBoredomStatus(petBoredom));
	}

	public static boolean petRunawayCheck(int petHunger, int petBoredom, int petDirtiness)
	{
		//boolean runAway = false;
		if(petHunger >= STAT_RUNAWAY)
		{
			runAway = true;
			System.out.printf("%s has run away to search for its own food.%n", petName);
		}
		else if(petBoredom >= STAT_RUNAWAY)
		{
			runAway = true;
			System.out.printf("%s has run away in search of a more engaging life.%n", petName);
		}
		else if(petDirtiness >= STAT_RUNAWAY)
		{
			runAway = true;
			System.out.printf("%s has run away to take care of its own needs.%n", petName);
		} 
		else
		{
			runAway = false;
		}
		return runAway;
	}

	public static void petEpilogueMessage(String petName, int petAge)
	{
		System.out.printf("%s stayed with you for %d days.%n", petName, petAge);
		if(petAge < 5)
		{
			System.out.println("You should be more prepared to care for a dragon.");
		}
		else if(petAge < 15)
		{
			System.out.println("Your dragon enjoyed its time with you, but knew it was time to move on.");
		}
		else if(petAge < 25)
		{
			System.out.println("You are a great dragon tamer and you gave your dragon a great life.");
		}
		else
		{
			System.out.println("You are the best dragon tamer in the land.");
		}
	}
	

	public static void main(String [] args)
	{
		createNewPet();
		while(runAway == false) //while the pet has not run away
		{
			petBirthday(); //increase the age of the pet, making it more difficult to manage
			interactWithPet(); //let the player decide how to interact with the pet
			petStatusCheck(petHunger, petBoredom, petDirtiness); //let the player know how the pet is currently feeling
			petRunawayCheck(petHunger, petBoredom, petDirtiness); //petRunawayCheck(runAway); //figure out if the pet has run away
		
			if(runAway == true)
			{
				petEpilogueMessage(petName, petAge); //let the player know how they did
			}


		}

		
	}
}