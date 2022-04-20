package test.idomsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.idomsoft.dto.CarRequest;
import test.idomsoft.entity.Car;
import test.idomsoft.service.car.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/getAllCars")
    public ResponseEntity<List<Car>> getAllCars() {
        try {
            return new ResponseEntity<List<Car>>(carService.getAllCars(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Car>>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/saveCar")
    public ResponseEntity<Car> saveCar(@RequestBody CarRequest carRequest) {
        try {
            return new ResponseEntity<Car>(carService.saveCar(carRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getCarById/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable Long carId) {
        try {
            return new ResponseEntity<Car>(carService.getCarById(carId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCar/{carId}")
    public ResponseEntity<String> deleteCarById(@PathVariable Long carId) {
        try {
            carService.deleteCarById(carId);
            return new ResponseEntity<String>("Car successfully deleted.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }


}
