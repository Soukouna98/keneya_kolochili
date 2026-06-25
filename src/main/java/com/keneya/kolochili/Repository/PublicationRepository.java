package com.keneya.kolochili.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keneya.kolochili.MODEL.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long>{
    List<Publication> findByArchiveFalse();
    List<Publication> findByArchiveTrue();

    
    

}
