package pl.bartdel.xtmrecruitmenttask.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.bartdel.xtmrecruitmenttask.entity.Car;
import pl.bartdel.xtmrecruitmenttask.entity.Producer;
import pl.bartdel.xtmrecruitmenttask.service.CarService;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Year;
import java.util.Optional;

@SpringBootTest
public class CarControllerTest {

    @Autowired
    private CarController carController;

    @Autowired
    private CarService carService;

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
        car.setId(14L);
        car.setModel("A30");
        car.setYearOfProduction(Year.of(2020));
        car.setProducer(Producer.VOLVO);

        carController.addNewCar(car);

        ResponseEntity<?> response = carController.deleteCar(car.getId());
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
    }

    @Test
    public void deleteCar_Failure(){
        ResponseEntity<?> response = carController.deleteCar(12312312423123151L);
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void updateCar_Success(){
        Car carOld = new Car();
        carOld.setId(50L);
        carOld.setModel("X-way");
        carOld.setYearOfProduction(Year.of(2018));
        carOld.setProducer(Producer.SKODA);
        carController.addNewCar(carOld);

        Car carNew = carService.getCar(carOld.getId()).get();
        carNew.setModel("New model");
        carNew.setProducer(Producer.BMW);

        ResponseEntity<?> response = carController.updateCar(carNew, carNew.getId());
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
    }

    @Test
    public void updateCar_Failure(){
        Car car = new Car();

        car.setId(352412L);
        car.setModel("Model");
        car.setYearOfProduction(Year.of(6415));
        car.setProducer(Producer.VOLVO);
        ResponseEntity<?> response = carController.updateCar(car, car.getId());
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void rentACar_Success(){
        Car car = new Car();
        car.setId(15L);
        car.setModel("A20");
        car.setYearOfProduction(Year.of(2013));
        car.setProducer(Producer.BMW);

        carController.addNewCar(car);
        carController.rentACar(car.getId());

        Optional<Car> carOptional = carService.getCar(car.getId());
        assertThat(carOptional.get().isRented()).isEqualTo(true);
    }

    @Test
    public void rentACar_Failure(){
        Car car = new Car();
        car.setId(123L);
        car.setModel("A20");
        car.setYearOfProduction(Year.of(2011));
        car.setProducer(Producer.BMW);

        carController.addNewCar(car);

        Optional<Car> carOptional = carService.getCar(car.getId());
        assertThat(carOptional.get().isRented()).isEqualTo(false);
    }
    @Test

    public void rentARentedCar(){
        Car car = new Car();
        car.setId(123L);
        car.setModel("A20");
        car.setYearOfProduction(Year.of(2011));
        car.setProducer(Producer.BMW);

        carController.addNewCar(car);
        carController.rentACar(car.getId());

        ResponseEntity<?> response = carController.rentACar(car.getId());
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
    }


    @Test
    public void returnRentedCar_Successful(){
        Car car = new Car();
        car.setId(15L);
        car.setModel("A20");
        car.setYearOfProduction(Year.of(2013));
        car.setProducer(Producer.BMW);

        carController.addNewCar(car);
        carController.rentACar(car.getId());
        carController.returnCar(car.getId());

        Optional<Car> carOptional = carService.getCar(car.getId());
        assertThat(carOptional.get().isRented()).isEqualTo(false);
    }

    @Test
    public void returnRentedCar_Failure(){
        Car car = new Car();
        car.setId(15L);
        car.setModel("A20");
        car.setYearOfProduction(Year.of(2013));
        car.setProducer(Producer.BMW);

        carController.addNewCar(car);
        carController.rentACar(car.getId());

        Optional<Car> carOptional = carService.getCar(car.getId());
        assertThat(carOptional.get().isRented()).isNotEqualTo(false);
    }

    @Test
    public void returnNotRentedCar(){
        Car car = new Car();
        car.setId(123L);
        car.setModel("A20");
        car.setYearOfProduction(Year.of(2011));
        car.setProducer(Producer.BMW);

        carController.addNewCar(car);

        ResponseEntity<?> response = carController.returnCar(car.getId());
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
    }
}
