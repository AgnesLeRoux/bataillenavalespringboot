package bataillenavalemodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bataillenavalemodels.Boat.Orientation;
import bataillenavalemodels.factories.BoatFactory;

public class Grid implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idGrid;
	private int nbRows=10;
	private int nbCols=10;

	private boolean[][] stateTab = new boolean[nbRows][nbCols];//true if the cell is shooted (discovered)
	private List<Cell> cells = new ArrayList<Cell>();

	private boolean[][] boatTab = new boolean[nbRows][nbCols];//the cell contains a boat or not
	private List<Boat> boats = new ArrayList<Boat>();



	public Grid() {
		super();

		for(int i=0; i< nbRows;i++)
			for(int j=0;j<nbCols;j++)
				cells.add(new Cell(i,j));

		boats.add(BoatFactory.computeNewBoat(5, this));

		for(Boat b : boats)
			updateBoatTab(b);
	}

	private void updateBoatTab(Boat b) 
	{
		switch(b.getOrientation())
		{
		case vertical:
		{
			int c2 = b.getCoord2();
			for(int c1 = b.getCoord1(); c1 < b.getCoord1()+b.getSize(); c1++)
			{
				boatTab[c1][c2]=true;
			}
		}
		break;
		case horizontal:
		{
			int c1 = b.getCoord1();
			for(int c2 = b.getCoord2(); c2 <b.getCoord2()+ b.getSize(); c2++)
			{
				boatTab[c1][c2]=true;
			}
		}
		}
	}

	public int receiveShoot(int coord1, int coord2)
	{
		stateTab[coord1][coord2] = true;
		cells.get(convertCoord2Index(coord1,coord2)).setShooted(true);
		if(boatTab[coord1][coord2])
			return 1;
		else
			return 0;

	}

	private int convertCoord2Index(int coord1, int coord2)
	{
		return coord1*nbRows + coord2;
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

	public String myToString()
	{
		String str = "";
		for(int i=0;i<nbRows; i++)
		{
			for(int j=0; j<nbCols; j++)
			{
				if(stateTab[i][j])
				{
					if(boatTab[i][j])
						str+= "X";
					else
						str+="0";
				}
				else
					str += ".";
			}
			str += "\n";
		}
		return str;
	}
	
	public String boatsToString()
	{
		String str = "";
		for(int i=0;i<nbRows; i++)
		{
			for(int j=0; j<nbCols; j++)
			{
				if(boatTab[i][j])
				{
					str+="B";
				}
				else
				{
					str += ".";
				}
			}
			str +="\n";
		}
		
		return str;
	}

}
