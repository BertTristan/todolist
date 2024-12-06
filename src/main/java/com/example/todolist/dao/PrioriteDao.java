package com.example.todolist.dao;

import com.example.todolist.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrioriteDao extends JpaRepository<Tache, Integer> {

}
