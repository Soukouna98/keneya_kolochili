package com.keneya.kolochili.Service.User;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.keneya.kolochili.Config.CurrentUserContext;
import com.keneya.kolochili.DTO.Request.User.AdminDTORequest;
import com.keneya.kolochili.Enumeration.TypeRole;
import com.keneya.kolochili.Exception.ForbiddenException;
import com.keneya.kolochili.IService.User.IServiceUser;
import com.keneya.kolochili.MODEL.Admin;
import com.keneya.kolochili.Mapper.Response.User.AdminDTOResponseMappper;
import com.keneya.kolochili.Repository.AdminRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final IServiceUser userService;
    private final AdminRepository adminRepository;
    private final AdminDTOResponseMappper adminDTOResponseMappper;

    public void modifier(AdminDTORequest entity, Long id) {
        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits d'administrateur");
        }
        if (!CurrentUserContext.get().getId().equals(id)) {
            throw new ForbiddenException(
                    "Vous ne pouvez modifier que votre propre compte");
        }
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Admin non trouve"));
        if (!Objects.equals(admin.getEmail(), entity.email())) {
            if (userService.findUserByEmail(entity.email()) != null) {
                throw new IllegalArgumentException("Email existe deja dans la base de donnee");
            }
        }

        admin.setNom(entity.nom());
        admin.setPrenom(entity.prenom());
        admin.setEmail(entity.email());
        admin.setPhone(entity.telephone());
        admin.setMdp(entity.password());
        adminRepository.save(admin);
    }

    public AdminDTOResponse getById(Long id) {
        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits d'administrateur");
        }
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agent non trouve"));
        return adminDTOResponseMappper.apply(admin);
    }

}
