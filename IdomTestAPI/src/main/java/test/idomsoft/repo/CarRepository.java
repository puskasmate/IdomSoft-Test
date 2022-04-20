package test.idomsoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import test.idomsoft.entity.Car;

public interface CarRepository extends JpaRepository <Car, Long> {
}
