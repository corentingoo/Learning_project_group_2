package be.ifosup.learning.formations.service;

import java.util.List;

import javax.transaction.Transactional;
import be.ifosup.learning.formations.entities.Formation;
import be.ifosup.learning.formations.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FormationService {
    @Autowired
    private FormationRepository repo;

    public List<Formation> listAll() {
        return repo.findAll();
    }

    public void save(Formation product) {
        repo.save(product);
    }

    public Formation get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
