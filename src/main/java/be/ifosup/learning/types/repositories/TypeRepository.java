package be.ifosup.learning.types.repositories;

import be.ifosup.learning.types.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
