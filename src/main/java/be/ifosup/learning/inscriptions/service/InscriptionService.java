package be.ifosup.learning.inscriptions.service;

import be.ifosup.learning.inscriptions.out.InscriptionOut;
import be.ifosup.learning.inscriptions.in.InscriptionIn;
import be.ifosup.learning.users.entities.User;

import java.util.List;

public interface InscriptionService {
    List<InscriptionOut> listAll();

    InscriptionOut save(InscriptionIn inscriptionIn);

    InscriptionOut update(Long id, InscriptionIn inscriptionIn);

    InscriptionOut get(Long id) ;

    void delete(Long id);

    //List<InscriptionOut> listbyUser(Long id);
}