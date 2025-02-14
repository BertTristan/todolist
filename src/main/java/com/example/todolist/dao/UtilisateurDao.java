    package com.example.todolist.dao;

    import com.example.todolist.model.Utilisateur;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    import java.util.Optional;

    @Repository
    public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
    }
