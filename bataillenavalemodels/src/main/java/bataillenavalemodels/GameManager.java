package bataillenavalemodels;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import bataillenavalemodels.Game.GameStatus;

@Component
public class GameManager 
{
	private Iterable<Game> games = new ArrayList<Game>();
	private Iterable<Player> players = new ArrayList<Player>();

	@Autowired
	private CrudRepository<Game, Long> gameRepository;
	@Autowired
	private CrudRepository<Player, Long> playerRepository;
	
	///////////////////////////////////////////////////////////////////////////////////

	@PostConstruct
	public void init()
	{
		games = gameRepository.findAll();
		players = playerRepository.findAll();
	}
	
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
			((List<Game>) games).add(g);
		}
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	public List<Game> getGames() {
		return (List<Game>) games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public List<Player> getPlayers() {
		return (List<Player>) players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
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
