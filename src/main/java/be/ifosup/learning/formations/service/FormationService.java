package be.ifosup.learning.formations.service;

import be.ifosup.learning.formations.entities.Formation;
import be.ifosup.learning.formations.in.CreateFormationIn;
import be.ifosup.learning.formations.out.FormationOut;

import java.util.List;

public interface FormationService {
    List<FormationOut> listAll();

    FormationOut save(CreateFormationIn formationIn);

    FormationOut update(Long id, CreateFormationIn formationIn);

    FormationOut get(Long id) ;

    void delete(Long id);
}
