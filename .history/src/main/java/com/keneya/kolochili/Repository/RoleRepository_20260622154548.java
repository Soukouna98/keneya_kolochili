package com.keneya.kolochili.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keneya.kolochili.Enumeration.TypeRole;
import com.keneya.kolochili.MODEL.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(TypeRole nom);
}
