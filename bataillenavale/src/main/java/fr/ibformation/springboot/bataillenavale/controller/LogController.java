package fr.ibformation.springboot.bataillenavale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bataillenavalemodels.GameManager;
import bataillenavalemodels.Player;
import fr.ibformation.springboot.bataillenavale.dao.PlayerRepository;
import fr.ibformation.springboot.bataillenavale.myutil.Message;

@RestController
@RequestMapping(path="/welcome")
public class LogController 
{
	@Autowired GameManager gm;
	@Autowired PlayerRepository playerRepository;
	

	//@PostMapping(value="/login")

	@PostMapping(value="/login")
	//@RequestMapping(path="/login", method=RequestMethod.POST)
	public Player login(@RequestBody Message message)
	{
		System.out.println(message);
		System.out.println(message.getValue());
		Player p = new Player(message.getValue());
		playerRepository.save(p);
		return p;
	}
}
