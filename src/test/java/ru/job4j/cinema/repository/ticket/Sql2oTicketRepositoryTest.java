package ru.job4j.cinema.repository.ticket;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.job4j.cinema.configuration.DatasourceConfiguration;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.repository.film.Sql2oFilmRepository;

import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Sql2oTicketRepositoryTest {

    private static Sql2oTicketRepository repository;

    private Sql2o sql2o;
    private Connection connection;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oFilmRepository.class.getClassLoader().getResourceAsStream("connection.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");

        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        var sql2o = configuration.databaseClient(datasource);
        Connection connection = sql2o.open();
        connection.createQuery("DELETE FROM tickets").executeUpdate();

        repository = new Sql2oTicketRepository(sql2o);

    }

    @Test
    public void successBuyTicket() {
        Ticket ticket = new Ticket(6, 1, 1, 1, 1);
        Optional<Ticket> expectedTicket = repository.buyTicket(ticket);

        assertTrue(expectedTicket.isPresent());
        assertEquals(expectedTicket.get(), ticket);
    }
}