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
	
	private GameManager() {
		current=new TrisBalls();
	}
	
	public void update() {
		current.update();
	}

	public TrisBalls getCurrent() {
		return current;
	}

	
}
