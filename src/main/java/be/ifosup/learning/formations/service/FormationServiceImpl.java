package be.ifosup.learning.formations.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import be.ifosup.learning.formations.entities.Formation;
import be.ifosup.learning.formations.in.FormationIdIn;
import be.ifosup.learning.formations.in.FormationIn;
import be.ifosup.learning.formations.out.FormationOut;
import be.ifosup.learning.formations.repositories.FormationRepository;
import be.ifosup.learning.inscriptions.entities.Inscription;
import be.ifosup.learning.inscriptions.repositories.InscriptionRepository;
import be.ifosup.learning.types.entities.Type;
import be.ifosup.learning.types.repositories.TypeRepository;
import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class FormationServiceImpl implements FormationService {
    @Autowired
    private final FormationRepository formationRepository;
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final TypeRepository typeRepository;

    @Autowired
    private final InscriptionRepository inscriptionRepository;

    @Autowired
    public FormationServiceImpl(FormationRepository formationRepository, UserRepository userRepository, TypeRepository typeRepository, InscriptionRepository inscriptionRepository) {
        this.formationRepository = formationRepository;
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
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


        return formationOuts1;
    }

    @Override
    public FormationOut save(FormationIn formationIn) {

        Formation formation = Formation.builder()
                        .titre(formationIn.getTitre())
                        .num_eleve(formationIn.getNum_eleve())
                        .date_debut(formationIn.getDate_debut())
                        .date_fin(formationIn.getDate_fin())
                        .teacher(formationIn.getTeacher())
                        .type(formationIn.getType())
                        .build();
        Formation save = formationRepository.save(formation);
        return getFormationOut(save);
    }

    @Override
    public FormationOut update(Long id, FormationIdIn formationIdIn) {
        Formation formation = formationRepository.findById(id).get();

        Formation toSave = Formation.builder()
                .formation_id(formation.getFormation_id())
                .num_eleve(formationIdIn.getNum_eleve() == null ? formation.getNum_eleve() : formationIdIn.getNum_eleve())
                .titre(formationIdIn.getTitre() == null ? formation.getTitre() : formationIdIn.getTitre())
                .date_debut(formationIdIn.getDate_debut() == null ? formation.getDate_debut() : formationIdIn.getDate_debut())
                .date_fin(formationIdIn.getDate_fin() == null ? formation.getDate_fin() : formationIdIn.getDate_fin())
                .teacher(formationIdIn.getTeacher() == null ? formation.getTeacher() : formationIdIn.getTeacher())
                .type(formationIdIn.getType() == null ? formation.getType() : formationIdIn.getType())
                .build();

        Formation saved = formationRepository.save(toSave);
        return getFormationOut(saved);
    }

    @Override
    public FormationOut get(Long id) {
        Formation formation = formationRepository.findById(id).get();
        FormationOut formationOut = getFormationOut(formation);
        return formationOut;
    }

    private FormationOut getFormationOut(Formation formation) {
        User user = userRepository.getById(formation.getTeacher());
        Type type = typeRepository.getOne(formation.getType());
        Integer inscrit = inscriptionRepository.countByFormation_id(formation.getFormation_id());
        return FormationOut.builder()
                .formation_id(formation.getFormation_id())
                .num_eleve(formation.getNum_eleve())
                .titre(formation.getTitre())
                .date_debut(formation.getDate_debut())
                .date_fin(formation.getDate_fin())
                .teacher(formation.getTeacher())
                .type(formation.getType())
                .teachername(user.getUsername())
                .typename(type.getTitre())
                .num_inscrit(inscrit)
                .build();
    }

    @Override
    public void delete(Long id) {
        formationRepository.deleteById(id);
    }

    @Override
    public List<FormationOut> listbyTeacher(Long teacher) {
        List<Formation> formationRepositoryAll = formationRepository.findByTeacher(teacher);

        List<FormationOut> formationOuts = formationRepositoryAll
                .stream()
                .map(formation -> getFormationOut(formation))
                .collect(Collectors.toList());

        return formationOuts;
    }


}
