package silkyjava.dawidjava.application.ports.in;

import silkyjava.dawidjava.domain.model.Rental;

public interface ReturnCarUseCase {
    Rental returnCar(Long rentalId);
}
