package fr.ibformation.springboot.bataillenavale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bataillenavalemodels.Game;
import bataillenavalemodels.GameManager;
import bataillenavalemodels.Player;
import fr.ibformation.springboot.bataillenavale.dao.GameRepository;
import fr.ibformation.springboot.bataillenavale.dao.PlayerRepository;

@SpringBootApplication
public class BataillenavaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BataillenavaleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(GameRepository gameRepository, PlayerRepository playerRepository )
	{
		return (args)->{
			GameManager gm = new GameManager();
		
			Player p1 = new Player("Senga");
			playerRepository.save(p1);
			
			p1.playNewGame(gm);
			
			for(Game g: gm.getGames())
			{
				gameRepository.save(g);
				System.out.println("Game "+g);
				System.out.println(g.stateGameToString());
			}
			
			Player p2 = new Player("Agnes");
			playerRepository.save(p2);
			
			p2.playNewGame(gm);
			
			for(Game g: gm.getGames())
			{
				gameRepository.save(g);
			}
			
			playerRepository.save(p1);
			playerRepository.save(p2);
		};
	}
	
}
