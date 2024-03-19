package com.tsi.nabil.osman.vm02spring;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ActorServiceTest {

    @Mock
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorService actorService;

    public ActorServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddActor() {

        Actor actor = new Actor();
        actor.setFirstName("Joe");
        actor.setLastName("Bee");
        when(actorRepository.save(actor)).thenReturn(actor);

        Actor savedActor = actorService.addActor(actor);


        assertEquals(actor.getFirstName(), savedActor.getFirstName());
        assertEquals(actor.getLastName(), savedActor.getLastName());
    }

    @Test
    void testGetActorById() {

        int actorId = 1;
        Actor actor = new Actor();
        actor.setActorID(actorId);
        when(actorRepository.findById(actorId)).thenReturn(Optional.of(actor));


        Optional<Actor> result = actorService.getActorById(actorId);


        assertEquals(actorId, result.get().getActorID());
    }

    @Test
    void testUpdateActor() {

        int actorId = 1;
        Actor actor = new Actor();
        actor.setActorID(actorId);
        actor.setFirstName("Updated First Name");
        actor.setLastName("Updated Last Name");
        when(actorRepository.save(actor)).thenReturn(actor);


        Actor updatedActor = actorService.updateActor(actorId, actor);


        assertEquals(actorId, updatedActor.getActorID());
        assertEquals("Updated First Name", updatedActor.getFirstName());
        assertEquals("Updated Last Name", updatedActor.getLastName());
    }

    @Test
    void testDeleteActorById() {

        int actorId = 1;


        actorService.deleteActorById(actorId);


        verify(actorRepository, times(1)).deleteById(actorId);
    }
}
