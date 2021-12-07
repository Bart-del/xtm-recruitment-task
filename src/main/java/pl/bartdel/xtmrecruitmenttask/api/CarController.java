package pl.bartdel.xtmrecruitmenttask.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartdel.xtmrecruitmenttask.entity.Car;
import pl.bartdel.xtmrecruitmenttask.repository.CarRepo;

import java.util.Optional;


@RestController("/cars")
public class CarController {

    private final CarRepo repository;

    CarController(CarRepo carRepo){
        this.repository = carRepo;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Car addNewCar(@RequestBody Car newCar){
        return repository.save(newCar);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> updateCar(@RequestBody Car car, @PathVariable Long id){
        Optional<Car> carOptional = repository.findById(id);

        if(carOptional.isEmpty())
            return ResponseEntity.notFound().build();

        car.setId(id);
        repository.save(car);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteCar(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/rent/{id}")
    ResponseEntity<?> rentACar(@PathVariable Long id){
        Optional<Car> carOptional = repository.findById(id);

        if(carOptional.isEmpty())
            return ResponseEntity.notFound().build();

        if(carOptional.get().isRented())
            return ResponseEntity.badRequest().build();

        Car car = carOptional.get();
        car.setRented(true);
        repository.save(car);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/returnRentedCar/{id}")
    ResponseEntity<?> returnCar(@PathVariable Long id){
        Optional<Car> carOptional = repository.findById(id);

        if(carOptional.isEmpty())
            return ResponseEntity.notFound().build();

        if(!carOptional.get().isRented())
            return ResponseEntity.badRequest().build();

        Car car = carOptional.get();
        car.setRented(false);
        repository.save(car);
        return ResponseEntity.noContent().build();

    }
}
