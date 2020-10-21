package ua.com.kbl.server.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.kbl.server.dao.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
