package com.keneya.kolochili.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aon.pheno.keneya.Entity.User.Citoyen;

public interface CitoyenRepository extends JpaRepository<Citoyen, Long>{

}
