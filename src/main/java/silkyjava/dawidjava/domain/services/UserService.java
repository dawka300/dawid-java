package silkyjava.dawidjava.domain.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import silkyjava.dawidjava.application.ports.out.UserRepository;
import silkyjava.dawidjava.domain.model.User;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
