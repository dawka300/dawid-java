package silkyjava.dawidjava.domain.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import silkyjava.dawidjava.application.ports.out.RentalRepository;
import silkyjava.dawidjava.domain.model.Rental;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;

    public Rental save(Rental rental) {
        return rentalRepository.save(rental);
    }

    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> findById(Long id) {
        return rentalRepository.findById(id);
    }

    public void deleteById(Long id) {
        rentalRepository.deleteById(id);
    }
}
