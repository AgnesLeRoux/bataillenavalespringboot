package bataillenavalemodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Player implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idPlayer;
	private String nickname;
	private int nbWin;
	private int nbLose;
	private int nbDraw;
	
	@ElementCollection
	private List<Long> gamesId = new ArrayList<Long>();
	@OneToOne
	private Game currentGame;

	///////////////////////////////////////////////////////////////////////////////////
	
	public void playNewGame(GameManager gm)
	{
		gm.playNewGame(this);
	}
	
	public void shoot(int coord1, int coord2) 
	{
		Shoot shoot = new Shoot(coord1, coord2, this);
		currentGame.receiveShoot(shoot);
	}
	
	public void quitGame()
	{
		currentGame = null;
	}
	
	///////////////////////////////////////////////////////////////////////////////////

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(String nickname)
	{
		this.nickname = nickname;
	}
	
	
	public long getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(long idPlayer) {
		this.idPlayer = idPlayer;
	}

	public List<Long> getGamesId() {
		return gamesId;
	}

	public void setGamesId(List<Long> gamesId) {
		this.gamesId = gamesId;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getNbWin() {
		return nbWin;
	}
	public void setNbWin(int nbWin) {
		this.nbWin = nbWin;
	}
	public int getNbLose() {
		return nbLose;
	}
	public void setNbLose(int nbLose) {
		this.nbLose = nbLose;
	}
	public int getNbDraw() {
		return nbDraw;
	}
	public void setNbDraw(int nbDraw) {
		this.nbDraw = nbDraw;
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}

	@Override
	public String toString() {
		return "Player [idPlayer=" + idPlayer + ", nickname=" + nickname + ", nbWin=" + nbWin + ", nbLose=" + nbLose
				+ ", nbDraw=" + nbDraw + ", gamesId=" + gamesId + ", currentGameId=" + currentGame.getIdGame() + "]";
	}
	
}
