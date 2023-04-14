package silkyjava.dawidjava.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {
    private Long id;
    private CarDTO car;
    private UserDTO user;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private double totalPrice;
}
