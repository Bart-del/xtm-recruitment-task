package pl.bartdel.xtmrecruitmenttask.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.bartdel.xtmrecruitmenttask.entity.Car;
import pl.bartdel.xtmrecruitmenttask.entity.Producer;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Year;

@SpringBootTest
public class CarControllerTest {

    @Autowired
    private CarController carController;

    @Test
    public void addNewCar_Success(){
        Car car = new Car();
        car.setId(1L);
        car.setModel("A17");
        car.setYearOfProduction(Year.of(2015));
        car.setProducer(Producer.BMW);
        ResponseEntity<?> response = carController.addNewCar(car);
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
    }

    @Test
    public void addNewCar_Failure(){
        Car car = new Car();
        car.setId(null);
        car.setModel(null);
        car.setYearOfProduction(null);
        car.setProducer(null);

        ResponseEntity<?> response = carController.addNewCar(car);
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void deleteCar_Success(){
        Car car = new Car();
        car.setId(1L);
        car.setModel("A17");
        car.setYearOfProduction(Year.of(2015));
        car.setProducer(Producer.BMW);

        carController.addNewCar(car);

        ResponseEntity<?> response = carController.deleteCar(car.getId());


    }


}
