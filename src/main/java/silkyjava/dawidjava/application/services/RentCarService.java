package silkyjava.dawidjava.application.services;

import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import silkyjava.dawidjava.application.ports.in.RentCarUseCase;
import silkyjava.dawidjava.application.ports.out.CarRepository;
import silkyjava.dawidjava.application.ports.out.RentalRepository;
import silkyjava.dawidjava.application.ports.out.UserRepository;
import silkyjava.dawidjava.domain.model.Car;
import silkyjava.dawidjava.domain.model.Rental;
import silkyjava.dawidjava.domain.model.User;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RentCarService implements RentCarUseCase {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final RentalRepository rentalRepository;

    public Rental rentCar(Long userId, Long carId, LocalDate startDate, LocalDate endDate) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Car car = carRepository.findById(carId).orElseThrow(() -> new CarNotFoundException(carId));
        Rental rental = new Rental(user, car, startDate, endDate);
        rentalRepository.save(rental);
        return rental;
    }

    public Rental returnCar(Long rentalId, LocalDate returnDate) throws ChangeSetPersister.NotFoundException {

        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        markCarAsAvailable(rental.getCar(), rental.getStartDate(), returnDate);

        rental.setEndDate(returnDate);
        rentalRepository.save(rental);

        return rental;
    }

    private boolean isCarAvailable(Car car, LocalDate rentalDate, LocalDate returnDate) {
        List<Rental> rentals = rentalRepository.findOverlapRentalsByCar(car, rentalDate, returnDate);
        return rentals.isEmpty();
    }

    private void markCarAsNotAvailable(Car car, LocalDate rentalDate, LocalDate returnDate) {
        List<LocalDate> datesRange = DateUtils.getDatesRange(rentalDate, returnDate);
        datesRange.forEach(date -> car.addUnavailableDate(date));
        carRepository.save(car);
    }

    private void markCarAsAvailable(Car car, LocalDate rentalDate, LocalDate returnDate) {
    }
}
