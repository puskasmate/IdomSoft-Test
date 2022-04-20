package test.idomsoft.service.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.idomsoft.dto.CarRequest;
import test.idomsoft.entity.Car;
import test.idomsoft.entity.Fuel;
import test.idomsoft.repo.CarRepository;
import test.idomsoft.repo.FuelRepository;

import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private FuelRepository fuelRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car saveCar(CarRequest carRequest) {
        Car car = new Car();
        Fuel fuel = new Fuel();
        fuel = fuelRepository.findById(carRequest.getFuel_id()).get();
        car.setColour(carRequest.getColour());
        car.setConsumption(carRequest.getConsumption());
        car.setModel(carRequest.getModel());
        car.setFuel(fuel);
        car.setLicensePlateNumber(carRequest.getLicensePlateNumber());
        car.setYear(carRequest.getYear());
        car.setNumberOfPassengers(carRequest.getNumberOfPassengers());
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteCarById(Long id) {
        carRepository.deleteById(id);
        return "Car successfully deleted.";
    }

}
