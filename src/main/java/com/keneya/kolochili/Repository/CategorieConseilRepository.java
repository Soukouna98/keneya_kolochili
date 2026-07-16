package com.keneya.kolochili.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keneya.kolochili.MODEL.CategorieConseil;


@Repository
public interface CategorieConseilRepository extends JpaRepository<CategorieConseil, Long > {
    Optional<CategorieConseil> findByNom(String libelle);
    List<CategorieConseil> findByArchiveFalse();
}
