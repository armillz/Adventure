
public class GameObject {
	public String name;
	public String description;
	public GameObject(String the_name, String the_description){
		name = the_name;
		description = the_description;
	}
	public void showObject(){
		Game.message(name);
	}
}
