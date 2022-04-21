package test.idomsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.idomsoft.dto.CarRequest;
import test.idomsoft.dto.ItineraryRequest;
import test.idomsoft.dto.PathRequest;
import test.idomsoft.entity.Car;
import test.idomsoft.entity.Fuel;
import test.idomsoft.entity.Itinerary;
import test.idomsoft.repo.CarRepository;
import test.idomsoft.repo.FuelRepository;
import test.idomsoft.repo.ItineraryRepository;
import test.idomsoft.repo.PathRepository;
import test.idomsoft.service.car.CarService;
import test.idomsoft.service.itinerary.ItineraryService;
import test.idomsoft.service.path.PathService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class IdomTestApiApplication implements CommandLineRunner {

	@Autowired
	FuelRepository fuelRepository;

	@Autowired
	CarRepository carRepository;

	@Autowired
	ItineraryRepository itineraryRepository;

	@Autowired
	ItineraryService itineraryService;

	@Autowired
	CarService carService;

	@Autowired
	PathService pathService;

	public static void main(String[] args) {
		SpringApplication.run(IdomTestApiApplication.class, args);
		System.out.println("Starting the application...");
	}

	@Override
	public void run(String... args) throws Exception
	{
		if (fuelRepository.findAll().size() == 0) {
			Fuel diesel = new Fuel((long)1, "Dízel", 481);
			Fuel petrol = new Fuel((long)2, "Benzin", 481);
			fuelRepository.saveAll(List.of(diesel, petrol));

			List<Fuel> fuels = fuelRepository.findAll();

			for (int i = 0; i < fuels.size(); i++) {
				CarRequest car = new CarRequest();
				if(i == 0) {
					car = new CarRequest("KFG-315", "Ford Mondeo", 4, "Fekete", 2015, (float)6.5, fuels.get(0).getId());
				} else {
					car = new CarRequest("LAJ-385", "Volkswagen Passat", 4, "Kék", 2012, (float)7.2, fuels.get(1).getId());
				}
				carService.saveCar(car);
			}

			List<Car> cars = carService.getAllCars();

			for (int i = 0; i < cars.size(); i++) {
				ItineraryRequest itineraryRequest = new ItineraryRequest();
				if (i == 0) {
					itineraryRequest = new ItineraryRequest(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("12-04-2022 08:32:12"), 123585, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("12-04-2022 08:32:12"), cars.get(i).getId());
				} else {
					itineraryRequest = new ItineraryRequest(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("15-04-2022 08:21:53"), 137543, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("15-04-2022 08:21:53"), cars.get(i).getId());
				}
				itineraryService.saveItinerary(itineraryRequest);
			}

			List<Itinerary> itineraries = itineraryService.getAllItineraries();

			for (int i = 0; i < itineraries.size(); i++) {
				PathRequest pathRequest = new PathRequest();
				PathRequest pathRequest2 = new PathRequest();
				PathRequest pathRequest3 = new PathRequest();
				if (i == 0) {
					pathRequest = new PathRequest("Nyíregyháza", "Újfehértó", 123605, 4, "Puskás Máté", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("12-04-2022 09:07:53"), itineraries.get(0).getId());
					pathRequest2 = new PathRequest("Újfehértó", "Debrecen", 123663, 4, "Puskás Máté", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("12-04-2022 09:58:45"), itineraries.get(0).getId());
					pathRequest3 = new PathRequest("Debrecen", "Nyíregyháza", 123753, 4, "Puskás Máté", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("12-04-2022 11:07:25"), itineraries.get(0).getId());
				} else {
					pathRequest = new PathRequest("Nyíregyháza", "Nagykálló", 137602, 4, "Puskás László", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("15-04-2022 08:42:23"), itineraries.get(1).getId());
					pathRequest2 = new PathRequest("Nagykálló", "Érpatak", 137622, 4, "Puskás László", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("15-04-2022 09:04:11"), itineraries.get(1).getId());
					pathRequest3 = new PathRequest("Érpatak", "Nyíregyháza", 137646, 4, "Puskás László", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("15-04-2022 09:42:23"), itineraries.get(1).getId());

				}
				pathService.savePath(pathRequest);
				pathService.savePath(pathRequest2);
				pathService.savePath(pathRequest3);
			}

		}
	}
}
