package test.idomsoft.service.path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.idomsoft.dto.PathRequest;
import test.idomsoft.entity.Itinerary;
import test.idomsoft.entity.Path;
import test.idomsoft.repo.FuelRepository;
import test.idomsoft.repo.ItineraryRepository;
import test.idomsoft.repo.PathRepository;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service("pathService")
public class PathServiceImpl implements PathService{

    @Autowired
    private PathRepository pathRepository;

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private FuelRepository fuelRepository;

    @Override
    public List<Path> getAllPaths() {
        return pathRepository.findAll();
    }

    @Override
    public Path savePath(PathRequest pathRequest) {
        Itinerary itinerary = itineraryRepository.findById(pathRequest.getItinerary_id()).orElse(null);
        Path path = new Path();
        path.setFromWhere(pathRequest.getFromWhere());
        path.setToWhere(pathRequest.getToWhere());
        path.setKilometreStance(pathRequest.getKilometreStance());
        path.setNumberOfTransportedPassengers(pathRequest.getNumberOfTransportedPassengers());
        path.setDriverName(pathRequest.getDriverName());
        path.setEndDate(pathRequest.getEndDate());
        path.setItinerary(itinerary);
        pathRepository.save(path);

        //Change the itinerary.
        itinerary = getUpdatedItineraryWhenPathSaved(itinerary);
        itineraryRepository.save(itinerary);
        return path;
    }

    @Override
    public Path getPathById(Long pathId) {
        return pathRepository.findById(pathId).get();
    }

    @Override
    public String deletePathById(Long pathId) {
        Path path = pathRepository.findById(pathId).get();
        Itinerary itinerary = itineraryRepository.findById(path.getItinerary().getId()).get();
        itineraryRepository.save(itinerary);
        pathRepository.deleteById(pathId);
        itinerary = getUpdatedItineraryWhenPathDeleted(itinerary);
        itineraryRepository.save(itinerary);
        return "Path successfully deleted.";
    }

    @Override
    public List<Path> getAllPathsToItinerary(Long itineraryId) {
        return pathRepository.getAllPathsToItinerary(itineraryId);
    }

    public long getDiffBetweenDates(Date date1, Date date2) {
        long diffInMillis = Math.abs(date2.getTime() - date1.getTime());
        return TimeUnit.MINUTES.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    public int getMaxStance(Itinerary itinerary) {
        List<Path> paths = itinerary.getPaths();
        List<Integer> kilometreStances = new ArrayList<>();
        for(Path path : paths) {
            kilometreStances.add(path.getKilometreStance());
        }

        return kilometreStances.stream().max(Comparator.naturalOrder()).get();
    }

    public Date getMaxEndDateToItinerary(Itinerary itinerary) {
        List<Date> endDates = new ArrayList<>();
        for (Path path : itinerary.getPaths()) {
            endDates.add(path.getEndDate());
        }
        return endDates.stream().max(Comparator.naturalOrder()).get();
    }

    public int getNumberOfPassengersToItinerary(Itinerary itinerary) {
        int numberOfPassengers = 0;
        for (Path p : itinerary.getPaths()) {
            numberOfPassengers+= p.getNumberOfTransportedPassengers();
        }

        return numberOfPassengers;
    }

    public Itinerary getUpdatedItineraryWhenPathSaved(Itinerary itinerary) {
        if (itinerary.getPaths().size() != 0) {
            itinerary.setDistance(getMaxStance(itinerary) - itinerary.getStartStance());
            itinerary.setEndDate(getMaxEndDateToItinerary(itinerary));
            itinerary.setSumOfPassengers(getNumberOfPassengersToItinerary(itinerary));
        } else {
            itinerary.setDistance(0);
            itinerary.setEndDate(itinerary.getEndDate());
            itinerary.setSumOfPassengers(0);
        }

        itinerary.setDuration(getDiffBetweenDates(itinerary.getStartDate(), itinerary.getEndDate()));
        int fuelPrice = 0;
        fuelPrice = itinerary.getCar().getFuel().getPrice();
        itinerary.setPrice(((((float)itinerary.getDistance()/100)*itinerary.getCar().getConsumption())*(float)fuelPrice) + ((float)itinerary.getDistance()*(float)15));
        return itinerary;
    }

    public Itinerary getUpdatedItineraryWhenPathDeleted(Itinerary itinerary) {
        if (itinerary.getPaths().size() != 0) {
            itinerary.setDistance(getMaxStance(itinerary) - itinerary.getStartStance());
            itinerary.setEndDate(getMaxEndDateToItinerary(itinerary));
            itinerary.setDuration(getDiffBetweenDates(itinerary.getStartDate(), itinerary.getEndDate()));
            itinerary.setSumOfPassengers(getNumberOfPassengersToItinerary(itinerary));
        } else {
            itinerary.setDistance(0);
            itinerary.setEndDate(itinerary.getStartDate());
            itinerary.setDuration(Long.valueOf(0));
            itinerary.setSumOfPassengers(0);
        }

        int fuelPrice = 0;
        fuelPrice = itinerary.getCar().getFuel().getPrice();
        itinerary.setPrice(((((float)itinerary.getDistance()/100)*itinerary.getCar().getConsumption())*(float)fuelPrice) + ((float)itinerary.getDistance()*(float)15));

        return itinerary;
    }

}
