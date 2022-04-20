package test.idomsoft.service.itinerary;

import org.springframework.stereotype.Service;
import test.idomsoft.dto.ItineraryRequest;
import test.idomsoft.entity.Itinerary;

import java.util.List;

@Service
public interface ItineraryService {

    public List<Itinerary> getAllItineraries();

    public Itinerary saveItinerary(ItineraryRequest itineraryRequest);

    public Itinerary getItineraryById(Long itineraryId);

    public String deleteItinerary(Long itineraryId);

    public List<Itinerary> getAllItinerariesToCar(Long itineraryId);

}
