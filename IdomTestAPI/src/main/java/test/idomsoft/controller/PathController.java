package test.idomsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.idomsoft.dto.PathRequest;
import test.idomsoft.entity.Path;
import test.idomsoft.service.path.PathService;

import java.util.List;

@RestController
@RequestMapping("/api/paths")
@CrossOrigin(origins = "http://localhost:4200")
public class PathController {

    @Autowired
    private PathService pathService;

    @GetMapping("/getAllPaths")
    public ResponseEntity<List<Path>> getAllPaths() {
        try {
            return new ResponseEntity<List<Path>>(pathService.getAllPaths(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Path>>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/savePath")
    public ResponseEntity<Path> savePath(@RequestBody PathRequest pathRequest) {
        try {
            return new ResponseEntity<Path>(pathService.savePath(pathRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Path>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getPathById/{pathId}")
    public ResponseEntity<Path> getPathById(@PathVariable Long pathId) {
        try {
            return new ResponseEntity<Path>(pathService.getPathById(pathId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Path>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletePathById/{pathId}")
    public ResponseEntity<String> deletePathById(@PathVariable Long pathId) {
        try {
            return new ResponseEntity<String>(pathService.deletePathById(pathId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllPathsToItinerary/{itineraryId}")
    public ResponseEntity<List<Path>> getAllPathsToItinerary(@PathVariable Long itineraryId) {
        try {
            return new ResponseEntity<List<Path>>(pathService.getAllPathsToItinerary(itineraryId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Path>>(HttpStatus.BAD_REQUEST);
        }
    }


}
