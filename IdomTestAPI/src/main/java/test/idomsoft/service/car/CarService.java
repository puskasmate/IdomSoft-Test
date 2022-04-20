package test.idomsoft.service.car;

import org.springframework.stereotype.Service;
import test.idomsoft.dto.CarRequest;
import test.idomsoft.entity.Car;

import java.util.List;

@Service
public interface CarService {

    public List<Car> getAllCars();

    public Car saveCar(CarRequest carRequest);

    public Car getCarById(Long id);

    public String deleteCarById(Long id);

}
