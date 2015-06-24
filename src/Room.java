
public class Room {
	public String description;
	public String name;
	public String title;
	public String nExit;
	public String wExit;
	public String eExit;
	public String sExit;
	public ObjectContainer objects = new ObjectContainer();
	
	public Room(String the_title, 
			String the_name,
			String the_description, 
			String n_exit, 
			String w_exit, 
			String e_exit, 
			String s_exit 
			) {
		description = the_description;
		title = the_title;
		name = the_name;
		nExit = n_exit; 
		eExit = e_exit;
		sExit = s_exit;
		wExit = w_exit;
	}

	public void showRoom(){
		Game.message("You are in " + name);
		Game.message(description);
		Game.message("Items in room:");
		objects.showAllObjects();

	}
	public GameObject removeObject(String name){
		GameObject go = null;
		go = objects.findObject(name);
		if(go == null){
			Game.message("There is no object " + name);
		}
		objects.remove(go);
		return go;
	}
}
