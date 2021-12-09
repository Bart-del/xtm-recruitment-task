package pl.bartdel.xtmrecruitmenttask.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartdel.xtmrecruitmenttask.entity.Car;
import pl.bartdel.xtmrecruitmenttask.service.CarService;


@RestController("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService= carService;
    }

    @PostMapping
    ResponseEntity<?> addNewCar(@RequestBody Car newCar){
      return carService.addNewCar(newCar);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateCar(@RequestBody Car car, @PathVariable Long id){
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCar(@PathVariable Long id){
        return carService.deleteCar(id);
    }

    @PutMapping("/rent/{id}")
    ResponseEntity<?> rentACar(@PathVariable Long id){
        return carService.rentACar(id);
    }

    @PutMapping("/return_rented_car/{id}")
    ResponseEntity<?> returnCar(@PathVariable Long id){
        return carService.returnRentedCar(id);

    }
}
