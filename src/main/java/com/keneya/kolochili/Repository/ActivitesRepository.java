package com.keneya.kolochili.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keneya.kolochili.MODEL.Activites;

@Repository
public interface ActivitesRepository extends JpaRepository<Activites, Long> {

}