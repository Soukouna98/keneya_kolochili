package com.keneya.kolochili.Mapper.Response.User;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Response.User.AgentDTOResponse;
import com.keneya.kolochili.MODEL.Agent;



@Component
public class AgentDTOResponseMappper implements Function<Agent,AgentDTOResponse> {

    @Override
    public AgentDTOResponse apply(Agent t) {
        return new AgentDTOResponse();
    }
}
