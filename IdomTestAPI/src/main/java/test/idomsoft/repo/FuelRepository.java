package test.idomsoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.idomsoft.entity.Fuel;

import java.util.List;

public interface FuelRepository extends JpaRepository<Fuel, Long> {
}
