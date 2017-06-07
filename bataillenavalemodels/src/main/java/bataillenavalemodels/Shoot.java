package bataillenavalemodels;

import java.io.Serializable;

public class Shoot implements Serializable {

	private int coord1;
	private int coord2;
	private Player player;
	
	public Shoot(int coord1, int coord2, Player player)
	{
		this.coord1 = coord1;
		this.coord2 = coord2;
		this.player = player;
	}

	public Shoot() {
		super();
		// TODO Auto-generated constructor stub
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Shoot [coord1=" + coord1 + ", coord2=" + coord2 + ", player=" + player + "]";
	}
	
	
	
}
