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
			if(s.equals("n")){
				map.moveNorth();
				map.showLocation();
			} else{
				if(s.equals("s")){
					map.moveSouth();
					map.showLocation();
				}
			}
			if(s.equals("e")){
				map.moveEast();
				map.showLocation();
			}
			if(s.equals("stop")){
				Game.message("Bye!");
				flag = false;
			}
			if(s.equals("w")){
				map.movewest();
				map.showLocation();
			}
			if(s.equals("commands")){
				Game.message("n - go north");
				Game.message("s - go south");
				Game.message("e - go east");
				Game.message("w - go west");
			}
			if(s.equals("sleep")){
				if(map.roomTitle().equals("Upstairs")){
					map.dreamActivate();
					map.showLocation();
				} else{
					Game.message("You probably shouldnt sleep now");

				}
			}
			if(s.equals("take knife")){
				Room this_room = map.getLocation();
				
				GameObject go = this_room.removeObject("knife");
				// TODO: Person me.add(go);
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
