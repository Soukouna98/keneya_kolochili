package com.keneya.kolochili.Service.User;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final IServiceUser userService;
    private final RoleRepository roleRepository;
    private final AgentRepository agentRepository;
    private final AgentDTORequestMapper agentDTORequestMapper;
    private final AgentDTOResponseMappper agentDTOResponseMappper;

    public void creer(AgentDTORequest entity) {
        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits d'administrateur");
        }
        if (userService.findUserByEmail(entity.email()) != null) {
            throw new IllegalArgumentException("Email existe deja dans la base de donnee");
        }
        Optional<Role> role = roleRepository.findByName(TypeRole.AGENT);
        if (role.isEmpty()) {
            throw new IllegalArgumentException("Role n'existe pas dans la base de donnee");
        }
        Agent agent = agentDTORequestMapper.apply(entity);
        agent.setRole(role.get());
        agentRepository.save(agent);
    }

    public void modifier(AgentDTORequest entity, Long id) {
        if (!TypeRole.AGENT.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits d'agent");
        }
        if (!CurrentUserContext.get().getId().equals(id)) {
            throw new ForbiddenException(
                    "Vous ne pouvez modifier que votre propre compte");
        }
        Agent agent = agentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agent non trouve"));
        if (!Objects.equals(agent.getEmail(), entity.email())) {
            if (userService.findUserByEmail(entity.email()) != null) {
                throw new IllegalArgumentException("Email existe deja dans la base de donnee");
            }
        }

        agent.setNom(entity.nom());
        agent.setPrenom(entity.prenom());
        agent.setEmail(entity.email());
        agent.setPhone(entity.telephone());
        agent.setPassword(entity.password());
        agent.setSpecialite(entity.specialite());
        agentRepository.save(agent);
    }

    public AgentDTOResponse getById(Long id) {
        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits d'administrateur");
        }
        Agent agent = agentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agent non trouve"));
        return agentDTOResponseMappper.apply(agent);
    }

    public List<AgentDTOResponse> getAll() {
        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits d'administrateur");
        }
        List<Agent> agents = agentRepository.findAll();
        return agents.stream().map(agentDTOResponseMappper::apply).toList();
    }

    public void archiver(Long id) {
        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits d'administrateur");
        }
        Agent agent = agentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agent non trouve"));
        agent.setArchive(true);
        agentRepository.save(agent);
    }

    public void deArchiver(Long id) {
        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas les droits d'administrateur");
        }
        Agent agent = agentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agent non trouve"));
        agent.setArchive(false);
        agentRepository.save(agent);
    }

}
