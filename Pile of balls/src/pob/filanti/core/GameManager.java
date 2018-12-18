package pob.filanti.core;
public class GameManager {
	
	private static GameManager instance;
	
	public static GameManager getInstance() {
		if(instance==null) {
			instance=new GameManager();
		}
		return instance;
	}
	
	private TrisBalls current;
	private TrisBalls nextTris;
	
	private GameManager() {
		current=new TrisBalls();
	}
	
	public TrisBalls getCurrent() {
		return current;
	}

	public void update() {
		current.update();
	}

	
}
