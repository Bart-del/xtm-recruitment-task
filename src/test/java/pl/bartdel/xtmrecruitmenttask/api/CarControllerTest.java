package pl.bartdel.xtmrecruitmenttask.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bartdel.xtmrecruitmenttask.entity.Car;
import pl.bartdel.xtmrecruitmenttask.entity.Producer;

import java.time.Year;

@SpringBootTest
public class CarControllerTest {


    CarController carController;

    @Autowired
    CarControllerTest(CarController carController){
        this.carController = carController;
    }

    @Test
    public void addNewCar_Success(){
        Car car = new Car();
        car.setId(1L);
        car.setModel("A17");
        car.setYearOfProduction(Year.of(2015));
        car.setProducer(Producer.BMW);

        carController.addNewCar(car);

    }
}
