package com.mpeven.demo.controller;

import com.mpeven.demo.dao.PaysDao;
import com.mpeven.demo.model.Pays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PaysController {

    @Autowired
    private PaysDao paysDao;

    @GetMapping("/pays/{id}")
    public ResponseEntity<Pays> getPays(@PathVariable int id) {

        Optional<Pays> paysExistant = paysDao.findById(id);

        if (paysExistant.isPresent()) {
            return new ResponseEntity<>(paysExistant.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/liste-pays")
    public List<Pays> getListePays() {
        return paysDao.findAll();

    }

    @PostMapping("/pays")
    public ResponseEntity<Pays> ajoutPays(@RequestBody Pays pays) {

        if (pays.getId() != null) {
            Optional<Pays> paysExistant = paysDao.findById(pays.getId());

            if (paysExistant.isPresent()) {
                paysDao.save(pays);
                return new ResponseEntity<>(pays, HttpStatus.OK);
            } else {

                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            }

        } else {
            paysDao.save(pays);
            return new ResponseEntity<>(pays, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/pays/{id}")
    public ResponseEntity<Pays> deletePays(@PathVariable int id) {

        Optional<Pays> paysExistant = paysDao.findById(id);

        if (paysExistant.isPresent()) {
            paysDao.deleteById(id);
            return new ResponseEntity<>(paysExistant.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
