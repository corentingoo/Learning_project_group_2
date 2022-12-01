package be.ifosup.learning.inscriptions.repositories;


import be.ifosup.learning.formations.entities.Formation;
import be.ifosup.learning.inscriptions.entities.Inscription;
import be.ifosup.learning.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    List<Inscription> findByUser(Long user);
}
