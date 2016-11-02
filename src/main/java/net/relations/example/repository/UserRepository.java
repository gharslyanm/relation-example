package net.relations.example.repository;

import net.relations.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by manukg on 10/28/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
