package com.keneya.kolochili.Config;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.Repository.RoleRepository;
import com.keneya.kolochili.Repository.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Initialisateur {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Transactional
    @PostConstruct
    public void initialiser() {
        initRoles();
        initAdmin();
    }


    private void initAdmin() {
        String email = "amadou14112004@gmail.com";
        Role role = roleRepository.findByName(TypeRole.ADMIN).orElseThrow(() -> new RuntimeException("Role non trouve"));
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            User admin = new Admin();
            admin.setEmail(email);
            admin.setNom("pheno");
            admin.setPrenom("AON");
            admin.setPassword("admin123"); // Assurez-vous de hasher le mot de passe
            admin.setPhone("76662725");
            admin.setRole(role);
            userRepository.save(admin);
        } else {
            System.out.println("L'admin existe deja");
        }
    }

    private void initRoles() {
        for (TypeRole role : TypeRole.values()) {
            if (!roleRepository.findByName(role).isPresent()) {
                Role rolee = new Role();
                rolee.setName(role);
                roleRepository.save(rolee);
            }
        }
    }

}
