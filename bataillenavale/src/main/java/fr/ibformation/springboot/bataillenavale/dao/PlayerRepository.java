package fr.ibformation.springboot.bataillenavale.dao;

import org.springframework.data.repository.CrudRepository;

import bataillenavalemodels.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {
	
	Player findByNickname(String nickname);

}
