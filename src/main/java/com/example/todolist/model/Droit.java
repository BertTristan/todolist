package com.example.todolist.model;

import com.example.todolist.view.DroitView;
import com.example.todolist.view.UtilisateurView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Droit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UtilisateurView.class, DroitView.class})
    Integer id;

    @Column(length = 100, unique = true)
    @JsonView({UtilisateurView.class, DroitView.class})
    String nom;

    @OneToMany(mappedBy = "droit")
    @JsonView(DroitView.class)
    List<Utilisateur> utilisateurs_droit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Utilisateur> getUtilisateurs_droit() {
        return utilisateurs_droit;
    }

    public void setUtilisateurs_droit(List<Utilisateur> utilisateurs_droit) {
        this.utilisateurs_droit = utilisateurs_droit;
    }
}
