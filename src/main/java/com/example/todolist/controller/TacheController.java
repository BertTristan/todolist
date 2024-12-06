package com.example.todolist.controller;

import com.example.todolist.dao.PrioriteDao;
import com.example.todolist.dao.TacheDao;
import com.example.todolist.model.Priorite;
import com.example.todolist.model.Tache;
import com.example.todolist.model.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class TacheController {

    @Autowired
    private TacheDao tacheDao;

    @GetMapping("/tache")
    public List<Tache> getAll() {
        return tacheDao.findAll();
    }

    @GetMapping("/tache/{id}")
    public ResponseEntity<Tache> get(@PathVariable Integer id){
        Optional<Tache> optionalTache = tacheDao.findById(id);
        if (optionalTache.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(optionalTache.get(),HttpStatus.OK);
    }
}
