package bataillenavalemodels.factories;

import java.util.Random;

import bataillenavalemodels.Boat;
import bataillenavalemodels.Boat.Orientation;
import bataillenavalemodels.Grid;

public class BoatFactory 
{
	//TODO the factory should be a singleton
	
	Random rnd = new Random();
	
	
	public Boat computeNewBoat(int size, Grid grid )
	{
		Boat boat = new Boat();
		int nbRows = grid.getNbRows();
		int nbCols = grid.getNbCols();
		
		boolean boatDoesNotOverlap = false;
		while(boatDoesNotOverlap)
		{
			if(rnd.nextInt(1) == 0)
			{
				boat.setOrientation(Orientation.vertical);
				boat.setCoord1(nbRows-size);
				boat.setCoord2(nbCols);
			}
			else
			{
				boat.setOrientation(Orientation.horizontal);
				boat.setCoord1(nbRows);
				boat.setCoord2(nbCols-size);
			}
			boatDoesNotOverlap = true;
			for(Boat boatInGrid : grid.getBoats())
			{
				if(boatInGrid.overlap(boat))
				{	
					boatDoesNotOverlap = false;
					break;
				}
			}
		}
		
		return boat;
	}
	
	
	
}
