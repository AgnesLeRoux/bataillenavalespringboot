package fr.ibformation.springboot.bataillenavale.dao;

import org.springframework.data.repository.CrudRepository;

import bataillenavalemodels.Game;

public interface GameRepository extends CrudRepository<Game, Long> 
{
	
}
