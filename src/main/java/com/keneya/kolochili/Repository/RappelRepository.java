package com.keneya.kolochili.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keneya.kolochili.MODEL.Rappel;

public interface RappelRepository extends JpaRepository <Rappel,Long> {

    List<Rappel> findByCitoyenIdAndArchiveFalseAndDateRappelLessThanEqual(Long citoyenId,  LocalDateTime now);

}
