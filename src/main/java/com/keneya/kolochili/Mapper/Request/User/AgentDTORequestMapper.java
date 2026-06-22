package com.keneya.kolochili.Mapper.Request.User;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Request.User.AgentDTORequest;
import com.keneya.kolochili.MODEL.Agent;


@Component
public class AgentDTORequestMapper implements Function<AgentDTORequest, Agent>{

    @Override
    public Agent apply(AgentDTORequest t) {
        Agent agent = new Agent();
        agent.setNom(t.nom());
        agent.setPrenom(t.prenom());
        agent.setEmail(t.email());
        agent.setMdp(t.password());
        agent.setPhone(t.telephone());
        agent.setSpecialite(t.specialite());
        return agent;
    }
}
