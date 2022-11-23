package be.ifosup.learning.formations.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import be.ifosup.learning.formations.entities.Formation;
import be.ifosup.learning.formations.in.FormationIn;
import be.ifosup.learning.formations.out.FormationOut;
import be.ifosup.learning.formations.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FormationServiceImpl implements FormationService {
    @Autowired
    private FormationRepository formationRepository;

    public List<FormationOut> listAll() {
        List<Formation> formationRepositoryAll = formationRepository.findAll();

        List<FormationOut> formationOuts = formationRepositoryAll
                .stream()
                .map(formation -> getFormationOut(formation))
                .collect(Collectors.toList());

        //2eme méthode pour lister toutes les formations avec une méthode de boucle

        List<FormationOut> formationOuts1 = new ArrayList<>();
        for (Formation formation :formationRepositoryAll) {
            formationOuts1.add(getFormationOut(formation));
        }


        return formationOuts;
    }

    public FormationOut save(FormationIn formationIn) {

        Formation formation = Formation.builder()
                        .titre(formationIn
                        .getTitre())
                        .num_eleve(formationIn.getNum_eleve())
                        .date_debut(formationIn.getDate_debut())
                        .date_fin(formationIn.getDate_fin())
                        .build();
        Formation save = formationRepository.save(formation);
        return getFormationOut(save);
    }

    @Override
    public FormationOut update(Long id, FormationIn formationIn) {
        Formation formation = formationRepository.findById(id).get();

        Formation toSave = Formation.builder()
                .formation_id(formation.getFormation_id())
                .num_eleve(formationIn.getNum_eleve() == null ? formation.getNum_eleve() : formationIn.getNum_eleve())
                .titre(formationIn.getTitre() == null ? formation.getTitre() : formationIn.getTitre())
                .date_debut(formationIn.getDate_debut() == null ? formation.getDate_debut() : formationIn.getDate_debut())
                .date_fin(formationIn.getDate_fin() == null ? formation.getDate_fin() : formationIn.getDate_fin())
                .build();

        Formation saved = formationRepository.save(toSave);
        return getFormationOut(saved);
    }

    public FormationOut get(Long id) {
        Formation formation = formationRepository.findById(id).get();
        FormationOut formationOut = getFormationOut(formation);
        return formationOut;
    }

    private static FormationOut getFormationOut(Formation formation) {
        return FormationOut.builder()
                .formation_id(formation.getFormation_id())
                .num_eleve(formation.getNum_eleve())
                .titre(formation.getTitre())
                .date_debut(formation.getDate_debut())
                .date_fin(formation.getDate_fin())
                .build();

    }

    public void delete(Long id) {
        formationRepository.deleteById(id);
    }
}
