package aon.pheno.keneya.Mapper.Request.User;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import aon.pheno.keneya.DTO.Request.User.AgentDTORequest;
import aon.pheno.keneya.Entity.User.Agent;

@Component
public class AgentDTORequestMapper implements Function<AgentDTORequest, Agent>{

    @Override
    public Agent apply(AgentDTORequest t) {
        Agent agent = new Agent();
        agent.setNom(t.nom());
        agent.setPrenom(t.prenom());
        agent.setEmail(t.email());
        agent.setPassword(t.password());
        agent.setPhone(t.telephone());
        agent.setSpecialite(t.specialite());
        return agent;
    }
}
