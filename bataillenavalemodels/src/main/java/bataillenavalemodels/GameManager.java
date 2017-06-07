package bataillenavalemodels;

import java.util.ArrayList;
import java.util.List;

public class GameManager 
{
	private List<Game> games = new ArrayList<Game>();

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "GameManager [games=" + games + "]";
	}

	public GameManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
