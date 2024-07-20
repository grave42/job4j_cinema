package ru.job4j.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.service.filmsession.FilmSessionService;
import ru.job4j.cinema.service.ticket.TicketService;

import java.util.Optional;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    private final FilmSessionService filmSessionService;

    private final TicketService ticketService;

    public TicketController(FilmSessionService filmSessionService, TicketService ticketService) {
        this.filmSessionService = filmSessionService;
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        var filmSessionOptional = filmSessionService.findById(id);
        if (filmSessionOptional.isEmpty()) {
            model.addAttribute("message", "Сеанс с указанным идентификатором не найден");
            return "errors/404";
        }
        model.addAttribute("filmSession", filmSessionOptional.get());
        return "tickets/one";
    }

    @PostMapping("/buyTicket")
    public String buyTicket(@ModelAttribute Ticket ticket, Model model) {
        Optional<Ticket> savedTicketOptional = ticketService.buyTicket(ticket);
        if (savedTicketOptional.isPresent()) {
            model.addAttribute("rowNumber", ticket.getRowNumber());
            model.addAttribute("placeNumber", ticket.getPlaceNumber());
            return "tickets/successbuy";
        }
        model.addAttribute("message", "Не удалось приобрести билет на заданное место. " +
                "Вероятно оно уже занято. Перейдите на страницу бронирования билетов и попробуйте снова.");
        return "errors/404";
    }
}
