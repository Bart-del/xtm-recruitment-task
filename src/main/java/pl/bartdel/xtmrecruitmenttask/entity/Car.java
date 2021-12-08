package pl.bartdel.xtmrecruitmenttask.entity;


import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
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
    @Column(nullable = false)
    private String model;
    @Transient
    @Column(nullable = false)
    private Year yearOfProduction;
    @Column(nullable = false)
    private Producer producer;
    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean isRented = false;
}
