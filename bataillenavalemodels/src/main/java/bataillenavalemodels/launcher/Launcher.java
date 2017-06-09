package bataillenavalemodels.launcher;


import bataillenavalemodels.Game;
import bataillenavalemodels.GameManager;
import bataillenavalemodels.Player;

public class Launcher {
	
	
	public static void main(String[] args) {
		
		GameManager gm = new GameManager();
		
		Player p1 = new Player("toto");
		Player p2 = new Player("tutu");
		
		p1.playNewGame(gm);
		p2.playNewGame(gm);
		
		System.out.println(p1);
		System.out.println(p2);
		
		Game g = p1.getCurrentGame();
		System.out.println(g);
//		System.out.println(g.stateGameToString());
		p1.shoot(0,4);
		
		p2.shoot(0,1);
		
		p1.shoot(0,2);
	
		p2.shoot(0, 6);
		
		p1.shoot(1, 2);
		
		p2.shoot(4, 4);
		
		p1.shoot(3, 2);
		
		p2.shoot(6, 8);
		
		p1.shoot(0, 5);
		System.out.println(g.stateGameToString());
		p2.shoot(7, 8);
		
		System.out.println(g.stateGameToString());
		
		p1.shoot(2, 8);
		
		
		
		
	}

}
