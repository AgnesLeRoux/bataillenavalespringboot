package bataillenavalemodels;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.util.Properties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Game implements Serializable
{
	
	/**
	 * 
	 */
	
	public enum GameStatus{open, ongoing, over};
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idGame;
	@Enumerated(EnumType.STRING)
	private GameStatus status; 
	private final int nbMovesMax;// = 10;//60;
	private int nbMoves;
	private int currentPlayer; //1 for player 1  and 2 for player 2
	@OneToOne
	private Player player1;
	@OneToOne
	private Player player2;
	@OneToOne(cascade = CascadeType.ALL)
	private Grid grid1;
	@OneToOne(cascade = CascadeType.ALL)
	private Grid grid2;
	private int nbPointPlayer1;
	private int nbPointPlayer2;
	@OneToOne(cascade = CascadeType.ALL)
	private Player winner;
	
	@Transient
	private Properties properties = new Properties();
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	public void initializeGame(Player player)
	{
		this.status = (GameStatus.open);
		this.nbMoves = 0;
		this.player1 = player;
		this.currentPlayer = 1;
		player.getGamesId().add(this.idGame);
		player.setCurrentGame(this);
	}
	
	public boolean receiveShoot(Shoot shoot)
	{
		if(status != GameStatus.ongoing)
		{
			//TODO : exception
			System.err.println("unallowed shoot");
			System.exit(9);
		}
		
		if(currentPlayer == 1 && shoot.getPlayer() != player1 ||
			currentPlayer == 2 && shoot.getPlayer() != player2)
		{
			return false;
		}
		
		if(currentPlayer==1)
		{
			this.nbPointPlayer1 += grid2.receiveShoot(shoot.getCoord1(), shoot.getCoord2());
		}
		else
		{
			this.nbPointPlayer2 += grid1.receiveShoot(shoot.getCoord1(), shoot.getCoord2());
		}
		
		currentPlayer = (currentPlayer==1)?2:1; //switch currentPlayer id
		
		nbMoves++;
		if(nbMoves >= nbMovesMax)//TODO count if the max nb of points is obtained
			status = GameStatus.over;
		
		if(status == GameStatus.over)
		{
			computeWinner();
			if(winner == player1)
			{
				player1.setNbWin( player1.getNbWin()+1) ;
				player2.setNbLose( player2.getNbLose()+1) ;
			}
			if(winner == player2)
			{
				player2.setNbWin( player2.getNbWin()+1) ;
				player1.setNbLose( player1.getNbLose()+1) ;
			}
			if(winner==null)
			{
				player2.setNbDraw( player2.getNbDraw()+1) ;
				player1.setNbDraw( player1.getNbDraw()+1) ;
			}
		}
		
		return true;
	}
	
	private void computeWinner() {
		if(this.nbPointPlayer1 > this.nbPointPlayer2)
			this.winner = player1;
		if(this.nbPointPlayer2 > this.nbPointPlayer1)
			this.winner = player2;
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////

	public Game() {
		super();
		this.grid1 = new Grid();
		this.grid2 = new Grid();
//		try {
//			BufferedReader in = new BufferedReader(new FileReader("properties/config.properties"));
//			this.properties.load(in);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		this.nbMovesMax = 10;//Integer.parseInt(properties.getProperty("nbMovesMax"));
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

	public int getNbPointPlayer1() {
		return nbPointPlayer1;
	}

	public void setNbPointPlayer1(int nbPointPlayer1) {
		this.nbPointPlayer1 = nbPointPlayer1;
	}

	public int getNbPointPlayer2() {
		return nbPointPlayer2;
	}

	public void setNbPointPlayer2(int nbPointPlayer2) {
		this.nbPointPlayer2 = nbPointPlayer2;
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
	
	public String stateGameToString()
	{
		String str = "";
		
		if(status != GameStatus.over)
		{
			str += "Player1 state\n";
			str += grid1.boatsToString()+ "\n"+ grid2.myToString();
			str += "Player2 state\n";
			str += grid2.boatsToString()+"\n" +grid1.myToString();
			str += "________________________________________________\n";
			
		}
		else
		{
			str += "game over\n";
			str += "the winner is" + winner +"\n" ;
		}
		
		return str;
		
	}
	

}
