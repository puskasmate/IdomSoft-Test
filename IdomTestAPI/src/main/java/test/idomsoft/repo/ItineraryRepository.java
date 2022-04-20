package test.idomsoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.idomsoft.entity.Itinerary;

import java.util.List;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
    @Query("SELECT i FROM Itinerary i WHERE i.car.id = :id")
    public List<Itinerary> getAllItinerariesToCar(@Param("id") Long carId);
}
