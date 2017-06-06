package bataillenavalemodels;

import java.io.Serializable;

public class Game implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum GameStatus{open, ongoing, over};
	
	
	private long idGame;
	private GameStatus status; 
	private final int nbMovesMax = 60;
	private int nbMoves;
	private int currentPlayer; //1 for player 1  and 2 for player 2
	private Player player1;
	private Player player2;
	private Grid grid1;
	private Grid grid2;
	private Player winner;
	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	public int getNbMoves() {
		return nbMoves;
	}
	public void setNbMoves(int nbMoves) {
		this.nbMoves = nbMoves;
	}
	
	public Grid getGrid1() {
		return grid1;
	}
	public void setGrid1(Grid grid1) {
		this.grid1 = grid1;
	}
	public Grid getGrid2() {
		return grid2;
	}
	public void setGrid2(Grid grid2) {
		this.grid2 = grid2;
	}

	public long getIdGame() {
		return idGame;
	}

	public void setIdGame(long idGame) {
		this.idGame = idGame;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public int getNbMovesMax() {
		return nbMovesMax;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Game [idGame=" + idGame + ", status=" + status + ", nbMovesMax=" + nbMovesMax + ", nbMoves=" + nbMoves
				+ ", currentPlayer=" + currentPlayer + ", player1=" + player1 + ", player2=" + player2 + ", grid1="
				+ grid1 + ", grid2=" + grid2 + ", winner=" + winner + "]";
	}

}
