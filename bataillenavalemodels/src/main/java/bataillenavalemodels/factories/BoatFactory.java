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
		boat.setSize(size);
		int nbRows = grid.getNbRows();
		int nbCols = grid.getNbCols();
		
		boolean boatOverlap = true;
		while(boatOverlap)
		{
			if(rnd.nextBoolean())
			{
				boat.setOrientation(Orientation.vertical);
				boat.setCoord1(rnd.nextInt(nbRows-size+1));
				boat.setCoord2(rnd.nextInt(nbCols));
			}
			else
			{
				boat.setOrientation(Orientation.horizontal);
				boat.setCoord1(rnd.nextInt(nbRows));
				boat.setCoord2(rnd.nextInt(nbCols-size+1));
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
