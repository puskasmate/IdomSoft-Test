package test.idomsoft.service.path;

import org.springframework.stereotype.Service;
import test.idomsoft.dto.PathRequest;
import test.idomsoft.entity.Path;

import java.util.List;

@Service
public interface PathService {

    public List<Path> getAllPaths();

    public Path savePath(PathRequest pathRequest);

    public Path getPathById(Long pathId);

    public String deletePathById(Long pathId);

    public List<Path> getAllPathsToItinerary(Long itineraryId);
}
