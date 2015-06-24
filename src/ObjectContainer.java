import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class ObjectContainer {
	List<GameObject> objects = new ArrayList<GameObject>();
	public void add(GameObject go){
		objects.add(go);

	}
	public void remove(GameObject go){
		objects.remove(go);
		
	}
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
	