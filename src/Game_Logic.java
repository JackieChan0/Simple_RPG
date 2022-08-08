import java.util.Scanner;

public class Game_Logic {
	
	//private Scanner sc;
	//private Scanner sc2;
	public Game_Logic() {	
		Game_Objects.room.add(new Room(1));
		Game_Objects.room.get(0).name = "Floating in Space";
		
		Game_Objects.room.get(0).desc.add("Desc Line 1");
		Game_Objects.room.get(0).desc.add("Desc Line 2");
		Game_Objects.room.get(0).desc.add("Desc Line 3");
		Game_Objects.room.get(0).desc.add("Desc Line 4");
		
		Game_Objects.room.get(0).exits.add("South 2");
		Game_Objects.room.get(0).exits.add("North 3");
	}
	
	public void waitforCommand() {
		
		if(Game_Objects.pc.inRoom == 0) {
			createCharacter();
		}
		
		System.out.println("What do?");
		Scanner sc = new Scanner(System.in);
		String com = sc.nextLine();
		
		
		String[] words = com.split(" ");
		processCommand(words);
		
		
	}
	
	public void processCommand(String[] x) {
		//String [] l = {"look"};
		
		if(x[0].equals("look"))
		{
			look(x);
		}
		
	}
	
	public void look(String[] x) {
		
		if (x.length == 1) {
			for (int i = 0; i < Game_Objects.room.size(); i++) {
				if(Game_Objects.room.get(i).number == Game_Objects.pc.inRoom) 
				{
					System.out.println(Game_Objects.room.get(i).name);
					
					for(int y = 0; y < Game_Objects.room.get(i).desc.size(); y++) 
					{
						System.out.println(Game_Objects.room.get(i).desc.get(y));
					}
					System.out.println("Exits: ");
					for (int y = 0; y < Game_Objects.room.get(i).exits.size(); y++) 
					{
						
						String exitNameFull = Game_Objects.room.get(i).exits.get(y);
						String[] exitName = exitNameFull.split(" ");
						System.out.println(exitName[0]);
					}
					
				}
				
			}
		}
		
		if (x.length == 2) {
			
			if (x[1].equals("self")) {
				Game_Objects.pc.look();
			}
				
		}
		
	}
	//interact with player at the start, get name and set up
	public void createCharacter() {
		System.out.println("Welcome new player, what is your name?");
		Scanner sc = new Scanner(System.in);
		Game_Objects.pc.name = sc.next();
		System.out.println("At the start of your journey, you will be given 100 health points and 75 points for accuracy.");
		Game_Objects.pc.hp = 100;
		Game_Objects.pc.accuracy = 75;
		Game_Objects.pc.inRoom = 2;
		
	}

}
