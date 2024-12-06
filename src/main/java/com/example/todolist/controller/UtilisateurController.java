package com.example.todolist.controller;

import com.example.todolist.dao.UtilisateurDao;
import com.example.todolist.model.Utilisateur;
import com.example.todolist.view.UtilisateurView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurDao utilisateurDao;

    @GetMapping("/utilisateur")
    @JsonView(UtilisateurView.class)
    public List<Utilisateur> getAll() {
        return utilisateurDao.findAll();
    }

    @GetMapping("/utilisateur/{id}")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> get(@PathVariable Integer id){
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);
        if (optionalUtilisateur.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(optionalUtilisateur.get(),HttpStatus.OK);
    }

    @PostMapping("/utilisateur")
    public ResponseEntity<Utilisateur> create(
            @RequestBody @Valid Utilisateur utilisateur) {
        utilisateur.setId(null);
        utilisateur.setDroit(null);
        utilisateur.setPassword(utilisateur.getPassword());
        utilisateur.setPseudo(utilisateur.getPseudo());
        utilisateurDao.save(utilisateur);
        return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);

    }

    @PutMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> update(
            @RequestBody @Valid Utilisateur utilisateurEnvoye, @PathVariable Integer id) {
        utilisateurEnvoye.setId(id);
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);

        if(optionalUtilisateur.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Utilisateur utilisateurBaseDeDonee = optionalUtilisateur.get();

        if (utilisateurEnvoye.getPassword() != null){
            utilisateurEnvoye.setPassword(utilisateurEnvoye.getPassword());
        }
        if (utilisateurEnvoye.getPseudo() != null){
            utilisateurEnvoye.setPseudo(utilisateurEnvoye.getPseudo());
        }
        utilisateurDao.save(utilisateurEnvoye);
        return  new ResponseEntity<>(optionalUtilisateur.get(), HttpStatus.OK);
    }


    @DeleteMapping("utilisateur/{id}")
    public ResponseEntity<Utilisateur> delete(@PathVariable Integer id){
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);
        if (optionalUtilisateur.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        utilisateurDao.deleteById(id);
        return new ResponseEntity<>(optionalUtilisateur.get(), HttpStatus.OK);
    }
}
