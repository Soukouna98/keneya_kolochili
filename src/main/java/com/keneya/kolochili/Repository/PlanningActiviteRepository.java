package com.keneya.kolochili.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keneya.kolochili.MODEL.PlanningActivite;

@Repository
public interface PlanningActiviteRepository
        extends JpaRepository<PlanningActivite, Long> {

}