package ru.job4j.cinema.service.filmsession;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.repository.filmsession.FilmSessionRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class SimpleFileSessionService implements FilmSessionService {

    private final FilmSessionRepository filmSessionRepository;

    private SimpleFileSessionService(FilmSessionRepository sql2oFilmSessionRepository) {
        this.filmSessionRepository = sql2oFilmSessionRepository;
    }

    @Override
    public Optional<FilmSession> findById(int id) {
        return filmSessionRepository.findById(id);
    }

    @Override
    public Collection<FilmSession> findAll() {
        return filmSessionRepository.findAll();
    }
}
