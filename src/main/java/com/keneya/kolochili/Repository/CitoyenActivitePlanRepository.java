package com.keneya.kolochili.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keneya.kolochili.MODEL.CitoyenActivitePlan;

@Repository
public interface CitoyenActivitePlanRepository
        extends JpaRepository<CitoyenActivitePlan, Long> {

}