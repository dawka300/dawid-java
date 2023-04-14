package silkyjava.dawidjava.application.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;
import silkyjava.dawidjava.domain.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
