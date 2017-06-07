package bataillenavalemodels.factories;

import java.util.Random;

import bataillenavalemodels.Boat;
import bataillenavalemodels.Boat.Orientation;
import bataillenavalemodels.Grid;

public class BoatFactory 
{
	//TODO the factory should be a singleton
	
	private static Random rnd = new Random(42);
	
	
	public static Boat computeNewBoat(int size, Grid grid )
	{
		Boat boat = new Boat();
		int nbRows = grid.getNbRows();
		int nbCols = grid.getNbCols();
		
		boolean boatOverlap = true;
		while(boatOverlap)
		{
			if(rnd.nextInt(1) == 0)
			{
				boat.setOrientation(Orientation.vertical);
				boat.setCoord1(rnd.nextInt(nbRows-size));
				boat.setCoord2(rnd.nextInt(nbCols));
			}
			else
			{
				boat.setOrientation(Orientation.horizontal);
				boat.setCoord1(rnd.nextInt(nbRows));
				boat.setCoord2(rnd.nextInt(nbCols-size));
			}
			
			boatOverlap = false;
			for(Boat boatInGrid : grid.getBoats())
			{
				if(boatInGrid.overlap(boat))
				{	
					boatOverlap = true;
					break;
				}
			}
		}
		
		return boat;
	}
	
	
	
}
