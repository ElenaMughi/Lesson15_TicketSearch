package ru.netology.manager;

import ru.netology.domain.TicketsInfo;
import ru.netology.repository.TicketsRepository;

import org.junit.jupiter.api.Test;
//import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private TicketsInfo one = new TicketsInfo(1, 4_000, "DME", "LED", "3.55");
    private TicketsInfo two = new TicketsInfo(2, 5_000, "DME", "LED", "2.55");
    private TicketsInfo three = new TicketsInfo(3, 2_000, "DME", "LED", "3.15");
    private TicketsInfo four = new TicketsInfo(4, 2_000, "LED", "KUF", "4.35");
    private TicketsInfo five = new TicketsInfo(5, 8_000, "DME", "KUF", "2.55");
    private TicketsInfo six = new TicketsInfo(6, 5_000, "LED", "DME", "3.55");
    private TicketsInfo seven = new TicketsInfo(7, 3_005, "DME", "LED", "3.25");
    private TicketsInfo eight = new TicketsInfo(8, 1_900, "DME", "LED", "3.10");
    private TicketsInfo nine = new TicketsInfo(9, 10_500, "DME", "LED", "1.10");
    @Test
    public void shouldSortByPrice() {
        TicketsInfo[] expected = new TicketsInfo[]{eight, three, seven, one, two, nine};
        Manager repo = new Manager();
        repo.addTicket(one);
        repo.addTicket(two);
        repo.addTicket(three);
        repo.addTicket(four);
        repo.addTicket(five);
        repo.addTicket(six);
        repo.addTicket(seven);
        repo.addTicket(eight);
        repo.addTicket(nine);
//        repo.deleteTicket(six);

        TicketsInfo[] actual = repo.findAll("DME", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNothing() {
        TicketsInfo[] expected = new TicketsInfo[]{};
        Manager repo = new Manager();
        repo.addTicket(one);
        repo.addTicket(two);
        repo.addTicket(five);
        repo.addTicket(six);
        repo.addTicket(seven);
        repo.addTicket(eight);
        repo.addTicket(nine);
//        repo.deleteTicket(six);

        TicketsInfo[] actual = repo.findAll("GOJ", "LED");

        assertArrayEquals(expected, actual);
    }
}