package be.ifosup.learning.inscriptions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import be.ifosup.learning.inscriptions.entities.Inscription;
import be.ifosup.learning.inscriptions.in.InscriptionIn;
import be.ifosup.learning.inscriptions.out.InscriptionOut;
import be.ifosup.learning.inscriptions.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InscriptionServiceImpl implements InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;


    @Autowired
    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;

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
            //usersOuts1.add(userRepository.findById(formation.getTeacher()));
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

    private static InscriptionOut getInscriptionOut(Inscription inscription) {
        return InscriptionOut.builder()
                .inscription_id(inscription.getInscription_id())
                .student_id(inscription.getStudent_id())
                .formation_id(inscription.getFormation_id())

                .build();
    }

    public void delete(Long id) {
        inscriptionRepository.deleteById(id);
    }

//    @Override
//    public List<InscriptionOut> listbyUser(Long user) {
//        List<Inscription> inscriptionRepositoryAll = inscriptionRepository.findByUser(user);
//
//        List<InscriptionOut> inscriptionOuts = inscriptionRepositoryAll
//                .stream()
//                .map(formation -> getInscriptionOut(inscription))
//                .collect(Collectors.toList());
//
//        return inscriptionOuts;
//    }
}