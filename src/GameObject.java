
public class GameObject {
	public String name;
	public String description;
	private boolean immovable = false;
	
	
	public GameObject(String the_name, String the_description){
		name = the_name;
		description = the_description;
	}
	public GameObject(String the_name, String the_description, boolean is_immovable) {
		this(the_name, the_description); // invoke other constructor
		immovable=is_immovable;
		
	}
	public void showObject(){
		Game.message(name);
	}
	
	/***
	 * "smart" insert which verifies that the object can be put in this container
	 * Most operations in the game should use this.
	 */
	public String insertInto(ObjectContainer oc) {
		if (immovable) {
			String msg = "You can not put " + name + " into " + oc.name;
			Game.message(msg);
			return msg; // return message so we can print it or detect "failure"
		} else {
			oc.forceAdd(this);
			return null; // no message means success
		}
		
	}
	
	/***
	 * "smart" remove which verifies that the object can be removed from in this container
	 * Most operations in the game should use this.
	 */
	public String removeFrom(ObjectContainer oc) {
		if (immovable) {
			String msg = "You can not remove " + name + " from " + oc.name;
			Game.message(msg);
			return msg; // return message so we can print it or detect "failure"
		} else {
			oc.forceRemove(this);
			return null; // no message means success
		}
		
	}
}
