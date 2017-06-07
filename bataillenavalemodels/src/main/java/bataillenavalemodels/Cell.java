package bataillenavalemodels;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cell implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private int coord1;
	private int coord2;
	private boolean containsBoat;
	private boolean isShooted;
	@ManyToOne
	private Grid grid;
	
//	public Cell() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	public Cell(int coord1, int coord2)
	{
		this.coord1 = coord1;
		this.coord2 = coord2;
	}

	public int getCoord1() {
		return coord1;
	}

	public void setCoord1(int coord1) {
		this.coord1 = coord1;
	}

	public int getCoord2() {
		return coord2;
	}

	public void setCoord2(int coord2) {
		this.coord2 = coord2;
	}

	public boolean isContainsBoat() {
		return containsBoat;
	}

	public void setContainsBoat(boolean containsBoat) {
		this.containsBoat = containsBoat;
	}

	public boolean isShooted() {
		return isShooted;
	}

	public void setShooted(boolean isShooted) {
		this.isShooted = isShooted;
	}

	@Override
	public String toString() {
		return "Cell [coord1=" + coord1 + ", coord2=" + coord2 + ", containsBoat=" + containsBoat + ", isShooted="
				+ isShooted + "]";
	}

	public void setGrid(Grid grid) 
	{
		this.grid = grid;
	}

	public Grid getGrid() {
		return grid;
	}

}
