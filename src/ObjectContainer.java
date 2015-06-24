import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class ObjectContainer {
	
	String name = "container";
	List<GameObject> objects = new ArrayList<GameObject>();

	// Default constructor with default parameters
	public ObjectContainer(){
	}

	// Constructor to name the container
	public ObjectContainer(String n){
		this.name=n;
	}
	
	// Insert object into container, regardless of constraints.
	public void forceAdd(GameObject go){
		objects.add(go);
	}
	
	// "smart" insert which uses the object to ensure that it is containable.
	// Most operations during the game should use this.
	public void insert(GameObject go){
		if (go != null) { 
			go.insertInto(this);
		}
	}
	
	// "smart" remove which uses the object to ensure it is removable.
	public void remove(GameObject go) {
		if (go != null) { 
			go.removeFrom(this);
		}
	}

	// smart remove by name
	public GameObject remove(String name){
		GameObject go = findObject(name);
		if (go != null) {
			remove(go);
		}
		return go;
	}
	// Remove object from this container, regardless of constraints
	public void forceRemove(GameObject go){
		objects.remove(go);
	}

	/***
	 * Find an object by name.
	 * Returns null if cannot be found.
	 * @param name
	 * @return
	 */
	public GameObject findObject(String name){
		ListIterator<GameObject> litr = null;
		litr = objects.listIterator();
		while(litr.hasNext()){
			GameObject go = litr.next();
			String oname = go.name;
			if(oname.equals(name)){
				return go;
			}

		}
		return null;
	}
	public void showAllObjects(){
		ListIterator<GameObject> litr = null;
		litr = objects.listIterator();
		while(litr.hasNext()){
			GameObject go = litr.next();
			go.showObject();
		}

	}
	
}
	