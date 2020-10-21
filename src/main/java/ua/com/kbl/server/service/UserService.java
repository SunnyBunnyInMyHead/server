package ua.com.kbl.server.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.kbl.server.dao.entity.User;
import ua.com.kbl.server.dao.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository ;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository ;
    }

    @Transactional
    public User createUser(final String name, final int age) {
        final User user = new User();
        user.setName(name);
        user.setAge(age);
        return this.userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers(final int count) {
        return this.userRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<User> getUser(final int id) {
        return this.userRepository.findById(id);
    }
}
