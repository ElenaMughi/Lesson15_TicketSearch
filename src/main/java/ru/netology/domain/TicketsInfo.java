package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketsInfo implements Comparator<TicketsInfo> {

    private int id;
    private int price;
    private String pointFrom;
    private String pointTo;
    private int travelTime; // время в минутах

    @Override
    public int compare(TicketsInfo o1, TicketsInfo o2) {
        return o1.getTravelTime() - o2.getTravelTime();
//        return o1.price - o2.price;
    };


//    Comparable<TicketsInfo>
//    @Override   //сортировка по прайсу
//    public int compareTo(TicketsInfo t) {
//        return this.price - t.price;
//    }

}
