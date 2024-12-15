package ru.netology.homeworkSorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTests {
    @Test
    public void shouldSortByPrice() {
        Ticket ticket1 = new Ticket("Москва", "Варадеро", 50_000, 10, 22);
        Ticket ticket2 = new Ticket("Москва", "Пхукет", 150_000, 2, 17);
        Ticket ticket3 = new Ticket("Саратов", "Москва", 79_200, 11, 20);
        Ticket ticket4 = new Ticket("Исландия", "Турция", 13_500, 1, 13);
        Ticket ticket5 = new Ticket("Пенза", "Калифорния", 256_000, 13, 2);

        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket4, ticket1, ticket3, ticket2, ticket5};
        Ticket[] actual = tickets;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceInSearch() {
        Ticket ticket1 = new Ticket("Москва", "Варадеро", 250_000, 2, 22);
        Ticket ticket2 = new Ticket("Москва", "Варадеро", 13_000, 13, 22);
        Ticket ticket3 = new Ticket("Москва", "Варадеро", 64_340, 5, 22);
        Ticket ticket4 = new Ticket("Москва", "Варадеро", 28_000, 7, 22);
        Ticket ticket5 = new Ticket("Москва", "Варадеро", 150_000, 12, 22);

        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket2, ticket4, ticket3, ticket5, ticket1};
        Ticket[] actual = aviaSouls.search("Москва", "Варадеро");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByComparator(){
        Ticket ticket1 = new Ticket("Москва", "Варадеро", 250_000, 2, 22);
        Ticket ticket2 = new Ticket("Москва", "Варадеро", 13_000, 13, 22);
        Ticket ticket3 = new Ticket("Москва", "Варадеро", 64_340, 5, 22);
        Ticket ticket4 = new Ticket("Москва", "Варадеро", 28_000, 7, 22);
        Ticket ticket5 = new Ticket("Москва", "Варадеро", 150_000, 12, 22);

        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2, ticket5, ticket4, ticket3, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Варадеро", ticketTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
