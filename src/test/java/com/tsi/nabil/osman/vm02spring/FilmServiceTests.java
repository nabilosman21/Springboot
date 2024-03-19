package com.tsi.nabil.osman.vm02spring;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FilmServiceTest {

    @Mock
    private FilmRepository filmRepository;

    @InjectMocks
    private FilmService filmService;

    public FilmServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddFilm() {

        Film film = new Film();
        film.setTitle("Example Film");
        film.setDescription("This is an example film");
        when(filmRepository.save(film)).thenReturn(film);


        Film savedFilm = filmService.addFilm(film);

        // Verify result
        assertEquals("Example Film", savedFilm.getTitle());
        assertEquals("This is an example film", savedFilm.getDescription());
    }

    @Test
    void testGetFilmById() {

        int filmId = 1;
        Film film = new Film();
        film.setFilmID(filmId);
        when(filmRepository.findById(filmId)).thenReturn(Optional.of(film));


        Optional<Film> result = filmService.getFilmById(filmId);


        assertEquals(filmId, result.get().getFilmID());
    }

    @Test
    void testUpdateFilm() {

        int filmId = 1;
        Film film = new Film();
        film.setFilmID(filmId);
        film.setTitle("Updated Film Title");
        film.setDescription("Updated Film Description");
        when(filmRepository.save(film)).thenReturn(film);


        Film updatedFilm = filmService.updateFilm(filmId, film);


        assertEquals(filmId, updatedFilm.getFilmID());
        assertEquals("Updated Film Title", updatedFilm.getTitle());
        assertEquals("Updated Film Description", updatedFilm.getDescription());
    }

    @Test
    void testDeleteFilmById() {

        int filmId = 1;


        filmService.deleteFilmById(filmId);


        verify(filmRepository, times(1)).deleteById(filmId);
    }
}
