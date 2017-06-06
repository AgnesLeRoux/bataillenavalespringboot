package bataillenavalemodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idGrid;
	private int nbRows=10;
	private int nbCols=10;
	private boolean[][] stateTab = new boolean[nbRows][nbCols];//the cell is shooted
	private boolean[][] boatTab = new boolean[nbRows][nbCols];//the cell contains a boat or not
	private List<Boat> boats = new ArrayList<Boat>();
	public Grid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNbRows() {
		return nbRows;
	}
	public void setNbRows(int nbRows) {
		this.nbRows = nbRows;
	}
	public int getNbCols() {
		return nbCols;
	}
	public void setNbCols(int nbCols) {
		this.nbCols = nbCols;
	}
	public boolean[][] getStateTab() {
		return stateTab;
	}
	public void setStateTab(boolean[][] stateTab) {
		this.stateTab = stateTab;
	}
	public List<Boat> getBoats() {
		return boats;
	}
	public void setBoats(List<Boat> boats) {
		this.boats = boats;
	}
	public long getIdGrid() {
		return idGrid;
	}
	public void setIdGrid(long idGrid) {
		this.idGrid = idGrid;
	}
	@Override
	public String toString() {
		return "Grid [idGrid=" + idGrid + ", nbRows=" + nbRows + ", nbCols=" + nbCols + ", stateTab="
				+ Arrays.toString(stateTab) + ", boats=" + boats + "]";
	}
	public boolean[][] getBoatTab() {
		return boatTab;
	}
	public void setBoatTab(boolean[][] boatTab) {
		this.boatTab = boatTab;
	}
		
	
	
}
