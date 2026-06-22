package com.keneya.kolochili.Service.User;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keneya.kolochili.Config.CurrentUserContext;
import com.keneya.kolochili.DTO.Request.User.CitoyenDTORequest;
import com.keneya.kolochili.Enumeration.TypeRole;
import com.keneya.kolochili.Exception.ForbiddenException;
import com.keneya.kolochili.IService.User.IServiceUser;
import com.keneya.kolochili.MODEL.Citoyen;
import com.keneya.kolochili.MODEL.Role;
import com.keneya.kolochili.Mapper.Request.User.CitoyenDTORequestMapper;
import com.keneya.kolochili.Mapper.Response.User.CitoyenDTOResponseMappper;
import com.keneya.kolochili.Repository.CitoyenRepository;
import com.keneya.kolochili.Repository.RoleRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitoyenService {

    private final IServiceUser userService;
    private final RoleRepository roleRepository;
    private final CitoyenRepository citoyenRepository;
    private final CitoyenDTORequestMapper citoyenDTORequestMapper;
    private final CitoyenDTOResponseMappper citoyenDTOResponseMappper;

    public void creer(CitoyenDTORequest entity) {
        if (userService.findUserByEmail(entity.email()) != null) {
            throw new IllegalArgumentException("Email existe deja dans la base de donnee");
        }
        Optional<Role> role = roleRepository.findByName(TypeRole.CITOYEN);
        if (role.isEmpty()) {
            throw new IllegalArgumentException("Role n'existe pas dans la base de donnee");
        }
        Citoyen citoyen = citoyenDTORequestMapper.apply(entity);
        citoyen.setRole(role.get());
        citoyenRepository.save(citoyen);
    }

    public void modifier(CitoyenDTORequest entity, Long id) {
        if (!TypeRole.CITOYEN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits de citoyen");
        }
        if (!CurrentUserContext.get().getId().equals(id)) {
            throw new ForbiddenException(
                    "Vous ne pouvez modifier que votre propre compte");
        }
        Citoyen citoyen = citoyenRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Citoyen non trouve"));
        if (!Objects.equals(citoyen.getEmail(), entity.email())) {
            if (userService.findUserByEmail(entity.email()) != null) {
                throw new IllegalArgumentException("Email existe deja dans la base de donnee");
            }
        }

        citoyen.setNom(entity.nom());
        citoyen.setPrenom(entity.prenom());
        citoyen.setEmail(entity.email());
        citoyen.setPhone(entity.telephone());
        citoyen.setMdp(entity.password());
        citoyen.setDate_naissance(entity.date_naissance());
        citoyenRepository.save(citoyen);
    }

    public CitoyenDTOResponse getById(Long id) {
        Citoyen citoyen = citoyenRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("citoyen non trouve"));
        return citoyenDTOResponseMappper.apply(citoyen);
    }

    public List<CitoyenDTOResponse> getAll() {
        List<Citoyen> citoyens = citoyenRepository.findAll();
        return citoyens.stream().map(citoyenDTOResponseMappper::apply).toList();
    }

    public void archiver(Long id) {
        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits d'administrateur");
        }
        Citoyen citoyen = citoyenRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agent non trouve"));
        citoyen.setArchive(true);
        citoyenRepository.save(citoyen);
    }

    public void deArchiver(Long id) {
        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits d'administrateur");
        }
        Citoyen citoyen = citoyenRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agent non trouve"));
        citoyen.setArchive(false);
        citoyenRepository.save(citoyen);
    }
}
