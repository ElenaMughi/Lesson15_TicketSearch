package ru.netology.manager;

import ru.netology.domain.TicketsInfo;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;

public class Manager {

    private TicketsRepository repo = new TicketsRepository();

    public void addTicket(TicketsInfo ticket) {
        repo.saveTicket(ticket);
    }

    public void deleteTicket(TicketsInfo ticket) {
        repo.removeTicket(ticket);
    }

    public TicketsInfo[] findAll(String from, String to) {
        TicketsRepository setFindAll = new TicketsRepository();
        for (TicketsInfo ii : repo.getTickets())
            if ((ii.getPointFrom() == from) & (ii.getPointTo() == to)) {
                setFindAll.saveTicket(ii);
            }
        TicketsInfo[] out = setFindAll.getTickets();
        Arrays.sort(out);
        return out;
    }

}
