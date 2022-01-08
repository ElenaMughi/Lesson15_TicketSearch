package ru.netology.manager;

import ru.netology.domain.TicketsInfo;
import ru.netology.repository.TicketsRepository;

import org.junit.jupiter.api.Test;
//import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private TicketsInfo one = new TicketsInfo(1, 4_000, "DME", "LED", 155);
    private TicketsInfo two = new TicketsInfo(2, 5_000, "DME", "LED", 175);
    private TicketsInfo three = new TicketsInfo(3, 2_000, "DME", "LED", 195);
    private TicketsInfo four = new TicketsInfo(4, 2_000, "LED", "KUF", 70);
    private TicketsInfo five = new TicketsInfo(5, 8_000, "DME", "KUF", 175);
    private TicketsInfo six = new TicketsInfo(6, 5_000, "LED", "DME", 245);
    private TicketsInfo seven = new TicketsInfo(7, 3_005, "DME", "LED", 205);
    private TicketsInfo eight = new TicketsInfo(8, 1_900, "DME", "LED", 190);
    private TicketsInfo nine = new TicketsInfo(9, 10_500, "DME", "LED", 70);

    @Test
    public void shouldSortByPrice() {
        TicketsInfo[] expected = new TicketsInfo[]{nine, one, two, eight, three, seven};
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

        TicketsInfo[] actual =
                repo.findAll("DME", "LED", new TicketsInfo());

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

        TicketsInfo[] actual =
                repo.findAll("LED", "KUF", new TicketsInfo());

        assertArrayEquals(expected, actual);
    }
}