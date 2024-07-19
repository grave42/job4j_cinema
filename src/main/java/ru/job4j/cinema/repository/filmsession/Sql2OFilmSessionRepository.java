package ru.job4j.cinema.repository.filmsession;

import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.cinema.model.FilmSession;

import java.util.Collection;
import java.util.Optional;

@Repository
public class Sql2OFilmSessionRepository implements FilmSessionRepository {

    private final Sql2o sql2o;

    public Sql2OFilmSessionRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<FilmSession> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT f.id, f.name as film_id, g.name as genre_id, h.name as halls_id  , fs.start_time, fs.end_time, fs.price, h.row_count, h.place_count\n"
                    + "FROM film_sessions fs\n"
                    + "JOIN films f ON fs.film_id = f.id\n"
                    + "join halls h on fs.halls_id = h.id\n"
                    + "join genres g on f.genre_id = g.id\n"
                    + "WHERE f.id = :id;");
            query.addParameter("id", id);
            var filmSession = query.setColumnMappings(FilmSession.COLUMN_MAPPING).executeAndFetchFirst(FilmSession.class);
            return Optional.ofNullable(filmSession);
        }
    }

    @Override
    public Collection<FilmSession> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT f.id, f.name as film_id, g.name as genre_id, h.name as halls_id  , fs.start_time, fs.end_time, fs.price\n"
                    + "FROM film_sessions fs\n"
                    + "JOIN films f ON fs.film_id = f.id\n"
                    + "join halls h on fs.halls_id = h.id\n"
                    + "join genres g on f.genre_id = g.id;");
            return query.setColumnMappings(FilmSession.COLUMN_MAPPING).executeAndFetch(FilmSession.class);
        }
    }
}
