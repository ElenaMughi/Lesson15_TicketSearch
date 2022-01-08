package ru.netology.manager;

import ru.netology.domain.TicketsInfo;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Manager {

    private TicketsRepository repo = new TicketsRepository();

    public void addTicket(TicketsInfo ticket) {
        repo.saveTicket(ticket);
    }

    public void deleteTicket(TicketsInfo ticket) {
        repo.removeTicket(ticket);
    }

    public TicketsInfo[] findAll(String from, String to, Comparator<TicketsInfo> comparator) {
        TicketsRepository setFindAll = new TicketsRepository();
        for (TicketsInfo ticket : repo.getTickets()) {
            if (ticket.getPointFrom().equals(from) && ticket.getPointTo().equals(to)) {
                setFindAll.saveTicket(ticket);
            }

        };
        TicketsInfo[] out = setFindAll.getTickets();
        Arrays.sort(out, comparator);

        return out;
    }

}
