package com.mpeven.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mpeven.demo.dao.UtilisateurDao;
import com.mpeven.demo.model.Utilisateur;
import com.mpeven.demo.view.VueUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UtilisateurController {

    @Autowired
    private UtilisateurDao utilisateurDao;

    @GetMapping("/utilisateur/{id}")
    @JsonView(VueUtilisateur.class)
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable int id) {

        Optional<Utilisateur> utilisateurExistant = utilisateurDao.findById(id);

        if (utilisateurExistant.isPresent()) {
            return new ResponseEntity<>(utilisateurExistant.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/utilisateurs")
    @JsonView(VueUtilisateur.class)
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurDao.findAll();

    }

    @PostMapping("/utilisateur")
    public ResponseEntity<Utilisateur> ajoutUtilisateur(@RequestBody Utilisateur utilisateur) {

        if (utilisateur.getId() != null) {
            Optional<Utilisateur> utilisateurExistant = utilisateurDao.findById(utilisateur.getId());

            if (utilisateurExistant.isPresent()) {
                utilisateurDao.save(utilisateur);
                return new ResponseEntity<>(utilisateur, HttpStatus.OK);
            } else {

                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            }

        } else {
            utilisateurDao.save(utilisateur);
            return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> deleteUtilisateur(@PathVariable int id) {

        Optional<Utilisateur> utilisateurExistant = utilisateurDao.findById(id);

        if (utilisateurExistant.isPresent()) {
            utilisateurDao.deleteById(id);
            return new ResponseEntity<>(utilisateurExistant.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
