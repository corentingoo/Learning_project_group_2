package be.ifosup.learning.formations.service;

import be.ifosup.learning.formations.in.FormationIdIn;
import be.ifosup.learning.formations.in.FormationIn;
import be.ifosup.learning.formations.out.FormationOut;

import java.util.List;

public interface FormationService {
    List<FormationOut> listAll();

    FormationOut save(FormationIn formationIn);

    FormationOut update(Long id, FormationIdIn formationIdIn);

    FormationOut get(Long id) ;

    void delete(Long id);

    List<FormationOut> listbyTeacher(Long id);

}
