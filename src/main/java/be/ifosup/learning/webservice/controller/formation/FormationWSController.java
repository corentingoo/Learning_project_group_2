package be.ifosup.learning.webservice.controller.formation;

import java.util.*;

import be.ifosup.learning.formations.in.FormationIn;
import be.ifosup.learning.formations.out.FormationOut;
import be.ifosup.learning.formations.service.FormationService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ws/formations")
public class FormationWSController {
    @Autowired
    private FormationService formationservice;

    // REST API methods for Retrieval operations
    @GetMapping()
    public List<FormationOut> list() {

        return formationservice.listAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<FormationOut> get(@PathVariable Long id) {
        try {
            FormationOut formation = formationservice.get(id);
            return new ResponseEntity<FormationOut>(formation, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<FormationOut>(HttpStatus.NOT_FOUND);
        }
    }

    // REST API method for Create operation

    @PostMapping()
    public FormationOut add(@RequestBody FormationIn formation) {
        return formationservice.save(formation);
    }

    // REST API method for Update operation

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody FormationIn formation, @PathVariable Long id) {
        try {
            FormationOut save = formationservice.update(id, formation);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // REST API method for Delete operation

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        formationservice.delete(id);
    }



}
