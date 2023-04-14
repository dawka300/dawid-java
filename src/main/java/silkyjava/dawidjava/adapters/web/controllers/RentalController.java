package silkyjava.dawidjava.adapters.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import silkyjava.dawidjava.domain.dto.CarDTO;
import silkyjava.dawidjava.domain.dto.RentalDTO;
import silkyjava.dawidjava.domain.dto.UserDTO;

import java.util.List;

public class RentalController {
    private final CarRentalService carRentalService;

    public RentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @PostMapping("/rentals")
    public ResponseEntity<RentalDTO> rentCar(@RequestBody RentalDTO rentalDTO) {
        RentalDTO rentedCar = carRentalService.rentCar(rentalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(rentedCar);
    }

    @GetMapping("/rentals")
    public ResponseEntity<List<RentalDTO>> getAllRentals() {
        List<RentalDTO> rentals = carRentalService.getAllRentals();
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/rentals/{id}")
    public ResponseEntity<RentalDTO> getRentalById(@PathVariable Long id) {
        RentalDTO rental = carRentalService.getRentalById(id);
        if (rental == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rental);
    }
}
