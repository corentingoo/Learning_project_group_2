package be.ifosup.learning.inscriptions.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import be.ifosup.learning.formations.entities.Formation;
import be.ifosup.learning.formations.out.FormationOut;
import be.ifosup.learning.inscriptions.entities.Inscription;
import be.ifosup.learning.inscriptions.in.InscriptionIn;
import be.ifosup.learning.inscriptions.out.InscriptionOut;
import be.ifosup.learning.inscriptions.repositories.InscriptionRepository;
import be.ifosup.learning.users.service.UserService;
import be.ifosup.learning.formations.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscriptionServiceImpl implements InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private FormationService formationService;


    @Autowired
    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository, UserService userService, FormationService formationService) {
        this.inscriptionRepository = inscriptionRepository;
        this.userService = userService;
        this.formationService = formationService;

    }

    public List<InscriptionOut> listAll() {
        List<Inscription> inscriptionRepositoryAll = inscriptionRepository.findAll();

        List<InscriptionOut> inscriptionOuts = inscriptionRepositoryAll
                .stream()
                .map(inscription -> getInscriptionOut(inscription))
                .collect(Collectors.toList());

        //2eme méthode pour lister toutes les formations avec une méthode de boucle

        List<InscriptionOut> inscriptionOuts1 = new ArrayList<>();
        for (Inscription inscription :inscriptionRepositoryAll) {
            inscriptionOuts1.add(getInscriptionOut(inscription));
        }


        return inscriptionOuts1;
    }

    public InscriptionOut save(InscriptionIn inscriptionIn) {

        Inscription inscription = Inscription.builder()
                .student_id(inscriptionIn.getStudent_id())
                .formation_id(inscriptionIn.getFormation_id())
                .build();
        Inscription save = inscriptionRepository.save(inscription);
        return getInscriptionOut(save);
    }

    @Override
    public InscriptionOut update(Long id, InscriptionIn inscriptionIn) {
        Inscription inscription = inscriptionRepository.findById(id).get();

        Inscription toSave = Inscription.builder()
                .inscription_id(inscription.getInscription_id())
                .student_id(inscription.getStudent_id())
                .formation_id(inscription.getFormation_id())
                .build();

        Inscription saved = inscriptionRepository.save(toSave);
        return getInscriptionOut(saved);
    }

    public InscriptionOut get(Long id) {
        Inscription inscription = inscriptionRepository.findById(id).get();
        InscriptionOut inscriptionOut = getInscriptionOut(inscription);
        return inscriptionOut;
    }

    private InscriptionOut getInscriptionOut(Inscription inscription) {
        String username = userService.get(inscription.getStudent_id()).getUsername();
        String titre = formationService.get(inscription.getFormation_id()).getTitre();
        Date date_debut = formationService.get(inscription.getFormation_id()).getDate_debut();
        Date date_fin = formationService.get(inscription.getFormation_id()).getDate_fin();
        return InscriptionOut.builder()
                .inscription_id(inscription.getInscription_id())
                .username(username)
                .titre(titre)
                .date_debut(date_debut != null ? date_debut.toString() : "")
                .date_fin(date_fin != null ? date_fin.toString() : "")
                .build();
    }

    public void delete(Long id) {
        inscriptionRepository.deleteById(id);
    }

    @Override
        public List<InscriptionOut> findAllByStudentId(Long student) {
            List<Inscription> inscriptionRepositoryAll = inscriptionRepository.findAllByStudentId(student);

            List<InscriptionOut> formationOuts = inscriptionRepositoryAll
                    .stream()
                    .map(formation -> getInscriptionOut(formation))
                    .collect(Collectors.toList());

            return formationOuts;
        }

    @Override
    public boolean inscriptionExist(Long student_id, Long formation_id) {
        Inscription inscription = inscriptionRepository.findByStudent_idAndFormation_id(student_id, formation_id);
        if(inscription == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean inscriptionPossible(Long formation_id) {
        Integer numinscrit = inscriptionRepository.countByFormation_id(formation_id);
        Integer numpossible = formationService.get(formation_id).getNum_eleve();
        if(numpossible <= numinscrit){
            return false;
        } else {
            return true;
        }
    }

}