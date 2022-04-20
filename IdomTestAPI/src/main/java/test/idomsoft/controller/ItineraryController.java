package test.idomsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.idomsoft.dto.ItineraryRequest;
import test.idomsoft.entity.Itinerary;
import test.idomsoft.service.itinerary.ItineraryService;

import java.util.List;

@RestController
@RequestMapping("/api/itineraries")
@CrossOrigin(origins = "http://localhost:4200")
public class ItineraryController {

    @Autowired
    private ItineraryService itineraryService;

    @GetMapping("/getAllItineraries")
    public ResponseEntity<List<Itinerary>> getAllItineraries() {
        try {
            return new ResponseEntity<List<Itinerary>>(itineraryService.getAllItineraries(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Itinerary>>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/saveItinerary")
    public ResponseEntity<Itinerary> saveItinerary(@RequestBody ItineraryRequest itineraryRequest) {
        try {
            return new ResponseEntity<Itinerary>(itineraryService.saveItinerary(itineraryRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Itinerary>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getItineraryById/{itineraryId}")
    public ResponseEntity<Itinerary> getItineraryById(@PathVariable Long itineraryId) {
        try {
            return new ResponseEntity<Itinerary>(itineraryService.getItineraryById(itineraryId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Itinerary>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteItinerary/{itineraryId}")
    public ResponseEntity<String> deleteItineraryById(@PathVariable Long itineraryId) {
        try {
            itineraryService.deleteItinerary(itineraryId);
            return new ResponseEntity<String>("Itinerary successfully deleted.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllItinerariesToCar/{carId}")
    public ResponseEntity<List<Itinerary>> getAllItinerariesToCar(@PathVariable Long carId) {
        try {
            return new ResponseEntity<List<Itinerary>>(itineraryService.getAllItinerariesToCar(carId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Itinerary>>(HttpStatus.BAD_REQUEST);
        }
    }

}
