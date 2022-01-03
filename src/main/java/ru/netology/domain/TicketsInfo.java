package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketsInfo implements Comparable<TicketsInfo> {
    private int id;
    private int price;
    private String pointFrom;
    private String pointTo;
    private String travelTime;


    @Override   //сортировка по прайсу
    public int compareTo(TicketsInfo t) {
        return this.price - t.price;
//        return  this.id - t.id;
    }

}
