package aon.pheno.keneya.Service.User;

import java.util.Objects;

import org.springframework.stereotype.Service;

import aon.pheno.keneya.Config.CurrentUserContext;
import aon.pheno.keneya.DTO.Request.User.AdminDTORequest;
import aon.pheno.keneya.DTO.Response.User.AdminDTOResponse;
import aon.pheno.keneya.Entity.User.Admin;
import aon.pheno.keneya.Enumeration.TypeRole;
import aon.pheno.keneya.Exception.ForbiddenException;
import aon.pheno.keneya.IService.User.IServiceUser;
import aon.pheno.keneya.Mapper.Response.User.AdminDTOResponseMappper;
import aon.pheno.keneya.Repository.User.AdminRepository;
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
        admin.setPassword(entity.password());
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
