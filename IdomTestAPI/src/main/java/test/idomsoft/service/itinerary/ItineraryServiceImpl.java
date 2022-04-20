package test.idomsoft.service.itinerary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.idomsoft.dto.ItineraryRequest;
import test.idomsoft.entity.Car;
import test.idomsoft.entity.Itinerary;
import test.idomsoft.repo.CarRepository;
import test.idomsoft.repo.FuelRepository;
import test.idomsoft.repo.ItineraryRepository;
import test.idomsoft.service.path.PathService;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service("itineraryService")
public class ItineraryServiceImpl implements ItineraryService {

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PathService pathService;

    @Autowired
    private FuelRepository fuelRepository;

    @Override
    public List<Itinerary> getAllItineraries() {
        return itineraryRepository.findAll();
    }

    @Override
    public Itinerary saveItinerary(ItineraryRequest itineraryRequest) {
        Car car = carRepository.findById(itineraryRequest.getCar_id()).orElse(null);
        Itinerary itinerary = new Itinerary();
        itinerary.setStartDate(itineraryRequest.getStartDate());
        itinerary.setDistance(0);
        itinerary.setEndDate(itineraryRequest.getStartDate());
        itinerary.setSumOfPassengers(0);
        itinerary.setDuration(getDiffBetweenDates(itinerary.getStartDate(), itinerary.getEndDate()));
        itinerary.setPrice(0);
        itinerary.setStartStance(itineraryRequest.getStartStance());
        itinerary.setCar(car);

        return itineraryRepository.save(itinerary);
    }

    @Override
    public Itinerary getItineraryById(Long itineraryId) {
        return itineraryRepository.findById(itineraryId).get();
    }

    @Override
    public String deleteItinerary(Long itineraryId) {
        itineraryRepository.deleteById(itineraryId);
        return "Itinerary successfully deleted.";
    }

    @Override
    public List<Itinerary> getAllItinerariesToCar(Long carId) {
        return itineraryRepository.getAllItinerariesToCar(carId);
    }

    public long getDiffBetweenDates(Date date1, Date date2) {
        long diffInMillis = Math.abs(date2.getTime() - date1.getTime());
        return TimeUnit.MINUTES.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }


}
