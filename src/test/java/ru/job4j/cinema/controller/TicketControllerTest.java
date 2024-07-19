package ru.job4j.cinema.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.service.filmsession.FilmSessionService;
import ru.job4j.cinema.service.ticket.TicketService;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TicketControllerTest {

    private TicketService ticketService;

    private FilmSessionService filmSessionService;

    private TicketController ticketController;

    @BeforeEach
    public void setUp() {
        ticketService = mock(TicketService.class);
        filmSessionService = mock(FilmSessionService.class);
        ticketController = new TicketController(filmSessionService, ticketService);
    }

    @Test
    public void buyTicketSuccess() {
        Ticket ticket = new Ticket(1, 1, 1, 1, 1);
        when(ticketService.buyTicket(ticket)).thenReturn(Optional.of(ticket));

        var model = new ConcurrentModel();
        var view = ticketController.buyTicket(ticket, model);
        assertThat(view).isEqualTo("tickets/successbuy");
    }

}