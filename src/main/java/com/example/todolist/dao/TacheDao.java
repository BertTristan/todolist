package com.example.todolist.dao;

import com.example.todolist.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheDao extends JpaRepository<Tache, Integer> {

}
