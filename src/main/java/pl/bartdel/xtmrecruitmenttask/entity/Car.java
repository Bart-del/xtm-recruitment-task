package pl.bartdel.xtmrecruitmenttask.entity;


import lombok.*;

import javax.persistence.*;
import java.time.Year;


@Entity
@Setter
@Getter
@ToString
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String model;
    @Transient
    @Column(nullable = false)
    private Year yearOfProduction;
    @Column(nullable = false)
    private Producer producer;
    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean isRented = false;

    public Car() {
    }

    public Car(Long id, String model, Year yearOfProduction, Producer producer, boolean isRented) {
        this.id = id;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.producer = producer;
        this.isRented = isRented;
    }
}
