package silkyjava.dawidjava.application.ports.in;

import silkyjava.dawidjava.domain.model.Rental;

import java.time.LocalDate;

public interface RentCarUseCase {
    Rental rentCar(Long userId, Long carId, LocalDate startDate, LocalDate endDate);
}
