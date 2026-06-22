package aon.pheno.keneya.Config;

import org.springframework.stereotype.Component;

import aon.pheno.keneya.Entity.Role;
import aon.pheno.keneya.Entity.TypeConseil;
import aon.pheno.keneya.Entity.User.Admin;
import aon.pheno.keneya.Entity.User.User;
import aon.pheno.keneya.Enumeration.TypeConseilEnum;
import aon.pheno.keneya.Enumeration.TypeRole;
import aon.pheno.keneya.Repository.RoleRepository;
import aon.pheno.keneya.Repository.TypeConseilRepository;
import aon.pheno.keneya.Repository.User.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Initialisateur {

    private final RoleRepository roleRepository;
    private final TypeConseilRepository typeConseilRepository;
    private final UserRepository userRepository;

    @Transactional
    @PostConstruct
    public void initialiser() {
        initTypeConseil();
        initRoles();
        initAdmin();
    }

    private void initTypeConseil() {
        for (TypeConseilEnum typeConseilEnum : TypeConseilEnum.values()) {
            if (!typeConseilRepository.findByName(typeConseilEnum).isPresent()) {
                TypeConseil typeConseil = new TypeConseil();
                typeConseil.setName(typeConseilEnum);
                typeConseilRepository.save(typeConseil);
            }
        }
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
