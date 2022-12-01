package be.ifosup.learning.formations.repositories;

import be.ifosup.learning.formations.entities.Formation;
import be.ifosup.learning.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
    List<Formation> findByTeacher(Long teacher);




}
