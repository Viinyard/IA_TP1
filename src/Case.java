import java.awt.Point;
import java.util.HashSet;
import java.util.Optional;

/*
 * TP 1 - IA Informatique : Sudoku
 * 
 * @author Tassadit BOUADI.
 */

public class Case implements Cloneable {
	private Point pos;
	private Optional<Integer> value = Optional.empty();
	
	private SubGrid x, y, sub;
	
	private HashSet<Case> linkedCase;

	public Case(Point pos, int value) {
		this(pos);
		this.value = Optional.of(value);
	}
	
	public void link(SubGrid x, SubGrid y, SubGrid sub) {
		this.x = x;
		this.y = y;
		this.sub = sub;
		
		this.linkedCase.addAll(this.x.getList());
		this.linkedCase.addAll(this.y.getList());
		this.linkedCase.addAll(this.sub.getList());
	}

	public Case(Point pos) {
		this.linkedCase = new HashSet<Case>();
		this.pos = pos;
	}

	public int getX() {
		return this.pos.x;
	}

	public int getY() {
		return this.pos.y;
	}

	public boolean isValue() {
		return this.value.isPresent();
	}

	public int getValueOf() {
		return this.value.get();
	}

	public Optional<Integer> getValue() {
		return this.value;
	}

	public void setVal(int value) {
		this.value = Optional.of(value);
	}

	public String toString() {
		return "[" + this.getX() + "," + this.getY() + "] " + this.getValue();
	}

}