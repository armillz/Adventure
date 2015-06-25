/**
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jason
 *
 */
public class Adventure {

	// our backpack (place-holder until we create a Person object)
	private static ObjectContainer backpack = new ObjectContainer("backpack");
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game.message("Welcome to A Fantastical Adventure! Type 'n' to go north, 's' to go south 'e' to go east and 'w' to go west.");
		Game.message("You can also type action words like 'take' and then the name of an item to pick something up if there is an item in the room");
		Game.message("For a full list of things you can say, type 'commands'");
		Game.message("I will be your eyes and ears as you journey through this adventure. Have fun!");
		Game.message("You start out in the forest in front of your house");
		Boolean flag = true;

		RoomMap map = new RoomMap();
		map.showLocation();

		while (flag == true){
			String s = readInput("What do you want to do?");
			String[] parts = s.split(" ");
			String cmd = parts[0];
			
			if(cmd.equals("n")){
				map.moveNorth();
				map.showLocation();
			} else if(cmd.equals("s")){
				map.moveSouth();
				map.showLocation();
			} else 

			if(cmd.equals("e")){
				map.moveEast();
				map.showLocation();
			} else 
			if(cmd.equals("stop")){
				Game.message("Bye!");
				flag = false;
			} else 
			if(cmd.equals("w")){
				map.movewest();
				map.showLocation();
			} else 
			if(cmd.equals("commands") || cmd.equals("?")){
				Game.message("n - go north");
				Game.message("s - go south");
				Game.message("e - go east");
				Game.message("w - go west");
				map.showLocation();
			} else 
			if(cmd.equals("sleep")){
				if(map.roomTitle().equals("Upstairs")){
					map.dreamActivate();
					map.showLocation();
				} else{
					Game.message("You probably shouldnt sleep now");

				}
			} else if(cmd.equals("take")){
				// Remove knife from current room and insert into backpack
				Room this_room = map.getLocation();
				GameObject go = this_room.removeObject(parts[1]);
				go.insertInto(backpack);
				Game.message("You have taken " + parts[1]);
				Game.message("Items in room:");
				this_room.objects.showAllObjects();
				
			} else if(cmd.equals("drop")){
				// Remove knife from backpack and insert into current room
				Room this_room = map.getLocation();
				GameObject go = backpack.remove(parts[1]);
				go.insertInto(this_room.objects);
				Game.message("You have dropped " + parts[1]);
				Game.message("Items in room:");
				this_room.objects.showAllObjects();
				
			} else if (cmd.equals("backpack")) {
				Game.message("Backpack contains:");
				backpack.showAllObjects();
			}
			
		}

	}



	public static String readInput(String a)  {
		try { 
			return Game.readInput(a);
		} catch (IOException ioe) {
			Game.message("Failed to read input");
			return null;
		}

	}

}
