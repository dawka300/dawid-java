package silkyjava.dawidjava.application.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;
import silkyjava.dawidjava.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
