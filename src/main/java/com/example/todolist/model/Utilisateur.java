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
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cle primaire
    @JsonView({UtilisateurView.class, DroitView.class})
    Integer id;

    @Column(length = 100, unique = true, nullable = false)
    @JsonView({UtilisateurView.class, DroitView.class})
    String pseudo;

    @JsonView(UtilisateurView.class)
    String password;

    @ManyToMany(mappedBy = "utilisateursAffectes")
    @JsonView(UtilisateurView.class)
    List<Tache> affectationsTaches;

    @OneToMany(mappedBy = "createur")
    @JsonView(UtilisateurView.class)
    List<Tache> tachesCreees;

    @ManyToOne
    @JsonView(UtilisateurView.class)
    Droit droit;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setDroit(Droit droit) {
        this.droit = droit;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getPseudo() {
        return pseudo;
    }

    public Integer getId() {
        return id;
    }

    public List<Tache> getAffectationsTaches() {
        return affectationsTaches;
    }

    public void setAffectationsTaches(List<Tache> affectationsTaches) {
        this.affectationsTaches = affectationsTaches;
    }

    public List<Tache> getTachesCreees() {
        return tachesCreees;
    }

    public void setTachesCreees(List<Tache> tachesCreees) {
        this.tachesCreees = tachesCreees;
    }

    public Droit getDroit() {
        return droit;
    }
}
