package silkyjava.dawidjava.application.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;
import silkyjava.dawidjava.domain.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
