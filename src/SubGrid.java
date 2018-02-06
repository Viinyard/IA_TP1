import java.util.ArrayList;
import java.util.List;

public class SubGrid {

	public ArrayList<Case> sub;
	
	public SubGrid() {
		this.sub = new ArrayList<Case>();
	}
	
	public void add(Case c) {
		this.sub.add(c);
	}
	
	public List<Case> getList() {
		return this.sub;
	}
}
