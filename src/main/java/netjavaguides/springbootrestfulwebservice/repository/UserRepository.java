package netjavaguides.springbootrestfulwebservice.repository;

import netjavaguides.springbootrestfulwebservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
