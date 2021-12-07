package pl.bartdel.xtmrecruitmenttask.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.Year;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String model;
    @Transient
    private Year yearOfProduction;
    private Producer producer;
    private boolean isRented = false;
}
