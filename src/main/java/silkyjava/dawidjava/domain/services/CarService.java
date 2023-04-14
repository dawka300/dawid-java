package silkyjava.dawidjava.domain.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import silkyjava.dawidjava.application.ports.out.CarRepository;
import silkyjava.dawidjava.domain.model.Car;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
