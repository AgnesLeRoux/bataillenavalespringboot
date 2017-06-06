package bataillenavalemodels;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import bataillenavalemodels.Boat.Orientation;



@RunWith(MockitoJUnitRunner.class)
public class BoatTest {

	
	Boat boat1 = new Boat(), boat2=new Boat();

	@Test
	public void testOverlap1() 
	{
		boat1.setCoord1(1);
		boat1.setCoord2(2);
		boat1.setSize(3);
		boat1.setOrientation(Orientation.horizontal);
		boat2.setCoord1(0);
		boat2.setCoord2(3);
		boat2.setSize(2);
		boat2.setOrientation(Orientation.vertical);

		Assert.assertTrue(boat2.overlap(boat1));
		Assert.assertTrue(boat1.overlap(boat2));
	}

	@Test
	public void testOverlap2()
	{
		boat1.setCoord1(1);
		boat1.setCoord2(2);
		boat1.setSize(3);
		boat1.setOrientation(Orientation.vertical);
		boat2.setCoord1(0);
		boat2.setCoord2(3);
		boat2.setSize(2);
		boat2.setOrientation(Orientation.vertical);
		Assert.assertFalse(boat2.overlap(boat1));
		Assert.assertFalse(boat1.overlap(boat2));
		
		boat1.setOrientation(Orientation.horizontal);
		boat2.setOrientation(Orientation.horizontal);
	
		Assert.assertFalse(boat2.overlap(boat1));
		Assert.assertFalse(boat1.overlap(boat2));
	}
	
	@Test
	public void testOverlap3()
	{
		boat1.setCoord1(1);
		boat1.setCoord2(2);
		boat1.setSize(3);
		boat1.setOrientation(Orientation.horizontal);
		boat2.setCoord1(1);
		boat2.setCoord2(5);
		boat2.setSize(2);
		boat2.setOrientation(Orientation.horizontal);
		Assert.assertFalse(boat2.overlap(boat1));
		Assert.assertFalse(boat1.overlap(boat2));
		
		boat1.setOrientation(Orientation.vertical);
		boat2.setOrientation(Orientation.vertical);
		boat2.setCoord1(4);
		boat2.setCoord2(2);
	
		Assert.assertFalse(boat2.overlap(boat1));
		Assert.assertFalse(boat1.overlap(boat2));
	}
	
	@Test
	public void testOverlap4()
	{
		boat1.setCoord1(1);
		boat1.setCoord2(2);
		boat1.setSize(3);
		boat1.setOrientation(Orientation.horizontal);
		boat2.setCoord1(1);
		boat2.setCoord2(4);
		boat2.setSize(2);
		boat2.setOrientation(Orientation.horizontal);
		Assert.assertTrue(boat2.overlap(boat1));
		Assert.assertTrue(boat1.overlap(boat2));
		
		boat1.setOrientation(Orientation.vertical);
		boat2.setOrientation(Orientation.vertical);
		boat2.setCoord1(3);
		boat2.setCoord2(2);
	
		Assert.assertTrue(boat2.overlap(boat1));
		Assert.assertTrue(boat1.overlap(boat2));
	}
	
	@Test
	public void testIntersect1() 
	{
		int a=1,b=5,c=7,d=8;
		Assert.assertFalse(Boat.intersect(a, b, c, d));
	}

	@Test
	public void testIntersect2() 
	{
		int a=1,b=5,c=7,d=8;
		Assert.assertFalse(Boat.intersect(c,d,a,b));
	}

	@Test
	public void testIntersect3() 
	{
		int a=1,b=9,c=7,d=8;
		Assert.assertTrue(Boat.intersect(a, b, c, d));
	}

	@Test
	public void testIntersect4() 
	{
		int a=1,b=9,c=7,d=8;
		Assert.assertTrue(Boat.intersect( c, d,a,b));
	}

}
