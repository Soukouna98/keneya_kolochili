package com.keneya.kolochili.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.keneya.kolochili.MODEL.CategorieConseil;


@Repository
public interface CategorieConseilRepository extends JpaRepository<CategorieConseil, Long > {

    List<CategorieConseil> findByArchiveFalse();
}
