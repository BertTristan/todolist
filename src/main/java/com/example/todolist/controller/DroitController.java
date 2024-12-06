package com.example.todolist.controller;

import com.example.todolist.dao.DroitDao;
import com.example.todolist.model.Droit;
import com.example.todolist.model.Droit;
import com.example.todolist.view.DroitView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class DroitController {

    @Autowired
    private DroitDao droitDao;

    @GetMapping("/droit")
    @JsonView(DroitView.class)
    public List<Droit> getAll() {
        return droitDao.findAll();
    }

    @GetMapping("/droit/{id}")
    @JsonView(DroitView.class)
    public ResponseEntity<Droit> get(@PathVariable Integer id){
        Optional<Droit> optionalDroit = droitDao.findById(id);
        if (optionalDroit.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(optionalDroit.get(),HttpStatus.OK);
    }
    //@PostMapping("/droit")
}
