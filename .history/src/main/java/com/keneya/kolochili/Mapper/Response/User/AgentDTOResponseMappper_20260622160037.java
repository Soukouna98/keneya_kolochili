package com.keneya.kolochili.Mapper.Response.User;

import java.util.function.Function;

import org.springframework.stereotype.Component;



@Component
public class AgentDTOResponseMappper implements Function<Agent,AgentDTOResponse> {

    @Override
    public AgentDTOResponse apply(Agent t) {
        return new AgentDTOResponse(t.getId(),t.getNom(),t.getPrenom(),t.getEmail(),t.getPhone(),t.getSpecialite(),t.isArchive(),t.getDateCreation());
    }
}
