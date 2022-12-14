package be.ifosup.learning.inscriptions.repositories;


import be.ifosup.learning.inscriptions.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    @Query("select i from Inscription i where i.student_id = ?1 and i.formation_id = ?2")
    Inscription findByStudent_idAndFormation_id(Long student_id, Long formation_id);
    @Query("select i from Inscription i where i.student_id = ?1")
    List<Inscription> findAllByStudentId(Long studentId);


}
