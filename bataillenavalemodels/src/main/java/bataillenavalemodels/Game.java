package bataillenavalemodels;

import java.io.Serializable;

public class Game implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idGame;
	private boolean finished; // true if the game is over
	private final int nbMovesMax = 60;
	private int nbMoves;
	private int currentPlayer; //1 for player 1  and 2 for player 2
	private Player player1;
	private Player player2;
	private Grid grid1;
	private Grid grid2;
	
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
	
	

	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
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
	
	

}
