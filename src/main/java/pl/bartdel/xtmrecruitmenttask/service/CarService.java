package pl.bartdel.xtmrecruitmenttask.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.bartdel.xtmrecruitmenttask.entity.Car;
import pl.bartdel.xtmrecruitmenttask.repository.CarRepo;

import java.util.Optional;


@Service
public class CarService {

    CarRepo carRepo;

    CarService(CarRepo carRepo){
        this.carRepo = carRepo;
    }

    public ResponseEntity<?> addNewCar(@RequestBody Car newCar){
        try {
            carRepo.save(newCar);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    public void deleteCar(Long id){
        carRepo.deleteById(id);
    }

    public ResponseEntity<?> updateCar(Long id, Car car){
        Optional<Car> carOptional = carRepo.findById(id);

        if(carOptional.isEmpty())
            return ResponseEntity.notFound().build();

        car.setId(id);
        carRepo.save(car);
        return ResponseEntity.noContent().build();
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
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<?> returnCar(@PathVariable Long id){
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
}
