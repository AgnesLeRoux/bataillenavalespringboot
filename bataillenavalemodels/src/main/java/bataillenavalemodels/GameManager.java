package bataillenavalemodels;

import java.util.ArrayList;
import java.util.List;

import bataillenavalemodels.Game.GameStatus;

public class GameManager 
{
	
	//TODO singleton
	private List<Game> games = new ArrayList<Game>();

	///////////////////////////////////////////////////////////////////////////////////

	public void playNewGame(Player player) 
	{
		boolean hasFoundGame = false;
		for(Game game : games)
		{
			if(!hasFoundGame && game.getStatus() == GameStatus.open)
			{
				game.setPlayer2(player);
				game.setStatus(GameStatus.ongoing);
				hasFoundGame = true;
				player.getGamesId().add(game.getIdGame());
				player.setCurrentGame(game);
				
				//TODO check that player 1 is not the same as player
			}
		}
		
		if(!hasFoundGame)
		{
			Game g = new Game();
			g.initializeGame(player);
			games.add(g);
		}
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
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
