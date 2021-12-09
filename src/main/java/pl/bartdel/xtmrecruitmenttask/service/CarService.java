package pl.bartdel.xtmrecruitmenttask.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.bartdel.xtmrecruitmenttask.entity.Car;
import pl.bartdel.xtmrecruitmenttask.repository.CarRepo;

import java.util.Optional;


@Service
public class CarService {

    CarRepo carRepo;

    CarService(CarRepo carRepo){
        this.carRepo = carRepo;
    }

    public ResponseEntity<?> addNewCar(Car newCar){
        try {
            carRepo.save(newCar);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<?> deleteCar(Long id){
        try {
            carRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> updateCar(Long id, Car car){
        Optional<Car> carOptional = carRepo.findById(id);

        if(carOptional.isEmpty())
            return ResponseEntity.notFound().build();

        car.setId(id);
        carRepo.save(car);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> rentACar(Long id){
        Optional<Car> carOptional = carRepo.findById(id);

        if(carOptional.isEmpty())
            return ResponseEntity.notFound().build();

        if(carOptional.get().isRented())
            return ResponseEntity.badRequest().build();

        Car car = carOptional.get();
        car.setRented(true);
        carRepo.save(car);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> returnRentedCar(Long id){
        Optional<Car> carOptional = carRepo.findById(id);

        if(carOptional.isEmpty())
            return ResponseEntity.notFound().build();

        if(!carOptional.get().isRented())
            return ResponseEntity.badRequest().build();

        Car car = carOptional.get();
        car.setRented(false);
        carRepo.save(car);
        return ResponseEntity.noContent().build();

    }

    //Method added for testing purposes only. It was not defined in the requirements of the task.
    public Optional<Car> getCar(Long id){
        return carRepo.findById(id);
    }
}
