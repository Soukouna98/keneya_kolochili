package com.keneya.kolochili.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aon.pheno.keneya.Entity.Role;
import aon.pheno.keneya.Enumeration.TypeRole;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(TypeRole nom);
}
