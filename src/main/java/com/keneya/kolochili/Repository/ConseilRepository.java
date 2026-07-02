package com.keneya.kolochili.Repository;

import com.keneya.kolochili.MODEL.Conseil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConseilRepository extends JpaRepository<Conseil, Integer> {
}