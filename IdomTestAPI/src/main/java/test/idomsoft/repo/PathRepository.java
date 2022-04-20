package test.idomsoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.idomsoft.entity.Path;

import java.util.List;

public interface PathRepository extends JpaRepository<Path, Long> {
    @Query("SELECT p FROM Path p WHERE p.itinerary.id = :id")
    public List<Path> getAllPathsToItinerary(@Param("id") Long itineraryId);
}
