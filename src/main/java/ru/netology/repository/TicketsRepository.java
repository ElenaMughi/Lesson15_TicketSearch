package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.TicketsInfo;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketsRepository {

    private TicketsInfo[] tickets = new TicketsInfo[0];

    public void saveTicket(TicketsInfo ticket) {
        int length = tickets.length + 1;
        TicketsInfo[] tmp = new TicketsInfo[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public void removeTicket(TicketsInfo ticket) {
        int length = tickets.length - 1;
        TicketsInfo[] tmp = new TicketsInfo[length];
        int index = 0;
        for (TicketsInfo item : tickets) {
            if (item.getId() != ticket.getId()) {
                tmp[index] = item;
                index++;
            }
        }
        tickets = tmp;
    }
}
