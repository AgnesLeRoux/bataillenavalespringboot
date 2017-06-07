package bataillenavalemodels;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import bataillenavalemodels.factories.BoatFactory;

@RunWith(MockitoJUnitRunner.class)
public class BoatFactoryTest {

	@Spy
	Grid grid;
	
	@Before
	public void setUp() throws Exception
	{
//		Mockito.when(grid.getNbRows()).thenReturn(5);
//		Mockito.when(grid.getNbCols()).thenReturn(6);
//		Mockito.when(grid.getBoats()).thenReturn(new ArrayList<Boat>());
//		Mockito.when(grid.getBoatTab()).thenReturn(new boolean[5][6]);
	}
	
	@Test
	public void testComputeNewBoat()
	{
		Mockito.when(grid.getNbRows()).thenReturn(5);
		Mockito.when(grid.getNbCols()).thenReturn(6);
		Mockito.when(grid.getBoats()).thenReturn(new ArrayList<Boat>());
		Mockito.when(grid.getBoatTab()).thenReturn(new boolean[5][6]);
		
		for(int i=0; i<10;i++)
		{
			Boat b = BoatFactory.computeNewBoat(5, grid);
			
			if(b.getCoord1()>= grid.getNbRows() )
			{
				fail("bCoord1> grid.getNbRows() "+ b.getCoord1()+ " >= " +grid.getNbRows());
				return;
			}
			if(b.getCoord2()>= grid.getNbCols() )
			{
				fail("bCoord2> grid.getNbCols() "+ b.getCoord2()+ " >= " +grid.getNbCols());
				return;
			}
			
			switch (b.getOrientation()) 
			{
			case horizontal:
				if(b.getCoord2()+b.getSize()-1 > grid.getNbCols())
				{
					fail("b.getCoord2()+b.getSize()-1 > grid.getNbCols()) "+
							(b.getCoord2()+b.getSize()-1) + ">" +grid.getNbCols());
					return;
				}
				break;

			case vertical :
				if(b.getCoord1()+b.getSize()-1 >grid.getNbRows())
				{
					fail("b.getCoord1()+b.getSize()-1 <grid.getNbRows() "+
							(b.getCoord1()+b.getSize()-1) + ">"+ grid.getNbRows());
					return;
				}
			}
		}

		Assert.assertTrue(true);

	}

	//TODO test if there are more than one boat in the grid
	
}
