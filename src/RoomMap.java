

public class RoomMap {
	private Room[] rooms = {
			new Room("Forest", "a Forest", "You are in the forest, your house is to the north and a river to the east. Your kids are playing together nearby", "House", null, "River", "Forest"),
			new Room("House", "the House", "You are in your house, there are doors to the porch to the north and east and a door to the forest to the south. \nThere are stairs to the top floor to the west", "Porch", "Upstairs", "Porch", "Forest"),
			new Room("Porch", "a Porch", "You are on the porch, there are stairs to the shed to the east and doors back into the house to the north and west.", "House", "House", "Shed", null),
			new Room("River", "a River", "In a river, there is a forest to the west and a shed to the north", "Shed", "Forest", null, null),
			new Room("Shed", "a Shed", "In a shed under the porch, there are stairs to the porch to the east and there is a river to the south", null, null, "Porch", "River"),
			new Room("Upstairs", "the top floor of the House", "On the second floor of the house, there is a bed to the north. There are stairs back down to the main floor to the west", "Dream Room", "House", null ,null),
			new Room("Dream Room", "the top floor of the House", "You fall asleep, when you wake up you are back in the top floor of the house,\n with the stairs to the west and the bed to the north, but you feel that something has changed...", "dreamRoom2", "dreamHouse", null, null),
			new Room("dreamHouse", "the main floor of the House", "You walk downstairs to find everything all torn up and blood on the floor by the east porch door and the door to the forest is sealed shut. \nYou see a knife on the table", "dreamPorch", "dreamRoom3", "dreamPorch", null),
			new Room("dreamRoom2", "the top floor of the House", "You probably shouldn't go back to sleep. Maybe you should see whats going on downstairs...", null, "dreamHouse", null, null),
			new Room("dreamRoom3", "the top floor of the House", "You are back upstairs, with the stairs to the west and the bed, but you probably shouldnt sleep", null, "dreamHouse", null, null),
			new Room("dreamPorch", "the porch", "You are on the porch, with doors to the house to the north and west and stairs to the shed to the east. The trail of blood leads to \n the shed", "dreamHouse", "dreamHouse", "dreamShed", null),
			new Room("dreamShed", "the shed", "You are in the shed under the porch, with stairs up to the porch to the east and the river to the south. There is a lot of blood here\n and it seems to lead outside to the river. The shed is surprisingly empty exept for a book that seems to be written is strange symbols", null, null, "dreamPorch", "dreamRiver"),
			new Room("dreamRiver", "the river", "You are next to the river south of the shed, to the west is the forest. The trail of blood leads toward the forest. There is a small\n stone here with some strange carvings on it", "dreamShed", "dreamForest", null, null),
			new Room("dreamForest", "the forest", "You are in the forest south of your house, but your house is nowhere to be seen. The trail of blood leads to a strange door set in a\n stone wall that you dont remember ever being there before, next to the door is an indentation in the wall that looks fit for a small\n rock. West leads back to the river", null, "dreamRiver", null, null)
			
	};

	public RoomMap(){
		Room r = null;
		GameObject go = null;
		
		r = findRoom("dreamHouse");
		GameObject knife = new GameObject("knife", "a shiny knife");
		r.objects.forceAdd(knife);
		GameObject table = new GameObject("table", "a wooden table", true);
		r.objects.forceAdd(table);
		
		r = findRoom("Forest");
		go = new GameObject("stick", "a small crooked stick");
		r.objects.forceAdd(go);
		
		go = new GameObject("tree", "a tall tree", true);
		r.objects.forceAdd(go);
		
		r = findRoom("dreamShed");
		go = new GameObject("book", "a book written in strange symbols");
		r.objects.forceAdd(go);
		
		r = findRoom("dreamRiver");
		go = new GameObject("stone", "a stone with strange carvings engraved in it");
		r.objects.forceAdd(go);
		
	}
	
	private Room location = findRoom("Forest");
	public Room getLocation() { return location; }
	
	public String roomTitle(){
		return location.title;
	}
	public Room findRoom(String room_title) {
		for (int i=0; i<rooms.length; i=i+1) {
			Room thisRoom = rooms[i];

			if (thisRoom.title.equals(room_title)) {
				return thisRoom;
			}
		}
		return null;

	}


	public void showLocation() {
		location.showRoom();
	}

	public void moveTo (String dest){
		Room newlocation = findRoom(dest);
		if(newlocation == null){
			Game.message("You cant go there");
		} else { 
			location = newlocation;
		}
	}
	public void moveNorth (){
		moveTo(location.nExit);
	}
	public void moveSouth (){
		moveTo(location.sExit);
	}
	public void moveEast (){
		moveTo(location.eExit);
	}
	public void movewest (){
		moveTo(location.wExit);
	}
	public void dreamActivate (){
		moveTo("Dream Room");
	}
}
