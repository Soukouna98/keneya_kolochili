package com.keneya.kolochili.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aon.pheno.keneya.Entity.User.User;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
