package ru.job4j.cinema.service.ticket;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.repository.ticket.TicketRepository;

import java.util.Optional;

@Service
public class SimpleTicketService implements TicketService {

    private final TicketRepository ticketRepository;

    public SimpleTicketService(TicketRepository sql2oTicketRepository) {
        this.ticketRepository = sql2oTicketRepository;
    }

    @Override
    public Optional<Ticket> buyTicket(Ticket ticket) {
        return ticketRepository.buyTicket(ticket);
    }
}
