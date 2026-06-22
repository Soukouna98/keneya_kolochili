package com.keneya.kolochili.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keneya.kolochili.MODEL.Utilisateur;


public interface UserRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByEmail(String email);
}
