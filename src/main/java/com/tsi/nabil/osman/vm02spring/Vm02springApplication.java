package com.tsi.nabil.osman.vm02spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class Vm02springApplication {

	@Autowired
	private ActorRepository actorRep;

	public Vm02springApplication(ActorRepository actorRepo){
		this.actorRep = actorRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Vm02springApplication.class, args);
	}

	@GetMapping("/allActors")
	public Iterable<Actor> getAllActors(){
		return actorRep.findAll();

	}


}
