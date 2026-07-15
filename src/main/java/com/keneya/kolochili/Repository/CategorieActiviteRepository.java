package com.keneya.kolochili.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keneya.kolochili.MODEL.CategorieActivite;

public interface CategorieActiviteRepository extends JpaRepository<CategorieActivite, Long> {
    Optional<CategorieActivite> findByLibelle(String libelle);
}
