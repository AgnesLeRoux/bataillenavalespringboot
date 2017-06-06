package bataillenavalemodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idPlayer;
	private String nickname;
	private int nbWin;
	private int nbLose;
	private int nbDraw;
	List<Integer> gamesId = new ArrayList<Integer>();
	
	
	

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public long getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(long idPlayer) {
		this.idPlayer = idPlayer;
	}

	public List<Integer> getGamesId() {
		return gamesId;
	}

	public void setGamesId(List<Integer> gamesId) {
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




	@Override
	public String toString() {
		return "Player [idPlayer=" + idPlayer + ", nickname=" + nickname + ", nbWin=" + nbWin + ", nbLose=" + nbLose
				+ ", nbDraw=" + nbDraw + ", gamesId=" + gamesId + "]";
	}
	
}
