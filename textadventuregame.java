import java.util.Scanner;

public class HW5
{

	final int NUMBER_OF_ROOMS = 10;

	static final int NORTH = 0;
	static final int EAST = 1;
	static final int WEST = 2;
	static final int SOUTH = 3;
	static int currentRoom = 0;
	static boolean stillInside = true;

	public static int chooseNextRoom()
		{
			int exitChoice = -1;
			Scanner input = new Scanner(System.in);
			char response = input.nextLine().charAt(0);
			if(response == 'n' || response == 'N')
			{
				exitChoice = NORTH;
			} else
			if(response == 'e' || response == 'E')
			{
				exitChoice = EAST;
			} else
			if(response == 'w' || response == 'W')
			{
				exitChoice = WEST;
			} else
			if(response == 's' || response == 'S')
			{
				exitChoice = SOUTH;
			} else			
			if(response == 'q' || response == 'Q')
			{
				stillInside = false;
			}

			return exitChoice;
		}

	public static void main(String[] args)
	{
		
		String[] roomDescriptions = new String[10];
		roomDescriptions [0] = "You step into a large Entry Hall. In the dim candle light, you see exits to the west, north, and south.";
		roomDescriptions [1] = "You enter the Kitchen. Pungent smells of spices and roast meat fill the air. There are exits to the west, north, and east.";
		roomDescriptions [2] = "You enter into a cramped Servant's Quarters. Small beds line the walls. There are exits to the west and north.";
		roomDescriptions [3] = "You step into a large, open Den. An intimidating bear pelt is spread across the floor and a cozy fire is burning in the fireplace. You see exits to the north and west.";
		roomDescriptions [4] = "The door opens into the Dining Hall. Long tables are set with chalices for ale and wine, and more chairs than you can count. There are exits to the west, south, and east.";
		roomDescriptions [5] = "A massive throne tells you that this must be the Throne Room. Statues of former Kings and Queens line the walkway to apprach the throne. There are exits to the west, south, and east.";
		roomDescriptions [6] = "You enter what appears to be someone's Sleeping Quarters. There's an extravagant bed in the middle, and a balcony that overlooks the courtyard.";
		roomDescriptions [7] = "As you step inside the Armory, you notice the massive suits of armor. The walls are lined with racks containing weapons of every kind. You see exits to the east and north.";
		roomDescriptions [8] = "This small room is a Bathroom. Not much to notice in here, except for the only exit to the south.";
		roomDescriptions [9] = "You've sumbled upon some sort of Hidden Room. Treasure chests are stashed in one corner, along with shelves of various valuable looking items. The only exit is to the south.";

		int[] [] roomExits = new int[10] [4];
		roomExits [0][0] = 5; 
		roomExits [0][1] = 1;
		roomExits [0][2] = 7;
		roomExits [0][3] = -1;
		roomExits [1][0] = 4;
		roomExits [1][1] = 2;
		roomExits [1][2] = 0;
		roomExits [1][3] = -1;
		roomExits [2][0] = 3;
		roomExits [2][1] = -1;
		roomExits [2][2] = 1;
		roomExits [2][3] = -1;
		roomExits [3][0] = 9;
		roomExits [3][1] = -1;
		roomExits [3][2] = 4;
		roomExits [3][3] = 2;
		roomExits [4][0] = -1;
		roomExits [4][1] = 3;
		roomExits [4][2] = 5;
		roomExits [4][3] = 1;
		roomExits [5][0] = -1;
		roomExits [5][1] = 4;
		roomExits [5][2] = 6;
		roomExits [5][3] = 0;
		roomExits [6][0] = 8;
		roomExits [6][1] = 5;
		roomExits [6][2] = -1;
		roomExits [6][3] = 7;
		roomExits [7][0] = 6;
		roomExits [7][1] = 0;
		roomExits [7][2] = -1;
		roomExits [7][3] = -1;
		roomExits [8][0] = -1;
		roomExits [8][1] = -1;
		roomExits [8][2] = -1;
		roomExits [8][3] = 6;
		roomExits [9][0] = -1;
		roomExits [9][1] = -1;
		roomExits [9][2] = -1;
		roomExits [9][3] = 3;




		while(stillInside == true)
			{
				System.out.printf("%s%n%n", roomDescriptions[currentRoom]);
				System.out.println("Which direction will you go?");
				System.out.println("n for north, e for east, w for west, s for south, or q to quit");
				int exitChoice = chooseNextRoom();
				if(stillInside == true)
				{
					int nextRoom = roomExits [currentRoom][exitChoice];
					if( nextRoom == -1)
					{
						System.out.println("There is no exit in that direction. Choose another direction.");				
					} else 
					if(nextRoom > -1)
					{
						currentRoom = nextRoom;
					}	
				}
								
			}

		if(stillInside == false)
		{
			System.out.println("You leave the castle and embark on your next adventure.");
		}	
	}
}