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

	private final ActorService actorService;
	private final FilmService filmService;

	@Autowired
	public Vm02springApplication(ActorService actorService, FilmService filmService) {
		this.actorService = actorService;
		this.filmService = filmService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Vm02springApplication.class, args);
	}

	// Actor Endpoints

	@GetMapping("/allActors")
	public Iterable<Actor> getAllActors() {
		return actorService.getAllActors();
	}

	@PostMapping("/addActor")
	public Actor addActor(@RequestBody Actor actor) {
		return actorService.addActor(actor);
	}

	@GetMapping("/getActor/{id}")
	public Actor getActorById(@PathVariable int id) {
		return actorService.getActorById(id).orElse(null);
	}

	@PutMapping("/updateActor/{id}")
	public Actor updateActor(@PathVariable int id, @RequestBody Actor actor) {
		return actorService.updateActor(id, actor);
	}

	@DeleteMapping("/deleteActor/{id}")
	public void deleteActorById(@PathVariable int id) {
		actorService.deleteActorById(id);
	}

	// Film Endpoints

	@GetMapping("/allFilms")
	public Iterable<Film> getAllFilms() {
		return filmService.getAllFilms();
	}

	@GetMapping("/getFilm/{id}")
	public Film getFilmById(@PathVariable int id) {
		return filmService.getFilmById(id).orElse(null);
	}

	@PostMapping("/addFilm")
	public Film addFilm(@RequestBody Film film) {
		return filmService.addFilm(film);
	}

	@PutMapping("/updateFilm/{id}")
	public Film updateFilm(@PathVariable int id, @RequestBody Film film) {
		return filmService.updateFilm(id, film);
	}

	@DeleteMapping("/deleteFilm/{id}")
	public void deleteFilmById(@PathVariable int id) {
		filmService.deleteFilmById(id);
	}
}
