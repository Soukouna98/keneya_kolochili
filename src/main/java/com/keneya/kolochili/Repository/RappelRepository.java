package com.keneya.kolochili.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.keneya.kolochili.MODEL.Rappel;

public interface RappelRepository extends JpaRepository <Rappel,Long> {

    List<Rappel> findByCitoyenIdAndArchiveFalseAndDateRappelLessThanEqual(Long citoyenId,  LocalDateTime now);

	@Query("select r from Rappel r where r.citoyen.id = :citoyenId and r.archive = false and r.dateRappel <= :now")
	List<Rappel> findRappelDusParCitoyen( @Param("citoyenId") Long citoyenId, @Param("now") LocalDateTime now);


	@Query("select r from Rappel r where r.citoyen.id = :citoyenId and r.archive = false Order By r.dateRappel ASC")
	List<Rappel> findRappelActiveByCitoyen(@Param("citoyenId") Long citoyenID);
}
