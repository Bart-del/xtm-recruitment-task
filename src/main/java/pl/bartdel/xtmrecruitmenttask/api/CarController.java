package pl.bartdel.xtmrecruitmenttask.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping
    ResponseEntity<?> get(Long id){
        return carService.getCarById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> addNewCar(@RequestBody Car newCar){
      return carService.addNewCar(newCar);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> updateCar(@RequestBody Car car, @PathVariable Long id){
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> deleteCar(@PathVariable Long id){
        return carService.deleteCar(id);
    }

    @PutMapping("/rent/{id}")
    ResponseEntity<?> rentACar(@PathVariable Long id){
        return carService.rentACar(id);
    }

    @PutMapping("/returnRentedCar/{id}")
    ResponseEntity<?> returnCar(@PathVariable Long id){
        return carService.returnCar(id);

    }
}
