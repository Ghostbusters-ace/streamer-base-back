package fr.aelion.streamer.repositories;

import fr.aelion.streamer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
