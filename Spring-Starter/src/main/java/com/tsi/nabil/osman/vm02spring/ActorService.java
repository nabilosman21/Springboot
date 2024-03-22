package com.tsi.nabil.osman.vm02spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    // Create (Save) a new actor
    public Actor addActor(Actor actor) {
        return actorRepository.save(actor);
    }

    // Read (Find) an actor by ID
    public Optional<Actor> getActorById(int id) {
        return actorRepository.findById(id);
    }

    // Update an existing actor
    public Actor updateActor(int id, Actor actor) {
        actor.setActorID(id); // Ensure the ID matches the path variable
        return actorRepository.save(actor);
    }

    // Delete an actor by ID
    public void deleteActorById(int id) {
        actorRepository.deleteById(id);
    }

    // Get all actors
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }
}
